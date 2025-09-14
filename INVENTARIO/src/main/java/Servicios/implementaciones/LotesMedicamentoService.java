package Servicios.implementaciones;

import Modelos.Lotes_medicamentos;
import Repositorios.ILotesMedicamentosRepository;
import Servicios.interfaces.ILotesMedicamentoService;
import dtos.LotesMedicamentos.LoteMedicamento_Salida;
import dtos.LotesMedicamentos.LoteMedicamentos_Actualizar;
import dtos.LotesMedicamentos.LoteMedicamentos_Guardar;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotesMedicamentoService implements ILotesMedicamentoService {
     @Autowired
     private ILotesMedicamentosRepository lotesMedicamentosRepository;

     @Autowired
     private ModelMapper modelMapper;

    @Override
    public List<LoteMedicamento_Salida> obtenerTodos() {
        List<Lotes_medicamentos> loteMedicamentoSalidas = lotesMedicamentosRepository.findAll();

        return loteMedicamentoSalidas.stream()
                .map(loteMedicamentoSalida -> modelMapper.map(loteMedicamentoSalidas, LoteMedicamento_Salida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<LoteMedicamento_Salida> obtenerTodosPaginados(Pageable pageable) {
        Page<Lotes_medicamentos> page = lotesMedicamentosRepository.findAll(pageable);

        //LoteMedicamentoDto puede ser otro nombre tambien no afecta
        List<LoteMedicamento_Salida> LoteMedicamentoDto = page.stream()
                .map(lotesMedicamentos -> modelMapper.map(lotesMedicamentos, LoteMedicamento_Salida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(LoteMedicamentoDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public LoteMedicamento_Salida obtenerPorId(Integer id) {
        return modelMapper.map(lotesMedicamentosRepository.findById(id).get(), LoteMedicamento_Salida.class);
    }

    @Override
    public LoteMedicamento_Salida crear(LoteMedicamentos_Guardar loteMedicamentosGuardar) {
        Lotes_medicamentos lotesMedicamentos = lotesMedicamentosRepository.save(modelMapper.map(loteMedicamentosGuardar, Lotes_medicamentos.class));
        return modelMapper.map(lotesMedicamentos, LoteMedicamento_Salida.class);
    }

    @Override
    public LoteMedicamento_Salida editar(LoteMedicamentos_Actualizar loteMedicamentosActualizar) {
        Lotes_medicamentos lotesMedicamentos = lotesMedicamentosRepository.save(modelMapper.map(loteMedicamentosActualizar, Lotes_medicamentos.class));
        return modelMapper.map(lotesMedicamentos, LoteMedicamento_Salida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        lotesMedicamentosRepository.deleteById(id);
    }

    @Override
    public List<LoteMedicamento_Salida> obtenerPorMedicamentoId(Integer medicamentoId) {
        return List.of();
    }

    @Override
    public List<LoteMedicamento_Salida> obtenerPorProveedorId(Integer proveedorId) {
        return List.of();
    }

    @Override
    public List<LoteMedicamento_Salida> obtenerLotesProximosAVencer() {
        return List.of();
    }
}
