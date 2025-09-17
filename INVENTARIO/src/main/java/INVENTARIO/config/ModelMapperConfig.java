package INVENTARIO.config;

import INVENTARIO.dtos.LotesMedicamentos.LoteMedicamentos_Guardar;
import INVENTARIO.modelos.Lotes_medicamentos;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration().setAmbiguityIgnored(true); // 👈 evita errores por ambigüedad

        mapper.typeMap(LoteMedicamentos_Guardar.class, Lotes_medicamentos.class)
                .addMappings(m -> m.skip(Lotes_medicamentos::setId));

        return mapper;
    }
}
//public class ModelMapperConfig {
//
//    @Bean
//    public ModelMapper modelMapper() {
//        return new ModelMapper();

//    public void addCorsMappings(CorsRegistry registry) {


//        registry.addMapping("/**") // aplica a todos los endpoints
//                .allowedOrigins("*") // permite cualquier origen (ej. Blazor MAUI, Postman, navegador)
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // métodos permitidos
//                .allowedHeaders("*"); // permite todos los headers

