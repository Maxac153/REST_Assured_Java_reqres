package api.get.list_users.response;

import java.util.ArrayList;

@lombok.Data
public class ListUsers {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private ArrayList<Object> data;
    private Support support;

    @lombok.Data
    public class Support {
        private String url;
        private String text;
    }
}
