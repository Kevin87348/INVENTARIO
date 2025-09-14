package Servicios.interfaces;

import dtos.Dispensa.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IDispensaService {
    List<Dispensa_Salida> obtenerTodas();

    Page<Dispensa_Salida> obtenerTodasPaginadas(Pageable pageable);

    Dispensa_Salida obtenerPorId(Long id);

    Dispensa_Salida crear(Dispensa_Guardar dispensaGuardar);

    Dispensa_Salida editar(Long id, Dispensa_Actualizar dispensaActualizar);

    void eliminarPorId(Long id);

    List<Dispensa_Salida> obtenerPorPrescripcion(Long prescripcionDetalleId);

    List<Dispensa_Salida> obtenerPorAlmacen(Short almacenId);

    List<Dispensa_Salida> obtenerPorFecha(LocalDate fecha);
}
