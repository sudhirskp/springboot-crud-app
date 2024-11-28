package skp.test.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import skp.test.demo.entity.Employee;
import skp.test.demo.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // Load employee data
    private EmployeeService employeeService;

    // Constructor injection of the EmployeeService
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

//   // Hard-code to add employee details
//    private List<Employee> theEmployees;
//
//    @PostConstruct
//    private void loadData() {
//        // Create employees
//        Employee emp1 = new Employee("Leslie", "Andrews", "leslie@luv2code.com");
//        Employee emp2 = new Employee("Emma", "Baumgarten", "emma@luv2code.com");
//        Employee emp3 = new Employee("Avani", "Gupta", "avani@luv2code.com");
//
//        // Create the list
//        theEmployees = new ArrayList<>();
//
//        // Add to the list
//        theEmployees.add(emp1);
//        theEmployees.add(emp2);
//        theEmployees.add(emp3);
//    }

    // Add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // Get employees from the hardcoded list or service
        // Uncomment the line below if using a service
         List<Employee> theEmployees = employeeService.findAll();

        // Add to the Spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showformforadd")
    public String addemployee(Model themodel){
        Employee theemployee = new Employee();

        //model attribute to bind form data
        themodel.addAttribute("employee",theemployee);

        return "employees/employee-form";
    }


    @GetMapping("/showformforupdate")
    public String showformforupdate(@RequestParam("employeeId") int theId,Model themodel){

        //get employee from the service

        Employee theemployee = employeeService.findById(theId);

        //set the employee in the model for prepopulation

        themodel.addAttribute("employee",theemployee);
        //send to our form

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId ){

        //delete the employee

        employeeService.deleteById(theId);

        //return to the employees/list

        return "redirect:/employees/list";

    }


    //to add employee in the list
    @PostMapping("/save")
    public String saveemployee(@ModelAttribute("employee") Employee theemployee){

        //save the employee
        employeeService.save(theemployee);

        //redirect for the duplicate submission
        return "redirect:/employees/list";
    }
}
