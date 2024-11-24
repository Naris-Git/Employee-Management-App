package net.javaguides.Spring.Boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.Spring.Boot.model.Employee;
import net.javaguides.Spring.Boot.repository.EmployeeRepository;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employess

	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeByid(@PathVariable Long id){
		return new ResponseEntity<>(employeeRepository.findById(id), HttpStatus.OK) ;
	}

	@PostMapping("/employees")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
		employeeRepository.save(employee);
		return new ResponseEntity<>("employee created successfully..",HttpStatus.CREATED);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployess(){
		return  employeeRepository.findAll();
	}

	@PutMapping("/employees/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
	Employee emp=	employeeRepository.findById(id).orElse(new Employee());

	emp.setEmailId(employee.getEmailId());
	emp.setFirstName(employee.getFirstName());
	emp.setLastName(employee.getLastName());
    employeeRepository.save(emp);
		return "employee updated successfully..";
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployeeById(@PathVariable Long id){
		employeeRepository.deleteById(id);
		return "employee deleted successfully..";
	}
}
