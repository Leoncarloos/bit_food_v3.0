package com.bitfood.bitfood.Repository;
import com.bitfood.bitfood.Model.Dtos.OrdenDto;
import com.bitfood.bitfood.Model.Entities.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden,Long> {
    @Query(value = "SELECT o. * FROM Orden o JOIN Cliente c ON c.id = o.cliente_id WHERE c.id=:clienteId",nativeQuery = true)
    List<Orden> buscarOrdenPorCliente(Long clienteId);

}
