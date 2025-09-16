package INVENTARIO.dtos.Almacen;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Almacen_Actualizar implements Serializable {
    private String nombre;
    private String ubicacion;
    private Boolean activo;
}
