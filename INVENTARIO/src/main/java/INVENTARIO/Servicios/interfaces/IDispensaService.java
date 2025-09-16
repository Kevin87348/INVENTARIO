package INVENTARIO.servicios.interfaces;

import INVENTARIO.dtos.Dispensa.Dispensa_Actualizar;
import INVENTARIO.dtos.Dispensa.Dispensa_Guardar;
import INVENTARIO.dtos.Dispensa.Dispensa_Salida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IDispensaService {
    List<Dispensa_Salida> obtenerTodas();

    Page<Dispensa_Salida> obtenerTodasPaginadas(Pageable pageable);

    Dispensa_Salida obtenerPorId(Integer id);

    Dispensa_Salida crear(Dispensa_Guardar dispensaGuardar);

    Dispensa_Salida editar(Integer id, Dispensa_Actualizar dispensaActualizar);

    void eliminarPorId(Integer id);

    List<Dispensa_Salida> obtenerPorPrescripcion(Integer prescripcionDetalleId);

    List<Dispensa_Salida> obtenerPorAlmacen(Integer almacenId);

    List<Dispensa_Salida> obtenerPorFecha(LocalDate fecha);
}
