package INVENTARIO.servicios.interfaces;

import INVENTARIO.dtos.Almacen.Almacen_Actualizar;
import INVENTARIO.dtos.Almacen.Almacen_CambiarEstado;
import INVENTARIO.dtos.Almacen.Almacen_Guardar;
import INVENTARIO.dtos.Almacen.Almacen_Salida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IAlmacenService {
    List<Almacen_Salida> obtenerTodos();

    Page<Almacen_Salida> obtenerTodosPaginados(Pageable pageable);

    Almacen_Salida obtenerPorId(Integer id);

    Almacen_Salida crear(Almacen_Guardar almacenGuardar);

    Almacen_Salida editar(Integer id, Almacen_Actualizar almacenActualizar);

    void eliminarPorId(Integer id);

    Almacen_Salida cambiarEstado(Integer id, Almacen_CambiarEstado almacenCambiarEstado);
}
