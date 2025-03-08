package org.example.employeepayrollapp.interfaces;

import org.example.employeepayrollapp.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public interface IEmployeeService {
  EmployeeDTO get(Long id);

  EmployeeDTO create(EmployeeDTO newEmp);

  EmployeeDTO edit(EmployeeDTO emp, Long id);

  String delete(Long id);
}