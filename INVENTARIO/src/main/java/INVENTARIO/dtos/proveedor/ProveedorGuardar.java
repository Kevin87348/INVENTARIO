package INVENTARIO.dtos.proveedor;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProveedorGuardar implements Serializable{
    private String nombre;
    private String nit;
    private String telefono;
    private String email;
    private String direccion;
    private String notas;

}
