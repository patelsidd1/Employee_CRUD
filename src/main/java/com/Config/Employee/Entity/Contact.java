package com.Config.Employee.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;
    private Long phone;
    private String email;

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
    @JsonBackReference
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Contact(Long eid, Long phone, String email, Employee employee) {
        this.eid = eid;
        this.phone = phone;
        this.email = email;
        this.employee = employee;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "eid=" + eid +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", employee=" + employee +
                '}';
    }
}
