package in.neareststore.entity;

import in.neareststore.type.ContactType;
import in.neareststore.type.PhoneCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "ns_contact")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Contact {

    @Id
    private String id;

    private String contact;

    private String prefix;

    private String code;

    private ContactType type;

    private PhoneCode phoneCode;

    @CreatedDate
    private Date createdDate;
}
