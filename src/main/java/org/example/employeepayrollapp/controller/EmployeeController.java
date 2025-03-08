package org.example.employeepayrollapp.controller;

import org.example.employeepayrollapp.dto.EmployeeDTO;
import org.example.employeepayrollapp.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll")
public class EmployeeController {

  @Qualifier("IEmployeeService")
  @Autowired
  IEmployeeService iEmployeeService;
  
  @GetMapping("/get/{id}")
  public EmployeeDTO get(@PathVariable Long id) {
    return iEmployeeService.get(id);
  }

  @PostMapping("/create")
  public EmployeeDTO create(@RequestBody EmployeeDTO newEmp) {
    return iEmployeeService.create(newEmp);
  }

  @PutMapping("/edit/{id}")
  public EmployeeDTO edit(@RequestBody EmployeeDTO emp, @PathVariable Long id) {
    return iEmployeeService.edit(emp, id);
  }

  @DeleteMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    return iEmployeeService.delete(id);
  }
}