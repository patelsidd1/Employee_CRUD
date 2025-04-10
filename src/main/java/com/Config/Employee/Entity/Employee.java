package com.Config.Employee.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String department;
    private String city;
    private String state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee", referencedColumnName = "eid")
    @JsonManagedReference
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee(long id, String name, String department, String city, String state, Contact contact) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.city = city;
        this.state = state;
        this.contact = contact;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", contact=" + contact +
                '}';
    }
}
