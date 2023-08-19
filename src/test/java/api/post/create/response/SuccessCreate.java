package api.post.create.response;

import java.util.Date;

@lombok.Data
public class SuccessCreate {
    private String name;
    private String job;
    private String id;
    private Date createdAt;
}
