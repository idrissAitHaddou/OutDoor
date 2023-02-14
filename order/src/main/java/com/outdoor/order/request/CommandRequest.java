package com.outdoor.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandRequest {
    @NotNull(message = "status is adress")
    private String adress;
    @NotNull(message = "status is required")
    private int idUser;
}