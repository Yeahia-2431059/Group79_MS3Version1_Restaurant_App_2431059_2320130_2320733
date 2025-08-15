package com.app.restaurant_app.Soyaiminul.model_classes;

import com.app.restaurant_app.Employee;

import java.io.Serializable;

public class Marketing_manager extends Employee implements Serializable {
    private String name;
    private long mobile_number;
    private static byte same_type_staff_count = 0;

    public Marketing_manager(int staff_id, String staff_type) {
        super(staff_id,staff_type);
    }
}
