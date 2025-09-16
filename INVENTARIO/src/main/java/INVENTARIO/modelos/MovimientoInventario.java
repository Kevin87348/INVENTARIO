package INVENTARIO.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "MovimientoInventario")
public class MovimientoInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Status tipo;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "almacenId")
    private Almacen almacen;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    private String observacion;

    public static enum Status {
        ENTRADA,
        SALIDA
    }
}
