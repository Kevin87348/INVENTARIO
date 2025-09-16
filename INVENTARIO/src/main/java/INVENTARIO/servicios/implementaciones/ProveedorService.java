package INVENTARIO.servicios.implementaciones;

import INVENTARIO.dtos.proveedor.ProveedorGuardar;
import INVENTARIO.dtos.proveedor.ProveedorModificar;
import INVENTARIO.dtos.proveedor.ProveedorSalida;
import INVENTARIO.modelos.proveedor;
import INVENTARIO.repositorios.IProveedorRepository;
import INVENTARIO.Servicios.interfaces.IProveedorService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorService implements IProveedorService {

    private static final Logger log = LoggerFactory.getLogger(ProveedorService.class);
    @Autowired
    private IProveedorRepository proveedorRepository;

    @Autowired
    private ModelMapper modelMapper;

        @Override
        public List<ProveedorSalida> obtenerTodos() {
            List<proveedor> proveedores = proveedorRepository.findAll();
            return proveedores.stream()
                    .map(Proveedor -> modelMapper.map(Proveedor, ProveedorSalida.class))
                    .collect(Collectors.toList());
        }

        @Override
        public Page<ProveedorSalida> obtenerTodosPaginados(Pageable pageable) {
            Page<proveedor> page = proveedorRepository.findAll(pageable);

            List<ProveedorSalida> proveedorDto = page.stream()
                    .map(Proveedor -> modelMapper.map(Proveedor, ProveedorSalida.class))
                    .collect(Collectors.toList());

            return new PageImpl<>(proveedorDto, page.getPageable(), page.getTotalElements());
        }

        @Override
        public ProveedorSalida obtenerPorId(Integer id) {
            return modelMapper.map(proveedorRepository.findById(id).get(), ProveedorSalida.class);
        }

        @Override
        public ProveedorSalida crear(ProveedorGuardar proveedorGuardar) {
            proveedor Proveedor =proveedorRepository.save(modelMapper.map(proveedorGuardar, proveedor.class));
            return modelMapper.map(Proveedor, ProveedorSalida.class);
        }

        @Override
        public ProveedorSalida editar(ProveedorModificar proveedorModificar) {
            proveedor Proveedor =proveedorRepository.save(modelMapper.map(proveedorModificar, proveedor.class));
            return modelMapper.map(Proveedor, ProveedorSalida.class);
        }

        @Override
        public void eliminarPorId(Integer id) {
            proveedorRepository.deleteById(id);

        }
    }

