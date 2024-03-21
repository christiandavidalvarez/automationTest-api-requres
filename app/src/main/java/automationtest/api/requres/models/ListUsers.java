package automationtest.api.requres.models;

import java.util.List;

import lombok.Data;

@Data
public class ListUsers {
    
    private List<User> data;
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;

}
