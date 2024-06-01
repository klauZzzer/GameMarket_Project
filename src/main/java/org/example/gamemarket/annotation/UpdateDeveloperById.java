package org.example.gamemarket.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
@RequestMapping(method = RequestMethod.PUT)
@Operation(
        summary = "Update developer",
        description = "Update developer and return",
        tags = {"DEVELOPER"},
        parameters = {
                @Parameter(
                        name = "Developer ID",
                        description = "The unique ID of the developer",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Existing ID",
                                        value = "5d747ad1-8fc0-471f-8d78-54fa98fd5eb6"
                                ),
                                @ExampleObject(
                                        name = "non-existing ID",
                                        value = "8eb99c7a-cee7-49ff-afe8-47199e4eb967"
                                )
                        }
                )
        },
        requestBody = @RequestBody(
                description = "The developer to be updated",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Developer.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                        value = """
                                        {
                                            "name" : "Riot",
                                            "creationDate" : "2001-11-06"
                                        }"""
                                )
                        }

                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The developer updated",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Developer.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "The developer does not exist",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Developer.class)
                        )
                )
        }
)
public @interface UpdateDeveloperById {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
