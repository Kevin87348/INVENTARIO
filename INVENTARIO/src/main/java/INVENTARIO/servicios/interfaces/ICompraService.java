package INVENTARIO.servicios.interfaces;


import INVENTARIO.dtos.Compra.Compra_Crear;
import INVENTARIO.dtos.Compra.Compra_Obtener;
import INVENTARIO.dtos.Compra.Compra_Actualizar;
import INVENTARIO.dtos.Compra.Compra_Cancelar;

import java.time.LocalDate;
import java.util.List;

public interface ICompraService {

    // Crear una nueva compra
    Compra_Obtener crear(Compra_Crear compraCrear);

    // Obtener una compra específica por ID
    Compra_Obtener obtenerPorId(Integer id);

    // Listar todas las compras
    List<Compra_Obtener> obtenerTodos();

    // Actualizar una compra existente
    Compra_Obtener actualizar(Integer id, Compra_Actualizar compraActualizar);

    // Cancelar una compra por ID
    void cancelar(Integer id, Compra_Cancelar dto);

    // ✅ Métodos adicionales que ya tienes implementados
    List<Compra_Obtener> obtenerPorProveedor(Integer proveedorId);

    List<Compra_Obtener> obtenerPorFecha(LocalDate fecha);

    List<Compra_Obtener> obtenerPorUsuario(Integer usuarioId);
}
