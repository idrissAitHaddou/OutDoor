package com.outdoor.order.command;

import com.outdoor.order.panier.PanierProducts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "commands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String adress;
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    @Column(name = "id_user", nullable = false)
    private int idUser;
    @OneToMany
    @JoinColumn()
    private List<CommandProducts> commandProducts;
}
