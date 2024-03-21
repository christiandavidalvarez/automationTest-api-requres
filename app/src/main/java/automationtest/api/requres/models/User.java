package automationtest.api.requres.models;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String avatar;

}
