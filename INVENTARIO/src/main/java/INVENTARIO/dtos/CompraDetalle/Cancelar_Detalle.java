package INVENTARIO.dtos.CompraDetalle;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cancelar_Detalle implements Serializable {
    private String motivo; // Motivo de cancelación
}
