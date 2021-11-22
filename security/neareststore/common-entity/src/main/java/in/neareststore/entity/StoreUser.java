package in.neareststore.entity;

import in.neareststore.type.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collation = "ns_store_user")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class StoreUser {
    @Id
    private String id;

    private String name;

    private Store store;

    private User user;

    private List<Role> role;

    @CreatedDate
    private Date createdDate;

}
