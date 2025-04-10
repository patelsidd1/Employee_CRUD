package com.Config.Employee.Dto;

import com.Config.Employee.Entity.Employee;

public class EmployeeDTO {

    private String name;
    private  String city;

    public EmployeeDTO(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public EmployeeDTO() {
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static EmployeeDTO formEntity(Employee employee){

        return new EmployeeDTO(employee.getName(),employee.getCity());

    }
}
