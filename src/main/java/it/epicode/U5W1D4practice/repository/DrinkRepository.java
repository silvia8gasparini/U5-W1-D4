package it.epicode.U5W1D4practice.repository;

import it.epicode.U5W1D4practice.bean.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    List<Drink> findByNameContainingIgnoreCase(String name);
}