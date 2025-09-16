package INVENTARIO.Repositorios;

import INVENTARIO.Modelos.proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedorRepository  extends JpaRepository<proveedor, Integer>{
}
