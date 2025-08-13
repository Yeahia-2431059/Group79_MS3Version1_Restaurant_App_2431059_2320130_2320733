package com.app.restaurant_app.Yeahia.model_classes;

import com.app.restaurant_app.Employee;

public class Restaurant_manager extends Employee {

    private String name;
    private long mobile_number;
    private static byte same_type_staff_count = 0;

    public Restaurant_manager(int staff_id, String staff_type) {
        super(staff_id,staff_type);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(long mobile_number) {
        this.mobile_number = mobile_number;
    }

    public static short getSame_type_staff_count() {
        return same_type_staff_count;
    }

    public static void setSame_type_staff_count(byte same_type_staff_count) {
        Restaurant_manager.same_type_staff_count = same_type_staff_count;
    }
}
