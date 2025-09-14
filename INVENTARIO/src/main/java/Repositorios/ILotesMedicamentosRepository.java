package Repositorios;

import Modelos.Lotes_medicamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILotesMedicamentosRepository extends JpaRepository<Lotes_medicamentos, Integer> {
}
