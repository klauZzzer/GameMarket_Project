package org.example.gamemarket.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.entity.Game;
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
        summary = "Create a new game",
        description = "Creation of a new game and return",
        tags = {"GAME"},
        requestBody = @RequestBody(
                description = "The game to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Game.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                value = """
                                        {
                                            "name" : "Dota 2",
                                            "price" : "00.00",
                                            "developer" : null,
                                            "genres" : null,
                                        }"""),
                                @ExampleObject(name = "Request when game already exist",
                                value = """
                                        {
                                            "name" : "Cyberpunk 2077",
                                            "price" : "59.99",
                                            "developer" : null,
                                            "genres" : null,
                                        }""")
                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The game created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Game.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "The game already exist",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Game.class)
                        )
                )
        }
)
public @interface CreateGame {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
