package com.Config.Employee.Repository;

import com.Config.Employee.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {



}
