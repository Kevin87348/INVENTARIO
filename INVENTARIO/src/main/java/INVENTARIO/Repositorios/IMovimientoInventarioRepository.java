package INVENTARIO.Repositorios;

import INVENTARIO.Modelos.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Integer> {
    List<MovimientoInventario> findByAlmacenId(Integer id);
    List<MovimientoInventario> findByUsuarioId(Integer id);;
}
