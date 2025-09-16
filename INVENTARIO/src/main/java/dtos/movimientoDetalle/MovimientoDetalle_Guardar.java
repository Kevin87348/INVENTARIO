package dtos.movimientoDetalle;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class MovimientoDetalle_Guardar implements Serializable {
    private double cantidad;

    private double costoUnitario;

    private Integer movimientoInventarioId;

    private Integer medicamentoId;

    private Integer lotes_medicamentosId;
}
