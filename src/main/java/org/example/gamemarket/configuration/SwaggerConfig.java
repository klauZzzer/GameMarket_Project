package org.example.gamemarket.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@OpenAPIDefinition(
        info = @Info(
                title = "Game Market",
                description = "This is the backend of the online game market application.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Matvey Klauzer",
                        url = "https://github.com/klauZzzer"
                )
        )
)
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.packageName:org.example.gamemarket}")
    private String PACKAGE_NAME;
    public static final String DEVELOPER = "developer service";
    public static final String GAME = "game service";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_NAME))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(DEVELOPER, "API for working with developers"))
                .tags(new Tag(GAME, "API for working with games"));
    }

}
