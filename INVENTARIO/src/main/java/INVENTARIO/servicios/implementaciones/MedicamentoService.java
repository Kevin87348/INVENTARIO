package INVENTARIO.servicios.implementaciones;


import INVENTARIO.dtos.medicamento.MedicamentoGuardar;
import INVENTARIO.dtos.medicamento.MedicamentoModificar;
import INVENTARIO.dtos.medicamento.MedicamentoSalida;
import INVENTARIO.modelos.medicamento;
import INVENTARIO.repositorios.IMedicamentoRepository;
import INVENTARIO.Servicios.interfaces.IMedicamentoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicamentoService implements IMedicamentoService {

    private static final Logger log = LoggerFactory.getLogger(MedicamentoService.class);
    @Autowired
    private IMedicamentoRepository medicamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MedicamentoSalida> obtenerTodos() {
        List<medicamento> medicamentos = medicamentoRepository.findAll();
        return medicamentos.stream()
                .map(Medicamento -> modelMapper.map(Medicamento, MedicamentoSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<MedicamentoSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<medicamento> page = medicamentoRepository.findAll(pageable);

        List<MedicamentoSalida> medicamentoDto = page.stream()
                .map(Medicamento -> modelMapper.map(Medicamento, MedicamentoSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(medicamentoDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public MedicamentoSalida obtenerPorId(Integer id) {
        return modelMapper.map(medicamentoRepository.findById(id).get(), MedicamentoSalida.class);
    }

    @Override
    public MedicamentoSalida crear(MedicamentoGuardar medicamentoGuardar) {
        medicamento Medicamento =medicamentoRepository.save(modelMapper.map(medicamentoGuardar, medicamento.class));
        return modelMapper.map(Medicamento, MedicamentoSalida.class);
    }

    @Override
    public MedicamentoSalida editar(MedicamentoModificar medicamentoSalida) {
        medicamento Medicamento =medicamentoRepository.save(modelMapper.map(medicamentoSalida, medicamento.class));
        return modelMapper.map(Medicamento, MedicamentoSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        medicamentoRepository.deleteById(id);

    }
}
