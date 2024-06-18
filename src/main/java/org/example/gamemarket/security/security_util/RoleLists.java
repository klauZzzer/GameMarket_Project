package org.example.gamemarket.security.security_util;

public class RoleLists {
    public static final String[] SWAGGER_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-resources",
            "/swagger-ui/",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/webjars/**",
            "/configuration/**",
            "/configuration/ui",
            "/configuration/security",
            "/public",
            "/favicon.ico",
            "/h2-console/**",
            "/conference/v1/swagger-ui.html",
            "/swagger-resources/configuration/ui",
            "/swagger-resources/configuration/security",
            "/",
            "/login", "/logout",
            "/csrf"
    };

    public static final String[] ANYROLES_LIST = {
            "/game/get/id/**",
            "/game/get/name/**",
            "/developer/get/id/**",
            "/developer/get/name/**",
            "/user/**"
    };

    public static final String[] ADMIN_LIST = {
            "/game/delete/**",
            "/game/update/**",
            "/game/create",
            "/developer/create",
            "/userInfo/get/id/**",
            "/userInfo/get/username/**"
    };
}
