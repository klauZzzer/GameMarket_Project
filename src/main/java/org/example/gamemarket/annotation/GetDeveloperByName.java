package org.example.gamemarket.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.gamemarket.entity.Developer;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(summary = "Show developer by name",
        description = "Receiving a developer by name",
        tags = {"DEVELOPER"},
        parameters = {
                @Parameter(
                        name = "name",
                        description = "The unique developer name",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Request with existing name",
                                        value = "Ubisoft"
                                ),
                                @ExampleObject(
                                        name = "Request with non-existing name",
                                        value = "Marshall"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Developer received and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Developer.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Developer not found",
                        content = @Content()
                )
        })
public @interface GetDeveloperByName {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
