package com.app.restaurant_app.Yeahia.model_classes;

public class Waiter_staff {
    private final String staff_id;
    private String name;
    private long mobile_number;
    private final static String staff_type = "Waiter Staff";
    private static byte same_type_staff_count = 0;
    private static int wage_per_hour;

    public Waiter_staff(String staff_id, String name, long mobile_number) {
        this.staff_id = staff_id;
        this.name = name;
        this.mobile_number = mobile_number;
    }

    public static int getWage_per_hour() {
        return wage_per_hour;
    }

    public static void setWage_per_hour(int wage_per_hour) {
        Waiter_staff.wage_per_hour = wage_per_hour;
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
        Waiter_staff.same_type_staff_count = same_type_staff_count;
    }
}
