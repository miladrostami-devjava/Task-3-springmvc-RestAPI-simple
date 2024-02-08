package org.example.controller;

import org.example.controller.dto.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/web")
public class EmployeeRestController {

    @RequestMapping(value = "/employeesContacts/{requiredContactNumber}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeContactNumber(
            @MatrixVariable(required = true ) String requiredContactNumber){
        List<Employee> employeeList = new ArrayList<>();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{name}" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeByNameAndBeginContactNumber(
            @PathVariable String name, @MatrixVariable(required = true) String beginContactNumber){
        List<Employee> employeeList = new ArrayList<>();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @RequestMapping("/employeeData/{employee}")
    public ResponseEntity<Map<String,String>> getEmployeeData(
            @MatrixVariable (required = true ,pathVar = "employee") Map<String,String> getMatrix,
            @PathVariable String employee){
        return  new ResponseEntity<>(getMatrix,HttpStatus.OK);
    }

}
