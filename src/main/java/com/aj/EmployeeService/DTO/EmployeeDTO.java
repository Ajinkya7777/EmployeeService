package com.aj.EmployeeService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
  private int empId;
  private int empSal;
  private String empMail;
  private String empName;
  
}
