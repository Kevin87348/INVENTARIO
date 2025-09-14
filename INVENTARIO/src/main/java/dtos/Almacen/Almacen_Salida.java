package dtos.Almacen;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Almacen_Salida implements Serializable {
    private Short id;
    private String nombre;
    private String ubicacion;
    private Boolean activo;
}

