package INVENTARIO.dtos.CompraDetalle;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Crear_Detalle implements Serializable {
    private Long compraId;
    private Long productoId;
    private int cantidad;
    private double precio;
}
