package in.neareststore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "ns_address")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Address {

    private String id;

    private String line1;

    private String line2;

    private String city;

    private String country;

    private int postalCode;

    private String longitude;

    private String langitude;

    @CreatedDate
    private Date createdDate;
}
