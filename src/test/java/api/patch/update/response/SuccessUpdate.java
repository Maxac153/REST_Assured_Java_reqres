package api.patch.update.response;

import java.util.Date;

@lombok.Data
public class SuccessUpdate {
    private String name;
    private String job;
    private Date updatedAt;
}
