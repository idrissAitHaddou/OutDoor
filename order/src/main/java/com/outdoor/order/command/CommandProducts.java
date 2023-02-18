package com.outdoor.order.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.outdoor.order.panier.Panier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "command_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_product", nullable = false)
    private int idProduct;

    @Column(nullable = false)
    private int qteProduct;

    @OneToOne
    @JoinColumn
    private Command command;

    @Override
    public String toString() {
        return "CommandProducts{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", qteProduct=" + qteProduct +
                ", command=" + command +
                '}';
    }
}
