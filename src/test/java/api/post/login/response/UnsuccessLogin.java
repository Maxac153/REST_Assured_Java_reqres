package api.post.login.response;

public class UnsuccessLogin {
    private String error;

    public UnsuccessLogin() {}

    public UnsuccessLogin(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
