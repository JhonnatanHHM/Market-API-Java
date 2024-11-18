package com.api_proyect.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Market API",
                version = "1.0.0",
                description = "This is my first CRUD, a CRUD for a website of a Market-Place"
        )
)
public class OpenapiConfig {
}
