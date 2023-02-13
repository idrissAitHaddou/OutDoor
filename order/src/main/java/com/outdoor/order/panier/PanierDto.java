package com.outdoor.order.panier;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PanierDto {
    private Long id;
    private int idUser;
    private List<PanierProducts> panierProducts = new ArrayList<>();
}
