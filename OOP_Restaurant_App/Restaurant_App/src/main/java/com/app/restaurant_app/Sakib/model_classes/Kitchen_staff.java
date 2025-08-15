package com.app.restaurant_app.Sakib.model_classes;

import com.app.restaurant_app.Employee;

import java.io.Serializable;

public class Kitchen_staff extends Employee implements Serializable {
    private String name;
    private long mobile_number;

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

    public Kitchen_staff(int staff_id, String staff_type) {
        super(staff_id,staff_type);
    }
}
