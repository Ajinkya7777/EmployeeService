package com.aj.EmployeeService.Mapper;

import com.aj.EmployeeService.DTO.EmployeeDTO;
import com.aj.EmployeeService.Entity.Employee;

public class EmployeeMapper {

	
	
	public static EmployeeDTO entityToDto(Employee emp) {
		EmployeeDTO dto = new EmployeeDTO();
		  dto.setEmpId(emp.getEmpId());
		  dto.setEmpName(emp.getEmpName());
		  dto.setEmpMail(emp.getEmpMail());
		  dto.setEmpSal(emp.getEmpSal());
		  return dto;
	}
	
	
	public static Employee dtoToEntity(EmployeeDTO dto)
	{
		Employee  emp = new Employee();
		 emp.setEmpName(dto.getEmpName());
		  emp.setEmpMail(dto.getEmpMail());
		  emp.setEmpSal(dto.getEmpSal());
		  return emp;
	}
}
