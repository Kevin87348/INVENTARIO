package INVENTARIO.repositorios;

import INVENTARIO.modelos.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicamentoRepository  extends JpaRepository<Medicamento, Integer>{
}

