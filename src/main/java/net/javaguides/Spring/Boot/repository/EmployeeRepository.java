package net.javaguides.Spring.Boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.Spring.Boot.model.Employee;

@Repository
public interface EmployeeRepository  extends   JpaRepository<Employee, Long>{

}
