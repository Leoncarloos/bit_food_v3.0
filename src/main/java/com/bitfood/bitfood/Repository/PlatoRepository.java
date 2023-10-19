package com.bitfood.bitfood.Repository;

import com.bitfood.bitfood.Model.Entities.Orden;
import com.bitfood.bitfood.Model.Entities.Plato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatoRepository extends JpaRepository<Plato, Long> {

}
