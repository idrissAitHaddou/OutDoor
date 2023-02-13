package com.outdoor.order.responce;

import com.outdoor.order.command.CommandProducts;
import com.outdoor.order.panier.PanierProducts;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PanierResponce {
    private Long id;
    private int idUser;
    private List<PanierProducts> panierProducts = new ArrayList<>();
}
