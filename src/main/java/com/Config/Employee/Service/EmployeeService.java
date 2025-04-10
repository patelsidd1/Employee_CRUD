package com.Config.Employee.Service;

import com.Config.Employee.Entity.Employee;
import com.Config.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEMployee() {
        return employeeRepository.findAll();
    }

    // When using DTO
//    public List<EmployeeDTO> getAllEMployee(){
//        List<Employee> employees = employeeRepository.findAll();
//        return employees.stream().map(EmployeeDTO ::formEntity).collect(Collectors.toList());
//    }

    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {

        employeeRepository.deleteById(id);
    }

    public Employee update(Long id, Employee employeeDetails) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found "));
        employee.setName(employeeDetails.getName());
        employee.setCity(employeeDetails.getCity());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setState(employeeDetails.getState());

        return employeeRepository.save(employee);

    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);

    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Optional<Employee> getEmployeeByIdAndName(Long id, String name) {
        return employeeRepository.getStudentByIdAndName(id, name);

    }

    public int updateEmployeeNameAndCity(Long id, String name, String city) {
        return employeeRepository.updateNameAndCityById(id, name, city);

    }
}
