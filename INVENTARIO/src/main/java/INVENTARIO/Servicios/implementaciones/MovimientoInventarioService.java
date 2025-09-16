package INVENTARIO.Servicios.implementaciones;

import INVENTARIO.Modelos.MovimientoInventario;
import INVENTARIO.Repositorios.IMovimientoInventarioRepository;
import INVENTARIO.Servicios.interfaces.IMovimientoInventarioService;
import INVENTARIO.dtos.movimientoInventario.MovimientoInventarioCambiarTipo;
import INVENTARIO.dtos.movimientoInventario.MovimientoInventario_Guardar;
import INVENTARIO.dtos.movimientoInventario.MovimientoInventario_Modificar;
import INVENTARIO.dtos.movimientoInventario.MovimientoInventario_Salida;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
public class MovimientoInventarioService implements IMovimientoInventarioService {
    @Autowired
    private IMovimientoInventarioRepository movimientoInventarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MovimientoInventario_Salida> obtenerTodos() {
        List<MovimientoInventario> movimientoInventarios = movimientoInventarioRepository.findAll();
        return movimientoInventarios.stream()
                .map(movimientoInventario -> modelMapper.map(movimientoInventario, MovimientoInventario_Salida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<MovimientoInventario_Salida> obtenerTodosPaginados(Pageable pageable) {
        Page<MovimientoInventario> page = movimientoInventarioRepository.findAll(pageable);

        List<MovimientoInventario_Salida> movimientoInventarioDtos = page.stream()
                .map(movimientoInventario -> modelMapper.map(movimientoInventario, MovimientoInventario_Salida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(movimientoInventarioDtos, page.getPageable(), page.getTotalElements());
    }

    @Override
    public MovimientoInventario_Salida obtenerPorId(Integer id) {
        Optional<MovimientoInventario> movimientoInventario = movimientoInventarioRepository.findById(id);

        if(movimientoInventario.isPresent()){
            return modelMapper.map(movimientoInventario.get(), MovimientoInventario_Salida.class);
        }
        return null;
    }

    @Override
    public List<MovimientoInventario_Salida> obtenerPorAlmacenId(Integer id) {
        List<MovimientoInventario> movimientoInventarios = movimientoInventarioRepository.findByAlmacenId(id);
        return movimientoInventarios.stream()
                .map(movimientoInventario -> modelMapper.map(movimientoInventario, MovimientoInventario_Salida.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovimientoInventario_Salida> obtenerPorUsuarioId(Integer id) {
        List<MovimientoInventario> movimientoInventarios = movimientoInventarioRepository.findByUsuarioId(id);
        return movimientoInventarios.stream()
                .map(movimientoInventario -> modelMapper.map(movimientoInventario, MovimientoInventario_Salida.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovimientoInventario_Salida crear(MovimientoInventario_Guardar movimientoInventarioGuardar) {
        MovimientoInventario movimientoInventario = modelMapper.map(movimientoInventarioGuardar, MovimientoInventario.class);
        movimientoInventario.setId(null);
        movimientoInventario.setTipo(MovimientoInventario.Status.ENTRADA);

        return modelMapper.map(movimientoInventarioRepository.save(movimientoInventario), MovimientoInventario_Salida.class);
    }

    @Override
    public MovimientoInventario_Salida editar(MovimientoInventario_Modificar movimientoInventarioModificar) {
        MovimientoInventario movimientoInventario = movimientoInventarioRepository.save(modelMapper.map(movimientoInventarioModificar, MovimientoInventario.class));
        return modelMapper.map(movimientoInventario, MovimientoInventario_Salida.class);
    }

    @Override
    public MovimientoInventario_Salida cambiarTipo(MovimientoInventarioCambiarTipo dto) {
        MovimientoInventario movimiento = movimientoInventarioRepository.findById(dto.getId())//modificado porque daba error
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));

        movimiento.setTipo(MovimientoInventario.Status.valueOf(dto.getTipo()));
        return modelMapper.map(movimientoInventarioRepository.save(movimiento), MovimientoInventario_Salida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        movimientoInventarioRepository.deleteById(id);
    }
}










