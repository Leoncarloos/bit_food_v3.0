package com.bitfood.bitfood.Repository;

import com.bitfood.bitfood.Model.Entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {
}
