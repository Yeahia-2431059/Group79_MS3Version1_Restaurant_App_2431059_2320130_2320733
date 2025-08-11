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

        ArrayList<Object> employee_arraylist = new ArrayList<Object>(Utility.read_object("data_files/employee_data.bin"));

        for (Object employee : employee_arraylist) {

            if ((((Employee) employee).getEmployee_id()) == employee_id) {

                if (((Employee) employee).getPassword().isEmpty()) {
                    ((Employee) employee).setPassword(password_textfield.getText());

                    if (employee instanceof Waiter_staff) {
                        ((Waiter_staff) employee).setName(name_textfield.getText());
                        ((Waiter_staff) employee).setMobile_number(Long.parseLong(mobile_number_textfield.getText()));
                        Waiter_staff.setSame_type_staff_count((byte) (Waiter_staff.getSame_type_staff_count() + 1));
                        scene_changer(actionEvent, "Yeahia/Waiter_staff_dashboard_scene.fxml");
                        Waiter_dashboard_controller.get_resources((Waiter_staff) employee);
                    }
                   // else if (employee instanceof Restaurant_manager) {
                   //     ((Restaurant_manager) employee).setName(name_textfield.getText());
                   //     ((Restaurant_manager) employee).setMobile_number(Long.parseLong(mobile_number_textfield.getText()));

                   //     scene_changer(actionEvent,"Yeahia/Restaurant_manager_dashboard.fxml");
                   //     Restaurant_manager_dashboard_controller.get_resources((Restaurant_manager)employee);
                   // }
                    write_object("data_files/employee_data.bin", employee);
                } 
                else {
                    alert = new Alert(Alert.AlertType.INFORMATION, "Already exists!, please log in instead");
                    alert.showAndWait();
                }
            }
        }
    }
}


