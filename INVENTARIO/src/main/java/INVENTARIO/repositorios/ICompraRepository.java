package INVENTARIO.repositorios;


import INVENTARIO.modelos.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Integer> {
    // Métodos personalizados de búsqueda, si se necesitan.
    List<Compra> findByProveedorId(Integer proveedorId);
    List<Compra> findByUsuarioId(Integer usuarioId);
    List<Compra> findByFecha(LocalDate fecha);
}