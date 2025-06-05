package it.epicode.U5W1D4practice.repository;

import it.epicode.U5W1D4practice.bean.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping, Integer> {
    List<Topping> findByNameContainingIgnoreCase(String name);
}
