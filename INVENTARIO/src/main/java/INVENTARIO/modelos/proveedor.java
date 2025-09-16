package INVENTARIO.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")


public class proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String nombre;
    private String nit;
    private String telefono;
    private String email;
    private String direccion;
    private String notas;

}