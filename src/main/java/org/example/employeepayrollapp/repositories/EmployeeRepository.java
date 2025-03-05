package org.example.employeepayrollapp.repositories;

import org.example.employeepayrollapp.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {}