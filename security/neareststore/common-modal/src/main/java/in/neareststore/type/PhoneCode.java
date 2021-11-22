package in.neareststore.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PhoneCode {

    MOBILE_PREFIX("+91"),
    TELANGANA_CODE("040");

    private String code;
}
