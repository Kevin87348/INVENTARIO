package INVENTARIO.servicios.interfaces;


import INVENTARIO.dtos.medicamento.MedicamentoGuardar;
import INVENTARIO.dtos.medicamento.MedicamentoModificar;
import INVENTARIO.dtos.medicamento.MedicamentoSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMedicamentoService {

    List<MedicamentoSalida> obtenerTodos();

    Page<MedicamentoSalida> obtenerTodosPaginados(Pageable pageable);

    MedicamentoSalida obtenerPorId(Integer id);

    MedicamentoSalida crear(MedicamentoGuardar medicamentoGuardar);

    MedicamentoSalida editar(MedicamentoModificar medicamentoSalida);

    void eliminarPorId(Integer id);
}
