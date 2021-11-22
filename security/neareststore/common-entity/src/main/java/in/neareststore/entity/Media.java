package in.neareststore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "ns_media")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Media {
    @Id
    private String id;

    private String url;

    private String tag;

    private Store store;

    private User user;

    @CreatedDate
    private Date createdDate;
}
