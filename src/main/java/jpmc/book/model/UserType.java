package jpmc.book.model;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
    ADMIN("admin"),
    BUYER("buyer");

    private String value;

    private static Map<String, UserType> BY_VALUE = new HashMap<>();

    static {
        for(UserType userType: values()) {
            BY_VALUE.put(userType.value, userType);
        }
    }

    UserType(String value) {
        this.value = value;
    }

    public static UserType getUserTypeByValue(String value) {
        return BY_VALUE.get(value);
    }

}
