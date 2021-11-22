package in.neareststore.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import in.neareststore.type.SubscriptionType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "ns_subscription")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Subscription {

    @Id
    private String id;

    private User user;

    private SubscriptionType subscriptionType;

    private Store store;

    private Boolean isReportEnable;

    private Date endDate;

    @CreatedDate
    private Date createdDate;
}
