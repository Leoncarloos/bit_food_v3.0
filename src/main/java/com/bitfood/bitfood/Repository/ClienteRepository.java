package com.bitfood.bitfood.Repository;

import com.bitfood.bitfood.Model.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query(value = "SELECT * FROM Cliente p WHERE p.contrasena LIKE %?1%",nativeQuery = true)
    Optional<Cliente> encontrarPorContrasena(String clienteContrasena);

}
