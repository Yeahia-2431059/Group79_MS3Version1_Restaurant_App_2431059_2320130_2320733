package com.app.restaurant_app.Yeahia.model_classes;

public class Restaurant_manager {
    private final String staff_id;
    private String name;
    private long mobile_number;
    private final static String staff_type = "Restaurant Manager";
    private static byte same_type_staff_count = 1;

    public Restaurant_manager(String staff_id, String name, long mobile_number) {
        this.staff_id = staff_id;
        this.name = name;
        this.mobile_number = mobile_number;
    }

    public String getStaff_id() {
        return staff_id;
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
