package org.example.gamemarket.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
@RequestMapping(method = RequestMethod.POST)
@Operation(
        summary = "Create a new developer",
        description = "Creation of a new developer and return",
        tags = {"DEVELOPER"},
        requestBody = @RequestBody(
                description = "The developer to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Developer.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                value = """
                                        {
                                            "name" : "Valve",
                                            "creationDate" : "2001-11-06"
                                        }"""),
                                @ExampleObject(name = "Request when developer already exist",
                                value = """
                                        {
                                            "name" : "Ubisoft",
                                            "creationDate" : "1986-03-28"
                                        }""")
                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The developer created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Developer.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "The developer already exist",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Developer.class)
                        )
                )
        }
)
public @interface CreateDeveloper {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
