package jpmc.book.identity;

import jpmc.book.model.UserType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRole {

    private static Map<UserType, List<Role>> userRoleMap = new HashMap<>();

    static {
        List<Role> adminRoles = new ArrayList<>();
        adminRoles.add(Role.MANAGE_SHOW);
        userRoleMap.put(UserType.ADMIN, adminRoles);

        List<Role> buyerRoles = new ArrayList<>();
        buyerRoles.add(Role.MANAGE_BOOKING);
        userRoleMap.put(UserType.BUYER, buyerRoles);
    }

    public static List<Role> getRoles(UserType userType) {
        return userRoleMap.get(userType);
    }

}
