package INVENTARIO.repositorios;

import INVENTARIO.modelos.proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedorRepository  extends JpaRepository<proveedor, Integer>{
}
