package com.cos.blogv2.empl;

import com.cos.blogv2.empl.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
class EmployeeController {
    public record JsonEmployee(long id, String name, String email, String department) {}

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<JsonEmployee> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(data -> new JsonEmployee(data.getId(), data.getName(), data.getEmail() ,data.getDepartment()))
                .toList();
    }

    @GetMapping({"/showEmployees"})
    public ModelAndView showEmployees() {
        var mav = new ModelAndView("list-employees");
        mav.addObject("employees", getAllEmployees());
        return mav;
    }

//    @GetMapping({"/showEmployees", "/", "/list"})
//    public ModelAndView showEmployees() {
//        var mav = new ModelAndView("list-employees");
//        var list = employeeRepository.findAll();
//        mav.addObject("employees", list);
//        return mav;
//    }
}
