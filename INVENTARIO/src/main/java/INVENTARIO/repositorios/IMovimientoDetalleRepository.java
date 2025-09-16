package INVENTARIO.repositorios;

import INVENTARIO.modelos.MovimientoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovimientoDetalleRepository extends JpaRepository<MovimientoDetalle, Integer> {
    List<MovimientoDetalle> findByMovimientoInventario_Id(Integer id);
    List<MovimientoDetalle> findByMedicamento_Id(Integer id);

    List<MovimientoDetalle> findByLotesMedicamentos_Id(Integer id);

}

