package com.aj.EmployeeService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aj.EmployeeService.DTO.EmployeeDTO;
import com.aj.EmployeeService.Entity.Employee;
import com.aj.EmployeeService.Mapper.EmployeeMapper;
import com.aj.EmployeeService.Repository.MyRepository;

@Service
public class EmpServiceImpl implements EmpService {
	
	private MyRepository repo;
	
		@Autowired
		public EmpServiceImpl(MyRepository repo)
		{
			this.repo=repo;
		}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> emps = repo.findAll();
		List<EmployeeDTO> dto = new ArrayList<>();
		for(Employee emp:emps)
		{
			dto.add(EmployeeMapper.entityToDto(emp));
		}
		return dto;
	}

	@Override
	public EmployeeDTO getEmpById(int empId) {
		Optional<Employee> optional = repo.findById(empId);
		 
			   return EmployeeMapper.entityToDto(optional.get());
		   
	}
	
	/* 
	 * http://localhost:8080/api/employee/update/3  
	 * 
	 *   {
               "empId": 3,
               "empSal": 80000,
               "empMail": "maldini@gmail.com",
              "empName": "Maldini"
          }
	 */

	@Override
	public EmployeeDTO updateEmpbyId(int empId, Employee emp) {
		Optional<Employee> optional = repo.findById(empId);
		Employee old=null;
              if(optional.get()!=null)
              {
            	  old=optional.get();
            	  old.setEmpMail(emp.getEmpMail());
            	  old.setEmpName(emp.getEmpName());
            	  old.setEmpSal(emp.getEmpSal());
              }
              repo.save(old);
		return EmployeeMapper.entityToDto(old);
	}

	@Override
	public EmployeeDTO addEmployee(Employee emp) {
		return EmployeeMapper.entityToDto(repo.save(emp)); 
		
	}

	@Override
	public String deleteEmpById(int empId) {
		repo.deleteById(empId);
		return "Deleted Successfully";
	}

}
