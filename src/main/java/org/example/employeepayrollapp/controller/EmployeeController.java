package org.example.employeepayrollapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.employeepayrollapp.dto.EmployeeDTO;
import org.example.employeepayrollapp.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/payroll")
@Slf4j
public class EmployeeController {
  @Qualifier("IEmployeeService")
  @Autowired
  IEmployeeService iEmployeeService;

  @GetMapping("/get/{id}")
  public EmployeeDTO get(@Valid @PathVariable Long id) {
    log.info("Employee tried to get with id: {}", id);
    return iEmployeeService.get(id);
  }

  @PostMapping("/create")
  public EmployeeDTO create(@Valid @RequestBody EmployeeDTO newEmp) {
    log.info("Employee tried to create with body: {}", getJSON(newEmp));
    return iEmployeeService.create(newEmp);
  }

  @PutMapping("/edit/{id}")
  public EmployeeDTO edit(@Valid @RequestBody EmployeeDTO emp,@Valid @PathVariable Long id) {
    log.info("Employee tried to edit with id : {} and body : {}", id, getJSON(emp));
    return iEmployeeService.edit(emp, id);
  }

  @DeleteMapping("/delete/{id}")
  public String delete(@Valid @PathVariable Long id){
    log.info("Employee tried to delete with id: {}", id);
    return iEmployeeService.delete(id);
  }

  @GetMapping("/clear")
  public String clear(){

    log.info("Database clear request is made");
    return iEmployeeService.clear();

  }

  public String getJSON(Object object){
    try {
      ObjectMapper obj = new ObjectMapper();
      return obj.writeValueAsString(object);
    }
    catch(JsonProcessingException e){
      log.error("Reason : {} Exception : {}", "Conversion error from Java Object to JSON");
    }
    return null;
  }
}