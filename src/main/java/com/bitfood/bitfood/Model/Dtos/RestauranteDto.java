package com.bitfood.bitfood.Model.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteDto implements Serializable {
    private Long Id;
    private Long platoId;
    private String nombre;
    private String descripcion;
    private Long cantidad;
    private Long estrellas;
    private String fecha;
}
