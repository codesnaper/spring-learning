package in.neareststore.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "ns_category")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Category {

    @Id
    private String id;

    private String name;

    private Store storeId;

    private User user;

    private String photoUrl;

    @CreatedDate
    private Date createdDate;

}
