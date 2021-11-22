package in.neareststore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collation = "ns_coupon")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Coupon {

    @Id
    private String id;

    private Store store;

    private User user;

    private String title;

    private String code;

    private Date startDate;

    private Date endDate;

    private Boolean freeShipping;

    private int quantity;

    private String type;

    private Boolean status;

    private Boolean isProductSpecific;

    private Boolean isCategorySpecific;

    private List<Product> products;

    private List<Category> categories;

    private double minimumSpend;

    private double maximumSpend;

    private int perCustomer;

    private double perLimit;

    @CreatedDate
    private Date createdDate;
}
