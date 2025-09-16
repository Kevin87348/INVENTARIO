package INVENTARIO.Repositorios;

import INVENTARIO.Modelos.Dispensa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IDispensaRepository extends JpaRepository<Dispensa, Integer> {
    List<Dispensa> findByPrescripcionDetalleId(Integer prescripcionDetalleId);

    List<Dispensa> findByAlmacenId(Integer almacenId);

    List<Dispensa> findByFecha(LocalDate fecha);
}
