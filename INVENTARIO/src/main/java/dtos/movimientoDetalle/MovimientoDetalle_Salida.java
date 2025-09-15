package dtos.movimientoDetalle;

import dtos.LotesMedicamentos.LoteMedicamento_Salida;
import dtos.movimientoInventario.MovimientoInventario_Salida;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MovimientoDetalle_Salida implements Serializable {
    private Integer id;

    private double cantidad;

    private double costoUnitario;

    private MovimientoInventario_Salida movimientoInventario;

    private Medicamento_Salida medicamento;

    private LoteMedicamento_Salida loteMedicamento;
}
