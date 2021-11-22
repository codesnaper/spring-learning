package in.neareststore.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "ns_payment")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Payment {

    @Id
    private String id;

    @CreatedDate
    private Date createdDate;

    //TODO: need to implement
}
