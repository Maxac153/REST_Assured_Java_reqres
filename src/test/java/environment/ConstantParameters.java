package environment;

public class ConstantParameters {
    private final static String baseURL = "https://reqres.in/";

    private final static String urlDelete = "api/users?page=2";
    private final static String urlListUsers = "api/users?page=";
    private final static String urlSingleUser = "/api/users/";
    private final static String urlUpdatePatch = "api/users?page=2";
    private final static String urlCreate = "/api/users";
    private final static String urlLogin = "api/login";
    private final static String urlRegister = "api/register";
    private final static String urlUpdatePut = "api/users/2";


    public static String getBaseURL() {
        return baseURL;
    }

    public static String getUrlDelete() {
        return urlDelete;
    }

    public static String getUrlListUsers() {
        return urlListUsers;
    }

    public static String getUrlSingleUser() {
        return urlSingleUser;
    }

    public static String getUrlUpdatePatch() {
        return urlUpdatePatch;
    }

    public static String getUrlCreate() {
        return urlCreate;
    }

    public static String getUrlLogin() {
        return urlLogin;
    }

    public static String getUrlRegister() {
        return urlRegister;
    }

    public static String getUrlUpdatePut() {
        return urlUpdatePut;
    }
}
