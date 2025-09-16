package INVENTARIO.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "MovimientoDetalle")
public class MovimientoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double cantidad;

    private double costoUnitario;

    @ManyToOne
    @JoinTable(name = "movimiento_id")
    private MovimientoInventario movimientoInventario;

    @ManyToOne
    @JoinTable(name = "medicamento_id")
    private medicamento medicamento;

    @ManyToOne
    @JoinTable(name = "lote_id")
    private Lotes_medicamentos lotesMedicamentos;
}
