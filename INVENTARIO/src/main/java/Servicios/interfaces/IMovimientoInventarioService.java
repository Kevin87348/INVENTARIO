package Servicios.interfaces;

import dtos.movimientoInventario.MovimientoInventarioCambiarTipo;
import dtos.movimientoInventario.MovimientoInventario_Guardar;
import dtos.movimientoInventario.MovimientoInventario_Modificar;
import dtos.movimientoInventario.MovimientoInventario_Salida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovimientoInventarioService {
    List<MovimientoInventario_Salida> obtenerTodos();
    Page<MovimientoInventario_Salida> obtenerTodosPaginados(Pageable pageable);
    MovimientoInventario_Salida obtenerPorId(Integer id);
    List<MovimientoInventario_Salida> obtenerPorAlmacenId(Integer id);
    List<MovimientoInventario_Salida> obtenerPorUsuarioId(Integer id);
    MovimientoInventario_Salida crear(MovimientoInventario_Guardar movimientoInventarioGuardar);
    MovimientoInventario_Salida editar(MovimientoInventario_Modificar movimientoInventarioModificar);
    MovimientoInventario_Salida cambiarTipo(MovimientoInventarioCambiarTipo movimientoInventarioCambiarTipo);
    void eliminarPorId(Integer id);
}