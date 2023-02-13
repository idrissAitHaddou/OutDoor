package com.outdoor.order.responce;

import com.outdoor.order.command.CommandProducts;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommandResponce {
    private Long id;
    private String status;
    private String adress;
    private String createdAt;
    private int idUser;
    private List<CommandProducts> commandProductsList = new ArrayList<>();
}
