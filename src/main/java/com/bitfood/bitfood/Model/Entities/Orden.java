package com.bitfood.bitfood.Model.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orden")
public class Orden {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String fecha;


    @ManyToOne()
    @JoinColumn(name="restauranteId")
    private Restaurante restaurante;

    @ManyToOne()
    @JoinColumn(name="clienteId")
    private Cliente cliente;



}
