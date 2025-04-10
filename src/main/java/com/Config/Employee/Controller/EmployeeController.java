package com.Config.Employee.Controller;

import com.Config.Employee.Dto.EmployeeDTO;
import com.Config.Employee.Entity.Employee;
import com.Config.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Getting all the Employee
    @GetMapping("/emp")
    public List<Employee> getAllUSer() {

        System.out.println("Get all the User  ");

        return employeeService.getAllEMployee();

    }

    // For Using DTO
//    @GetMapping
//    public List<EmployeeDTO> getAllUSer(){
//
//        System.out.println("Get all the User  ");
//
//        return employeeService.getAllEMployee();
//
//    }

    // Saving the Record of employee
    @PostMapping("/emp")
    public Employee saveUser(@RequestBody Employee employee) {

        System.out.println("Save User  ");

        return employeeService.createEmployee(employee);
    }

    // Deleting the record by using Id
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<Void> delteEmployee(@PathVariable Long id) {

        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    // Getting the data by using Id
    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // Getting the data by using id and name
    @GetMapping("/emp/{id}/{name}")
    public ResponseEntity<Employee> getByIdAndName(@PathVariable("id") Long id, @PathVariable("name") String name) {
        return employeeService.getEmployeeByIdAndName(id, name).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    //  Update the data by using @RequestParam
    @PostMapping("/emp/update")
    public ResponseEntity<String> updateEmployee(@RequestParam Long id,
                                                 @RequestParam String name,
                                                 @RequestParam String city) {

        int updated = employeeService.updateEmployeeNameAndCity(id, name, city);
        return (updated > 0)
                ? ResponseEntity.ok("Employee updated successfully")
                : ResponseEntity.badRequest().body("Update Failed");
    }

    // Updating the Name  and City by Id
    @PostMapping("/emp/updateq")
    public ResponseEntity<String> updateEmployee1(@RequestBody Employee employee) {

        int updated = employeeService.updateEmployeeNameAndCity(
                employee.getId(), employee.getName(), employee.getCity());

        return (updated > 0)
                ? ResponseEntity.ok("Employee updated successfully")
                : ResponseEntity.badRequest().body("Update Failed");
    }

}
