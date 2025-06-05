package it.epicode.U5W1D4practice.repository;

import it.epicode.U5W1D4practice.bean.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdineRepository extends JpaRepository<Ordine, Integer> {
}