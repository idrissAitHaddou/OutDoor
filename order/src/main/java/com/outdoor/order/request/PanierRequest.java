package com.outdoor.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PanierRequest {
    @NotNull(message = "status is required")
    private int idUser;
}