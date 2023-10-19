package com.bitfood.bitfood.Model.Dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String usuario;
    String contrasena;
    String nombres;
    String apellidos;
    String correo;
}