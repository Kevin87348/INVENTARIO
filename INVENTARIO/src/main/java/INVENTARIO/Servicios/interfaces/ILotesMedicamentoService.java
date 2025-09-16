package INVENTARIO.servicios.interfaces;

import INVENTARIO.dtos.LotesMedicamentos.LoteMedicamento_Salida;
import INVENTARIO.dtos.LotesMedicamentos.LoteMedicamentos_Actualizar;
import INVENTARIO.dtos.LotesMedicamentos.LoteMedicamentos_Guardar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ILotesMedicamentoService {
    List<LoteMedicamento_Salida> obtenerTodos();

    Page<LoteMedicamento_Salida> obtenerTodosPaginados(Pageable pageable);

    LoteMedicamento_Salida obtenerPorId(Integer id);

    LoteMedicamento_Salida crear(LoteMedicamentos_Guardar loteMedicamentosGuardar);

    LoteMedicamento_Salida editar(LoteMedicamentos_Actualizar loteMedicamentosActualizar);

    void eliminarPorId(Integer id);

    List<LoteMedicamento_Salida> obtenerPorMedicamentoId(Integer medicamentoId);

    List<LoteMedicamento_Salida> obtenerPorProveedorId(Integer proveedorId);

    List<LoteMedicamento_Salida> obtenerLotesProximosAVencer();
}
