package Servicios.interfaces;

import dtos.inventario.Inventario_Guardar;
import dtos.inventario.Inventario_Modificar;
import dtos.inventario.Inventario_Salida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInventarioService {
    List<Inventario_Salida> obtenerTodos();
    Page<Inventario_Salida> obtenerTodosPaginados(Pageable pageable);
    Inventario_Salida obtenerPorId(Integer id);
    List<Inventario_Salida> obtenerPorAlmacenId(Integer id);
    List<Inventario_Salida> obtenerPorMedicamentoId(Integer id);
    Inventario_Salida crear(Inventario_Guardar inventarioGuardar);
    Inventario_Salida editar(Inventario_Modificar inventarioModificar);
    void eliminarPorId(Integer id);
}