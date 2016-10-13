package com.skelly.mywesst.schools;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by skelly on 9/17/16.
 */

public class SchoolsData {

    final static private int DATASET_COUNT = 10;

    public static List<School> getSchoolList() {
        List<School> schools = new LinkedList<>();

        for (int i = 0; i < DATASET_COUNT; i++) {
            School school = new School();
            school.setName(String.format(Locale.ENGLISH, "Simon Fraser University %d", i+1));
            school.setInfo("What a great place");
            schools.add(school);
        }

        return schools;
    }
}
