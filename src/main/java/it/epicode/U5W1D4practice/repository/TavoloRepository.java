package it.epicode.U5W1D4practice.repository;

import it.epicode.U5W1D4practice.bean.Tavolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TavoloRepository extends JpaRepository<Tavolo, Integer> {
}