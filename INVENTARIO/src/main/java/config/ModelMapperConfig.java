package config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
//    public void addCorsMappings(CorsRegistry registry) {


//        registry.addMapping("/**") // aplica a todos los endpoints
//                .allowedOrigins("*") // permite cualquier origen (ej. Blazor MAUI, Postman, navegador)
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // métodos permitidos
//                .allowedHeaders("*"); // permite todos los headers
    }
}

