package environment;

import lombok.Getter;

public class ConstantParameters {
    @Getter
    private final static String baseURL = "https://reqres.in/";
    @Getter
    private final static String urlDelete = "api/users?page=2";
    @Getter
    private final static String urlListUsers = "api/users?page=";
    @Getter
    private final static String urlSingleUser = "/api/users/";
    @Getter
    private final static String urlUpdatePatch = "api/users?page=2";
    @Getter
    private final static String urlCreate = "/api/users";
    @Getter
    private final static String urlLogin = "api/login";
    @Getter
    private final static String urlRegister = "api/register";
    @Getter
    private final static String urlUpdatePut = "api/users/2";
}
