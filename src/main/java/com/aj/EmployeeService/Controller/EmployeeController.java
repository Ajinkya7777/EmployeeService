package com.aj.EmployeeService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aj.EmployeeService.DTO.EmployeeDTO;
import com.aj.EmployeeService.Entity.Employee;
import com.aj.EmployeeService.Service.EmpServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmpServiceImpl service;
	
	@Autowired
	public EmployeeController(EmpServiceImpl service)
	{
		this.service=service;
	}
	
	
	
	/*  
	 * http://localhost:8080/api/employees
	 * 
	 *    [
       {
        "empId": 1,
        "empSal": 90000,
        "empMail": "Ajinkya@gmail.com",
        "empName": "Ajinkya"
        },
      {
        "empId": 4,
        "empSal": 100000,
        "empMail": "cr7@gmail.com",
        "empName": "Ronaldo"
         }
              ] 
	 */
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee()
	{
		List<EmployeeDTO> allEmployees = service.getAllEmployees();
		ResponseEntity<List<EmployeeDTO>> response = new ResponseEntity<>(allEmployees, HttpStatus.OK);
		return response;
	}
	
	
	
	/*  
	 *   http://localhost:8080/api/employee/1
	 *   
	 *   {
             "empId": 1,
             "empSal": 90000,
             "empMail": "Ajinkya@gmail.com",
             "empName": "Ajinkya"
          }
	 */
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<EmployeeDTO> getEmpById( @PathVariable(name = "empId") int empId)
	{
		EmployeeDTO empById = service.getEmpById(empId);
		return new ResponseEntity<EmployeeDTO>(empById,HttpStatus.OK);
	}
	
	
	
	
	/*  
	 * 	  http://localhost:8080/api/employee/add  
	 *      {
                  "empName":"Ajinkya",
                  "empSal":90000,
                  "empMail":"Ajinkya@gmail.com"
             }
	 * 
	 */

	@PostMapping("/employee/add")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody Employee emp)
	{
		EmployeeDTO newEmp = service.addEmployee(emp);
		return new ResponseEntity<EmployeeDTO>(newEmp,HttpStatus.CREATED);
	}
	
	
	 /*  
	  * http://localhost:8080/api/employee/update/3
	  * 
	  * {
            "empId": 3,
           "empSal": 80000,
           "empMail": "maldini@gmail.com",
             "empName": "Maldini"
           }
	  */
	@PutMapping("/employee/update/{empId}")
	public ResponseEntity<EmployeeDTO> updateEmpById(@PathVariable int empId,@RequestBody Employee emp)
	{
		EmployeeDTO empUpdated = service.updateEmpbyId(empId, emp);
		return new ResponseEntity<EmployeeDTO>(empUpdated,HttpStatus.OK);
	}
	
	
	/*
	 * http://localhost:8080/api/employee/delete/5
	 * 
	 * no content
	 * 
	 */
	
	@DeleteMapping("/employee/delete/{empId}")
	public ResponseEntity<String> deleteEmpById(@PathVariable int empId)
	{
		String empDeleted = service.deleteEmpById(empId);
		return new ResponseEntity<String>(empDeleted,HttpStatus.NO_CONTENT);
	}

}
