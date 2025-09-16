package INVENTARIO.repositorios;

import INVENTARIO.modelos.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInventarioRepository extends JpaRepository<Inventario, Integer> {
    List<Inventario> findByAlmacenId(Integer id);
    List<Inventario> findByMedicamentoId(Integer id);
}
