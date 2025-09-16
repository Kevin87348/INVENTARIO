package INVENTARIO.dtos.Compra;


import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Compra_Cancelar implements Serializable {
    private String motivoCancelacion;
}