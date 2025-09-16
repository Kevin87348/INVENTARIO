package INVENTARIO.servicios.implementaciones;

import INVENTARIO.dtos.CompraDetalle.Actualizar_Detalle;
import INVENTARIO.dtos.CompraDetalle.Cancelar_Detalle;
import INVENTARIO.dtos.CompraDetalle.Crear_Detalle;
import INVENTARIO.dtos.CompraDetalle.Detalle_Obtener;
import INVENTARIO.modelos.CompraDetalle;
import INVENTARIO.repositorios.ICompraDetalleRepository;
import INVENTARIO.servicios.interfaces.ICompraDetalleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraDetalleService implements ICompraDetalleService {

    @Autowired
    private ICompraDetalleRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Detalle_Obtener> compra_detalle() {
        return repository.findAll().stream()
                .map(detalle -> modelMapper.map(detalle, Detalle_Obtener.class))
                .collect(Collectors.toList());
    }

    @Override
    public Detalle_Obtener detalle_por_id(Long id) {
        CompraDetalle detalle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de compra no encontrado"));
        return modelMapper.map(detalle, Detalle_Obtener.class);
    }

    @Override
    public Detalle_Obtener agregar_detalle(Crear_Detalle dto) {
        CompraDetalle detalle = modelMapper.map(dto, CompraDetalle.class);
        return modelMapper.map(repository.save(detalle), Detalle_Obtener.class);
    }

    @Override
    public Detalle_Obtener actualizar_detalle(Long id, Actualizar_Detalle dto) {
        CompraDetalle existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de compra no encontrado"));
        modelMapper.map(dto, existente);
        return modelMapper.map(repository.save(existente), Detalle_Obtener.class);
    }

    @Override
    public void eliminar_detalle(Long id, Cancelar_Detalle dto) {
        CompraDetalle detalle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de compra no encontrado"));
        repository.delete(detalle);
    }

    @Override
    public List<Detalle_Obtener> detalles_por_compra(Long compraId) {
        return repository.findByCompraId(compraId).stream()
                .map(detalle -> modelMapper.map(detalle, Detalle_Obtener.class))
                .collect(Collectors.toList());
    }
}
