package INVENTARIO.Servicios.implementaciones;

import INVENTARIO.Modelos.MovimientoDetalle;
import INVENTARIO.Repositorios.IMovimientoDetalleRepository;
import INVENTARIO.Servicios.interfaces.IMovimientoDetalleService;
import INVENTARIO.dtos.movimientoDetalle.MovimientoDetalle_Guardar;
import INVENTARIO.dtos.movimientoDetalle.MovimientoDetalle_Modificar;
import INVENTARIO.dtos.movimientoDetalle.MovimientoDetalle_Salida;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientoDetalleService implements IMovimientoDetalleService{
    @Autowired
    private IMovimientoDetalleRepository movimientoDetalleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MovimientoDetalle_Salida> obtenerTodos() {
        List<MovimientoDetalle> movimientoDetalles = movimientoDetalleRepository.findAll();
        return movimientoDetalles.stream()
                .map(movimientoDetalle -> modelMapper.map(movimientoDetalle, MovimientoDetalle_Salida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<MovimientoDetalle_Salida> obtenerTodosPaginados(Pageable pageable) {
        Page<MovimientoDetalle> page = movimientoDetalleRepository.findAll(pageable);

        List<MovimientoDetalle_Salida> movimientoDetalleDtos = page.stream()
                .map(movimientoDetalle -> modelMapper.map(movimientoDetalle, MovimientoDetalle_Salida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(movimientoDetalleDtos, page.getPageable(), page.getTotalElements());
    }

    @Override
    public MovimientoDetalle_Salida obtenerPorId(Integer id) {
        Optional<MovimientoDetalle> movimientoDetalle = movimientoDetalleRepository.findById(id);

        if(movimientoDetalle.isPresent()){
            return modelMapper.map(movimientoDetalle.get(), MovimientoDetalle_Salida.class);
        }
        return null;
    }

    @Override
    public List<MovimientoDetalle_Salida> obtenerPorMovimientoInventarioId(Integer id) {
        List<MovimientoDetalle> movimientoDetalles = movimientoDetalleRepository.findByMovimientoInventarioId(id);
        return movimientoDetalles.stream()
                .map(movimientoDetalle -> modelMapper.map(movimientoDetalle, MovimientoDetalle_Salida.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovimientoDetalle_Salida> obtenerPorMedicamentoId(Integer id) {
        List<MovimientoDetalle> movimientoDetalles = movimientoDetalleRepository.findByMedicamentoId(id);
        return movimientoDetalles.stream()
                .map(movimientoDetalle -> modelMapper.map(movimientoDetalle, MovimientoDetalle_Salida.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovimientoDetalle_Salida> obtenerPorLoteMedicamento(Integer id){
        List<MovimientoDetalle> movimientoDetalles = movimientoDetalleRepository.findByLoteMedicamentoId(id);
        return movimientoDetalles.stream()
                .map(movimientoDetalle -> modelMapper.map(movimientoDetalle, MovimientoDetalle_Salida.class))
                .collect(Collectors.toList());
    }
    @Override
    public MovimientoDetalle_Salida crear(MovimientoDetalle_Guardar movimientoDetalleGuardar) {
        MovimientoDetalle movimientoDetalle = modelMapper.map(movimientoDetalleGuardar, MovimientoDetalle.class);
        movimientoDetalle.setId(null);

        return modelMapper.map(movimientoDetalleRepository.save(movimientoDetalle), MovimientoDetalle_Salida.class);
    }

    @Override
    public MovimientoDetalle_Salida editar(MovimientoDetalle_Modificar movimientoDetalleModificar) {
        MovimientoDetalle movimientoDetalle = movimientoDetalleRepository.save(modelMapper.map(movimientoDetalleModificar, MovimientoDetalle.class));
        return modelMapper.map(movimientoDetalle, MovimientoDetalle_Salida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        movimientoDetalleRepository.deleteById(id);
    }
}