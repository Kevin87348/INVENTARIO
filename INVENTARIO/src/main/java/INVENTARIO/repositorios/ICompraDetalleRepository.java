package INVENTARIO.repositorios;

import INVENTARIO.modelos.CompraDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompraDetalleRepository extends JpaRepository<CompraDetalle, Long> {

    List<CompraDetalle> findByCompraId(Long compraId);
}
