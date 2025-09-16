package INVENTARIO.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Almacen")
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 80)
    private String nombre;

    @Column(length = 200) // puedes ajustar según el tamaño real
    private String ubicacion;

    private Boolean activo;
}
