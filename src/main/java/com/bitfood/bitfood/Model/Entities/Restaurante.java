package com.bitfood.bitfood.Model.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurante")
public class Restaurante {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String descripcion;
    private Long cantidad;
    private Long estrellas;
    private String fecha;

    @ManyToOne()
    @JoinColumn(name="idPlato")
    private Plato plato;

}
