package api.post.register.response;

import api.post.register.request.Register;

@lombok.Data
public class SuccessRegister {
    private String email;
    private String password;
    private Integer id;
    private String token;
}
