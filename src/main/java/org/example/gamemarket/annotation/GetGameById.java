package org.example.gamemarket.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@RequestMapping(method = RequestMethod.GET)
@Operation(summary = "Show game by ID",
        description = "Receiving a game by ID",
        tags = {"GAME"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique game ID",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "uuid"),
                        examples = {
                                @ExampleObject(
                                        name = "Request with existing ID",
                                        value = "fc698b8c-f835-4800-b633-2f7905bfa238"
                                ),
                                @ExampleObject(
                                        name = "Request with non-existing ID",
                                        value = "8eb99c7a-cee7-49ff-afe8-47199e4eb967"
                                ),
                                @ExampleObject(
                                        name = "Request with invalid ID",
                                        value = "uncorrectedUUID"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Game received and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Game.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Game not found",
                        content = @Content()
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Uncorrected UUID format",
                        content = @Content()
                )
        })
public @interface GetGameById {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
