package INVENTARIO.dtos.inventario;

import lombok.Getter;
import lombok.Setter;
import INVENTARIO.dtos.Almacen.Almacen_Salida;
import INVENTARIO.dtos.medicamento.MedicamentoSalida;

import java.io.Serializable;

@Setter
@Getter
public class Inventario_Salida implements Serializable {
    private Integer id;

    private double stockActual;

    private double stockMinimo;

    private double stockMaximo;

    private Almacen_Salida almacen;

    private MedicamentoSalida medicamento;
}
