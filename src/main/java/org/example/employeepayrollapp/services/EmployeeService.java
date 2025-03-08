package org.example.employeepayrollapp.services;

import org.example.employeepayrollapp.dto.EmployeeDTO;
import org.example.employeepayrollapp.entities.EmployeeEntity;
import org.example.employeepayrollapp.interfaces.IEmployeeService;
import org.example.employeepayrollapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;

  public EmployeeDTO get(Long id) {

    EmployeeEntity empFound =
        employeeRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Cannot find Employee with given id"));

    EmployeeDTO empDto = new EmployeeDTO(empFound.getName(), empFound.getSalary());
    empDto.setId(empFound.getId());

    return empDto;
  }

  public EmployeeDTO create(EmployeeDTO newEmp) {
    EmployeeEntity newEntity = new EmployeeEntity(newEmp.getName(), newEmp.getSalary());
    employeeRepository.save(newEntity);

    EmployeeDTO emp = new EmployeeDTO(newEntity.getName(), newEntity.getSalary());
    emp.setId(newEntity.getId());

    return emp;
  }

  public EmployeeDTO edit(EmployeeDTO emp, Long id) {
    EmployeeEntity foundEmp =
        employeeRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("No employee found for given id"));
    foundEmp.setName(emp.getName());
    foundEmp.setSalary(emp.getSalary());

    employeeRepository.save(foundEmp);

    EmployeeDTO employeeDTO = new EmployeeDTO(foundEmp.getName(), foundEmp.getSalary());
    employeeDTO.setId(foundEmp.getId());

    return employeeDTO;
  }

  public String delete(Long id) {
    EmployeeEntity foundEmp =
        employeeRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("No employee found for given id"));
    employeeRepository.delete(foundEmp);
    return "Employee Deleted";
  }
}