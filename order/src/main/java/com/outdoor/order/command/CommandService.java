package com.outdoor.order.command;

import com.outdoor.order.commandProduct.CommandProductsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandService {


    private final CommandRepository commandRepository;
    private final CommandProductsRepository commandProductsRepository;

    public void creatCommand(CommandDto commandDto){
        Date date = new Date();
        ModelMapper modelMapper = new ModelMapper();
        Command command = modelMapper.map(commandDto, Command.class);
        command.setCreatedAt(date);


        Command command1 = commandRepository.save(command);
        List<CommandProducts> commandProductsLists = new ArrayList<>();
        for (CommandProducts commandProducts:commandDto.getCommandProductsList()) {
//            CommandProducts commandProducts1 = modelMapper.map(commandProducts,CommandProducts.class);
            commandProducts.setCommand(command1);
            commandProductsLists.add(commandProducts);
        }

        command1.setCommandProducts(commandProductsLists);
        commandRepository.save(command1);
        commandProductsRepository.saveAll(commandProductsLists);
    }

}
