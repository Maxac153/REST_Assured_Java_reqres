package api.post.register.response;

import api.post.register.request.Register;

@lombok.Data
public class UnsuccessRegister {
    private String email;
    private String password;
    private String error;
}
