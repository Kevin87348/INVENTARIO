package INVENTARIO.repositorios;

import INVENTARIO.modelos.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlmacenRepository extends JpaRepository<Almacen, Integer> {
}
