package INVENTARIO.servicios.implementaciones;

import INVENTARIO.dtos.Compra.Compra_Actualizar;
import INVENTARIO.dtos.Compra.Compra_Crear;
import INVENTARIO.dtos.Compra.Compra_Obtener;
import INVENTARIO.dtos.Compra.Compra_Cancelar;
import INVENTARIO.modelos.Compra;
import INVENTARIO.repositorios.ICompraRepository;
import INVENTARIO.servicios.interfaces.ICompraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraService implements ICompraService {

    @Autowired
    private ICompraRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Compra_Obtener> obtenerTodos() {
        return repository.findAll().stream()
                .map(compra -> modelMapper.map(compra, Compra_Obtener.class))
                .collect(Collectors.toList());
    }

    @Override
    public Compra_Obtener obtenerPorId(Integer id) {
        Compra compra = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
        return modelMapper.map(compra, Compra_Obtener.class);
    }

    @Override
    public Compra_Obtener crear(Compra_Crear dto) {
        Compra compra = modelMapper.map(dto, Compra.class);
        return modelMapper.map(repository.save(compra), Compra_Obtener.class);
    }

    @Override
    public Compra_Obtener actualizar(Integer id, Compra_Actualizar dto) {
        Compra existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
        modelMapper.map(dto, existente);
        return modelMapper.map(repository.save(existente), Compra_Obtener.class);
    }

    @Override
    public void cancelar(Integer id, Compra_Cancelar dto) {
        // En este método, podrías usar el 'motivoCancelacion' del DTO
        Compra compra = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
        // Aquí puedes actualizar el estado de la compra a 'CANCELADA' en lugar de eliminarla
        repository.deleteById(id);
    }

    @Override
    public List<Compra_Obtener> obtenerPorProveedor(Integer proveedorId) {
        return repository.findByProveedorId(proveedorId).stream()
                .map(compra -> modelMapper.map(compra, Compra_Obtener.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Compra_Obtener> obtenerPorFecha(LocalDate fecha) {
        return repository.findByFecha(fecha).stream()
                .map(compra -> modelMapper.map(compra, Compra_Obtener.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Compra_Obtener> obtenerPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId).stream()
                .map(compra -> modelMapper.map(compra, Compra_Obtener.class))
                .collect(Collectors.toList());
    }
}