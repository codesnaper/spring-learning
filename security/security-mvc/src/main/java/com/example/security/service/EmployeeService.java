package com.example.security.service;

import com.example.security.entity.Demographic;
import com.example.security.entity.Role;
import com.example.security.entity.UserRole;
import com.example.security.mappper.EmployeeMapper;
import com.example.security.modal.Employee;
import com.example.security.repository.IDemographicRepository;
import com.example.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService{

    private final IDemographicRepository iDemographicRepository;

    private final RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeService(IDemographicRepository iDemographicRepository, RoleRepository roleRepository) {
        this.iDemographicRepository = iDemographicRepository;
        this.roleRepository = roleRepository;
    }

    public List<Employee> userEmployees(){
        return iDemographicRepository
                .findAll()
                .stream()
                .map(EmployeeMapper::getUserEmployee)
                .filter(employee -> employee !=null)
                .collect(Collectors.toList());
    }

    public Employee getUserEmployeeById(long id) throws IllegalAccessException{
        Demographic demographic =  iDemographicRepository
                .findById(id)
                .orElseThrow(IllegalAccessException::new);
        Employee employee =  EmployeeMapper.setEmployee(demographic);
        return EmployeeMapper.addRole(employee, demographic);
    }

    @Transactional
    public Employee saveEmployee(Employee employee){
        List<Role> roles = roleRepository.findAll();
        Role emptyRole = roleRepository.findByName(com.example.security.modal.Role.NO_ROLE.getValue());
        Demographic demographic = EmployeeMapper.getDemographic(employee,roles,emptyRole);
        demographic.getUser().setPassword(passwordEncoder.encode(demographic.getUser().getPassword()));
        iDemographicRepository.save(demographic);
        return employee;
    }

    public Employee editEmployee(Employee employee){
        Demographic demographic = iDemographicRepository.findById(employee.getId())
                .orElseThrow(IllegalArgumentException::new);
        EmployeeMapper.demographicUpdate(demographic, employee);
        iDemographicRepository.save(demographic);
        return employee;
    }

    public void deleteEmployee(long id){
        Demographic demographic = iDemographicRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        iDemographicRepository.delete(demographic);
    }

    public List<Employee> getEmployee(String name){
        return iDemographicRepository.findAllByFirstNameOrLastName(name,name)
                .stream().map(EmployeeMapper::convertDemographicToEmployee)
                .collect(Collectors.toList());
    }
}
