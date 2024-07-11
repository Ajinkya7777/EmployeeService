package com.aj.EmployeeService.Service;

import java.util.List;

import com.aj.EmployeeService.DTO.EmployeeDTO;
import com.aj.EmployeeService.Entity.Employee;


public interface EmpService {

      List<EmployeeDTO> getAllEmployees();
     EmployeeDTO getEmpById(int empId);
     EmployeeDTO updateEmpbyId(int empId,Employee emp);
     EmployeeDTO addEmployee(Employee emp);
     String deleteEmpById(int id);
}
