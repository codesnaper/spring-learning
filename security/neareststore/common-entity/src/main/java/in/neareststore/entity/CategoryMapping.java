package in.neareststore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "ns_category_mapping")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class CategoryMapping {

    @Id
    private String id;

    private Category category;

    private Category category1;

    private Category category2;

    private Category category3;

    private Category category4;

    private Store store;

    private User user;

    @CreatedBy
    private Date createdBy;
}
