package INVENTARIO.servicios.interfaces;


import INVENTARIO.dtos.CompraDetalle.Actualizar_Detalle;
import INVENTARIO.dtos.CompraDetalle.Cancelar_Detalle;
import INVENTARIO.dtos.CompraDetalle.Crear_Detalle;
import INVENTARIO.dtos.CompraDetalle.Detalle_Obtener;

import java.util.List;

public interface ICompraDetalleService {

    List<Detalle_Obtener> compra_detalle();

    Detalle_Obtener detalle_por_id(Long id);

    Detalle_Obtener agregar_detalle(Crear_Detalle dto);

    Detalle_Obtener actualizar_detalle(Long id, Actualizar_Detalle dto);

    void eliminar_detalle(Long id, Cancelar_Detalle dto);

    List<Detalle_Obtener> detalles_por_compra(Long compraId);
}
