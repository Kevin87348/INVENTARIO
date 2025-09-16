package INVENTARIO.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medicamento")


public class medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String nombre;
    private String formafarmacautica;
    private String concentracion;
    private String unidad;
    private String via;
    private Boolean requiereReceta;
    private Boolean activo;
    private String temperaturaalm;
    private Integer  vidautilmeses;
}
