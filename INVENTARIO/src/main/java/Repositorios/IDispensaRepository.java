package Repositorios;

import Modelos.Dispensa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDispensaRepository extends JpaRepository<Dispensa, Integer> {
}
