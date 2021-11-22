package in.neareststore.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    ADMIN("admin");
    private String role;
}
