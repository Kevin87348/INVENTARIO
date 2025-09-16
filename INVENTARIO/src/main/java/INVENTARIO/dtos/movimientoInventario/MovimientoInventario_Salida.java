package INVENTARIO.dtos.movimientoInventario;

import INVENTARIO.dtos.Almacen.Almacen_Salida;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class MovimientoInventario_Salida implements Serializable {
    private Integer id;

    private Date fecha;

    private String tipo;

    private String observacion;

    private Almacen_Salida almacen;

//    private UsuarioSalida usuario;
}
