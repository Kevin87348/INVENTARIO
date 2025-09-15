package dtos.inventario;

import lombok.Getter;
import lombok.Setter;
import dtos.Almacen.Almacen_Salida;
import dtos.Medicamento.Medicamento_Salida;

import java.io.Serializable;

@Setter
@Getter
public class Inventario_Salida implements Serializable {
    private Integer id;

    private double stockActual;

    private double stockMinimo;

    private double stockMaximo;

    private Almacen_Salida almacen;

    private Medicamento_Salida medicamento;
}
