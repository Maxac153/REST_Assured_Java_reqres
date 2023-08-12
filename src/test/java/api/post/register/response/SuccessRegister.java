package api.post.register.response;

import api.post.register.request.Register;

public class SuccessRegister extends Register {
    private Integer id;
    private String token;

    public SuccessRegister() {
    }

    public SuccessRegister(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
