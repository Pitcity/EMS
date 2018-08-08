package itovp;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import itovp.dto.EmployeeDTO;
import itovp.entities.ManagementLevel;
import itovp.repositories.ManagementLevelsRepository;
import itovp.services.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ManagementLevelsRepository managementLevelsRepository;

    EmployeeController() {
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String initData() {
        initMethod();
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        initMethod();
        ModelAndView mnv = new ModelAndView("index");
        mnv.addObject("empl", employeeService.getAllEmployees());
        mnv.addObject("levels", managementLevelsRepository.findAll());
        System.out.println(employeeService.getAllEmployees().toString());
        return mnv;
    }

    @RequestMapping(value = "employee", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getEmployeeList() {
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(employeeService.getAllEmployees()));
    }

    @RequestMapping(value = "employee", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addEmployee(@ModelAttribute EmployeeDTO employee, BindingResult result) {
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(employeeService.getAllEmployees()));
    }

    @RequestMapping(value={"employee/{id}"}, method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployee(@PathVariable(value="id") String id ) {
        employeeService.removeEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(employeeService.getAllEmployees()));
    }

    @RequestMapping(value={"employee/{id}"}, method=RequestMethod.GET)
    public ResponseEntity<String> reviewEmployee(@PathVariable(value="id") String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(employeeService.findOne(id)));
    }

    @RequestMapping(value={"getManagers/{lvl}"}, method=RequestMethod.GET)
    public ResponseEntity<String> getManagers(@PathVariable(value="lvl") int lvl ) {
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(employeeService.getManagers(lvl)));
    }

    /*  testing only */
    public void initMethod() {
        if (managementLevelsRepository.findOne(1) == null) {
            ManagementLevel ml1 = new ManagementLevel();
            ManagementLevel ml2 = new ManagementLevel();
            ManagementLevel ml3 = new ManagementLevel();
            ManagementLevel ml4 = new ManagementLevel();
            ManagementLevel ml5 = new ManagementLevel();
            ml1.setLvl(1);
            ml1.setLvlName("Junior");
            ml2.setLvl(2);
            ml2.setLvlName("Middle");
            ml3.setLvl(3);
            ml3.setLvlName("Senior");
            ml4.setLvl(4);
            ml4.setLvlName("Lead");
            ml5.setLvl(5);
            ml5.setLvlName("Manager");
            managementLevelsRepository.save(ml1);
            managementLevelsRepository.save(ml2);
            managementLevelsRepository.save(ml3);
            managementLevelsRepository.save(ml4);
            managementLevelsRepository.save(ml5);
        }
    }
}
