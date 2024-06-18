package org.example.gamemarket.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.gamemarket.entity.User;
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
@Operation(summary = "Show user by nickname",
        description = "Receiving a user by nickname",
        tags = {"USER"},
        parameters = {
                @Parameter(
                        name = "nickname",
                        description = "The unique user nickname",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Request with existing user",
                                        value = "user1"
                                ),
                                @ExampleObject(
                                        name = "Request with non-existing nickname",
                                        value = "user21"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "User received and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = User.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "User not found",
                        content = @Content()
                )
        })
public @interface GetUserByNickname {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
