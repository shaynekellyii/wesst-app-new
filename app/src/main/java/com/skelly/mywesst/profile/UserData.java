package com.skelly.mywesst.profile;

/**
 * Created by skelly on 9/17/16.
 */

public class UserData {

    public static User getUser() {
        User user = new User();

        user.setName("Shayne Kelly II");
        user.setTitle("Android app developer");
        user.setOrg("WESST");
        user.setPhone("778-707-1806");
        user.setAdmin(true);
        user.setAge("21");
        user.setDegree("Computer engineering");
        user.setYear("5th year");
        user.setEmail("skellyii@sfu.ca");
        user.setSchool("Simon Fraser University");

        return user;
    }
}
