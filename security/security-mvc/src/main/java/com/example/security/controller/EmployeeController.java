package com.example.security.controller;

import com.example.security.config.Constant;
import com.example.security.modal.Alert;
import com.example.security.modal.AlertCode;
import com.example.security.modal.Employee;
import com.example.security.service.IEmployeeService;
import com.example.security.util.EmployeeErrorView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/employee")
@Slf4j
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "")
    public ModelAndView getEmployee() {
        log.debug("Getting all user employee");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(employeeService.userEmployees());
        modelAndView.setViewName(Constant.VIEW_EMPLOYEE_LIST);
        return modelAndView;
    }

    @GetMapping(value = "{id}")
    public ModelAndView getEmployee(@PathVariable("id") long id) throws IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject(employeeService.getUserEmployeeById(id));
            modelAndView.setViewName(Constant.VIEW_EMPLOYEE);
        } catch (IllegalAccessException e) {
            log.error("Error {} which getting employee for id {}", e.getLocalizedMessage(), id);
            log.error(e.getStackTrace().toString());
            return EmployeeErrorView.errorEmployeeList(employeeService, modelAndView, id);
        }
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView getAddView() {
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = new Employee();
        employee.setRole(new ArrayList<>());
        modelAndView.addObject(employee);
        modelAndView.setViewName(Constant.VIEW_EMPLOYEE);
        return modelAndView;
    }

    @PostMapping(value = "")
    public ModelAndView addEmployee(@ModelAttribute Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        Alert alert = new Alert();
        try {
            employeeService.saveEmployee(employee);
            modelAndView.addObject(employeeService.userEmployees());
            alert.setMessage("Employee Added successfully");
            alert.setAlertCode(AlertCode.ALERTSUCCESS);
            modelAndView.addObject("alert", alert);
            modelAndView.setViewName(Constant.VIEW_EMPLOYEE_LIST);
        } catch (Exception e) {
            log.error("Error '{}' which adding employee {}", e.getLocalizedMessage(), employee.toString());
            log.error(e.getStackTrace().toString());
            modelAndView = EmployeeErrorView.errorEmpModalAndView(employee, modelAndView, e);
        }
        return modelAndView;
    }

    @PutMapping(value = "")
    public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        Alert alert = new Alert();
        try {
            employeeService.editEmployee(employee);
            modelAndView.addObject(employeeService.userEmployees());
            alert.setMessage("Employee Added successfully");
            alert.setAlertCode(AlertCode.ALERTSUCCESS);
            modelAndView.addObject("alert", alert);
            modelAndView.setViewName(Constant.VIEW_EMPLOYEE_LIST);
        } catch (Exception e) {
            return EmployeeErrorView.errorEmpModalAndView(employee, modelAndView, e);
        }
        return modelAndView;
    }

    @DeleteMapping("{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") long id, ModelAndView modelAndView) {
        try {
            employeeService.deleteEmployee(id);
            modelAndView.addObject(employeeService.userEmployees());
            modelAndView.setViewName(Constant.VIEW_EMPLOYEE_LIST);
        } catch (Exception e) {
            return EmployeeErrorView.errorEmployeeList(employeeService, modelAndView, id);
        }
        return modelAndView;
    }

    @GetMapping("search")
    public ModelAndView getSearchView(ModelAndView modelAndView){
        modelAndView.addObject("search",Boolean.valueOf(true));
        modelAndView.setViewName(Constant.VIEW_EMPLOYEE_LIST);
        return modelAndView;
    }

//    @GetMapping("{employeeName}")
//    public ModelAndView getEmployee(@PathVariable("employeeName") String employeeName) {
//        return null;
//    }


}
