package in.neareststore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "ns_store")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Store {

    @Id
    private String id;

    private String name;

    private Address address;

    private String type;

    private String subDomain;

    private Date openingTime;

    private Date closingTime;

    private String[] days;

    private String[] imagesUrls;

    private String description;

    private String email;

    private Contact contact;

    private Boolean deliverySupport;

    @CreatedDate
    private Date createdDate;
}
