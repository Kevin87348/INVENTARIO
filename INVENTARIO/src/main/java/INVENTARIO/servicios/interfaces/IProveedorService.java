package INVENTARIO.Servicios.interfaces;


import INVENTARIO.dtos.proveedor.ProveedorGuardar;
import INVENTARIO.dtos.proveedor.ProveedorModificar;
import INVENTARIO.dtos.proveedor.ProveedorSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProveedorService {

    List<ProveedorSalida> obtenerTodos();

    Page<ProveedorSalida> obtenerTodosPaginados(Pageable pageable);

    ProveedorSalida obtenerPorId(Integer id);

    ProveedorSalida crear(ProveedorGuardar proveedorGuardar);

    ProveedorSalida editar(ProveedorModificar proveedorModificar);

    void eliminarPorId(Integer id);
}
