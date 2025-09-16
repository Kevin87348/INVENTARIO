package INVENTARIO.repositorios;

import INVENTARIO.modelos.medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicamentoRepository  extends JpaRepository<medicamento, Integer>{
}

