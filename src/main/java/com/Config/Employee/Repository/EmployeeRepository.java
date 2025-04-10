package com.Config.Employee.Repository;

import com.Config.Employee.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Override
    List<Employee> findAll();
    List<Employee> findByName(String name);
    List<Employee> findByDepartment(String course);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.name = :name, e.city = :city WHERE e.id = :id")
    int updateNameAndCityById(@Param("id") Long id,
                              @Param("name") String name,
                              @Param("city") String city);


    Optional<Employee> getStudentByIdAndName(Long id, String name );


}
