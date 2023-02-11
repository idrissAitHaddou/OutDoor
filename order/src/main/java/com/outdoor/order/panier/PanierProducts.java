package com.outdoor.order.panier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "panier_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PanierProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_product", nullable = false)
    private String idProduct;
    @OneToOne
    @JoinColumn
    private Panier panier;
}
