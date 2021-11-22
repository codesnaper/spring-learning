package in.neareststore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collation = "ns_user")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class User {

    private Map<Store, Coupon> storeCouponMap = new HashMap<>();
}
