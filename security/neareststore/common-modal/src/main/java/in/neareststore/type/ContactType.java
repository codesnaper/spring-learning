package in.neareststore.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContactType {

    MOBILE("mobile"),
    LANDLINE("landline");

    private String type;
}
