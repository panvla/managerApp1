package com.vladimirpandurov.managerApp1.service;

import com.vladimirpandurov.managerApp1.exception.UserNotFoundException;
import com.vladimirpandurov.managerApp1.model.Employee;
import com.vladimirpandurov.managerApp1.repository.EmployeeRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id){
        this.employeeRepository.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return this.employeeRepository.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found!"));
    }

    public List<Employee> findAllEmployees(){
        return this.employeeRepository.findAll();
    }

}
