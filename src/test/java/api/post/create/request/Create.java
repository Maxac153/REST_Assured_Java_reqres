package api.post.create.request;

import lombok.Data;

@Data
public class Create {
    private String name;
    private String job;

    public Create(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
