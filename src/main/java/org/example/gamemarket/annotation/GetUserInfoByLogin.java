package org.example.gamemarket.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.gamemarket.entity.UserInfo;
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
@Operation(summary = "Show userInfo by login",
        description = "Receiving a userInfo by login",
        tags = {"USERINFO"},
        parameters = {
                @Parameter(
                        name = "login",
                        description = "The unique userInfo login",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Request with existing login",
                                        value = "userLogin"
                                ),
                                @ExampleObject(
                                        name = "Request with non-existing login",
                                        value = "login21"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "UserInfo received and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserInfo.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "UserInfo not found",
                        content = @Content()
                )
        })
public @interface GetUserInfoByLogin {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
