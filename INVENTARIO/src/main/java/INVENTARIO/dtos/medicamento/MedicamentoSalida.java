package INVENTARIO.dtos.medicamento;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class MedicamentoSalida implements Serializable {
    private  Integer id;
    private String nombre;
    private String formafarmacautica;
    private String concentracion;
    private String unidad;
    private String via;
    private Boolean requiereReceta;
    private Boolean activo;
    private String temperaturaalm;
    private Integer  vidautilmeses;

}

