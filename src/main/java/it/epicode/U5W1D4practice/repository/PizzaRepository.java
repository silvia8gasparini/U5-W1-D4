package it.epicode.U5W1D4practice.repository;

import it.epicode.U5W1D4practice.bean.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    List<Pizza> findByNameContainingIgnoreCase(String name);
}