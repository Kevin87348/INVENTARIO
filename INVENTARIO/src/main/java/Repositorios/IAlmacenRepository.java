package Repositorios;

import Modelos.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlmacenRepository extends JpaRepository<Almacen, Integer> {
}
