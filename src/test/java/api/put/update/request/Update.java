package api.put.update.request;

import lombok.Data;

@Data
public class Update {
    private String name;
    private String job;

    public Update(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
