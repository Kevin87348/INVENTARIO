package INVENTARIO.Repositorios;

import INVENTARIO.Modelos.medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicamentoRepository  extends JpaRepository<medicamento, Integer>{
}

