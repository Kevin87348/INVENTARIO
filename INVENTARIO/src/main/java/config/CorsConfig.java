package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // aplica a todos los endpoints
                .allowedOrigins("*") // permite cualquier origen (ej. Blazor MAUI, Postman, navegador)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // métodos permitidos
                .allowedHeaders("*"); // permite todos los headers
    }
}

