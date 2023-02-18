package com.outdoor.order.command;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommandDto {
    private Long id;
    private String status;
    private String adress;
    private int idUser;
    private List<CommandProducts> commandProductsList;
}
