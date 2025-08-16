package com.app.restaurant_app.Yeahia.model_classes;

import com.app.restaurant_app.Employee;

import java.io.Serializable;

public class Waiter_staff extends Employee implements Serializable {
    private static int wage_per_hour;

    public Waiter_staff(int staff_id ,String staff_type) {

        super(staff_id,staff_type);

    }

    public static int getWage_per_hour() {
        return wage_per_hour;
    }

    public static void setWage_per_hour(int wage_per_hour) {
        Waiter_staff.wage_per_hour = wage_per_hour;
    }

}
