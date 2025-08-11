package com.app.restaurant_app;

public class Employee {
    private final int employee_id;
    private final String employee_type;
    private String password;


    public Employee(int employee_id, String employee_type, String password) {
        this.employee_id = employee_id;
        this.employee_type = employee_type;
        this.password = password;
    }
    public Employee(int employee_id, String employee_type) {
        this.employee_id = employee_id;
        this.employee_type = employee_type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public int getEmployee_id() {
        return employee_id;
    }
    public static final Employee verify_login(int employee_id,String password){
        
    }


}

