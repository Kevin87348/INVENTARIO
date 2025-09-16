package INVENTARIO.repositorios;

import INVENTARIO.modelos.MovimientoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovimientoDetalleRepository extends JpaRepository<MovimientoDetalle, Integer> {
    List<MovimientoDetalle> findByMovimientoInventarioId(Integer id);
    List<MovimientoDetalle> findByMedicamentoId(Integer id);
    List<MovimientoDetalle> findByLoteMedicamentoId(Integer id);
}

