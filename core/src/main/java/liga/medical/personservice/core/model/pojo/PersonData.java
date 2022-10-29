package liga.medical.personservice.core.model.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class PersonData {

    private long id;
    private String lastName;
    private String firstName;
    private Date birthDt;
    private long age;
    private String sex;
    private long contactId;
    private long medicalCardId;
    private long parentId;
}
