package org.example.employeepayrollapp.controller;

import org.example.employeepayrollapp.dto.EmployeeDTO;
import org.example.employeepayrollapp.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

  EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/get/{id}")
  public EmployeeDTO get(@PathVariable Long id) {
    return employeeService.get(id);
  }

  @PostMapping("/create")
  public EmployeeDTO create(@RequestBody EmployeeDTO newEmp) {
    return employeeService.create(newEmp);
  }

  @PutMapping("/edit/{id}")
  public EmployeeDTO edit(@RequestBody EmployeeDTO emp, @PathVariable Long id) {
    return employeeService.edit(emp, id);
  }

  @DeleteMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    return employeeService.delete(id);
  }
}