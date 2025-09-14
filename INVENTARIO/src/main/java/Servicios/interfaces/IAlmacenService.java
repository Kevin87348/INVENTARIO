package Servicios.interfaces;

import dtos.Almacen.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IAlmacenService {
    List<Almacen_Salida> obtenerTodos();

    Page<Almacen_Salida> obtenerTodosPaginados(Pageable pageable);

    Almacen_Salida obtenerPorId(Short id);

    Almacen_Salida crear(Almacen_Guardar almacenGuardar);

    Almacen_Salida editar(Short id, Almacen_Actualizar almacenActualizar);

    void eliminarPorId(Short id);

    Almacen_Salida cambiarEstado(Short id, Almacen_CambiarEstado almacenCambiarEstado);
}
