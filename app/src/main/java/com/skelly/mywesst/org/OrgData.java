package com.skelly.mywesst.org;

import com.skelly.mywesst.profile.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by skelly on 9/17/16.
 */

public class OrgData {

    final private static int NUM_USERS = 60;

    public static Org getOrgData(String orgType) {

        Org org = new Org();

        switch (orgType) {
            case "school":
                org.setName("Simon Fraser University");
                org.setAddress("8888 University Drive\nBurnaby BC\nV6S 2L0");
                org.setEmail("communications@esss.ca");
                org.setInfo("WESST is BESST!");
                org.setPhone("778-704-9210");
                org.setWebsite("http://esss.ca/");
                break;
            case "org":
                org.setName("WESST");
                org.setAddress("8888 University Drive\nBurnaby BC\nV6S 2L0");
                org.setEmail("vp-comm@wesst.ca");
                org.setInfo("WESST is BESST!");
                org.setPhone("778-704-9210");
                org.setWebsite("http://wesst.ca/");
                break;
            default:
                throw new IllegalArgumentException();
        }

        return org;
    }

    public static List<User> getOrgUsers() {
        List<User> users = new LinkedList<>();

        for (int i = 0; i < NUM_USERS; i++) {
            User user = new User();
            user.setAdmin(false);
            user.setName(String.format(Locale.ENGLISH, "User %d", i));
            user.setOrg(getOrgData("org").getName());
            user.setTitle("Cool person");

            users.add(user);
        }

        return users;
    }
}
