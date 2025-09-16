package INVENTARIO.dtos.Compra;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Compra_Obtener implements Serializable {
    private Integer id;
    private Long proveedorId;
    private Long usuarioId;
    private LocalDate fecha;
    private String descripcion;
    private double total;
}