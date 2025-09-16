package INVENTARIO.dtos.CompraDetalle;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Actualizar_Detalle implements Serializable {
    private Long productoId;
    private int cantidad;
    private double precio;
}
