package INVENTARIO.controladores;


import INVENTARIO.modelos.CompraDetalle;
import INVENTARIO.repositorios.ICompraDetalleRepository;
import INVENTARIO.servicios.interfaces.ICompraDetalleService;
import INVENTARIO.dtos.CompraDetalle.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras-detalle")
public class CompraDetalleController {

    @Autowired
    private ICompraDetalleService detalleService;

    @GetMapping
    public List<Detalle_Obtener> listarDetalles() {
        return detalleService.compra_detalle();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle_Obtener> obtenerDetalle(@PathVariable Long id) {
        return ResponseEntity.ok(detalleService.detalle_por_id(id));
    }

    @PostMapping
    public Detalle_Obtener crearDetalle(@RequestBody Crear_Detalle dto) {
        return detalleService.agregar_detalle(dto);
    }

    @PutMapping("/{id}")
    public Detalle_Obtener actualizarDetalle(@PathVariable Long id, @RequestBody Actualizar_Detalle dto) {
        return detalleService.actualizar_detalle(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarDetalle(@PathVariable Long id, @RequestBody Cancelar_Detalle dto) {
        detalleService.eliminar_detalle(id, dto);
    }

    @GetMapping("/compra/{compraId}")
    public List<Detalle_Obtener> detallesPorCompra(@PathVariable Long compraId) {
        return detalleService.detalles_por_compra(compraId);
    }
}
