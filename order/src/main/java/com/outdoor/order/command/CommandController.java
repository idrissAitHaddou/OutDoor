package com.outdoor.order.command;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/command")
@RequiredArgsConstructor
public class CommandController {

    private final CommandService commandService;

    @PostMapping("/create")
    public void creatCommand(@RequestBody CommandDto commandDto){
        commandService.creatCommand(commandDto);
    }

}
