package com.crud.demo.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	  @Autowired
	    private AuthInterceptor authInterceptor;
public void addCorsMappings(CorsRegistry registry) {
		
		registry
		//users
		  .addMapping("/**")
		  //get
		  .allowedMethods("*")
		  //nom de domaines
		  .allowedOrigins("*");
		
	}

@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authInterceptor)
            .addPathPatterns("/users/**") // Spécifie les URL qui nécessitent une authentification
            .excludePathPatterns("/login", "/logout"); // Exclut l'URL de connexion pour éviter une boucle infinie
}

}
