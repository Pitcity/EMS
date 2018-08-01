package itovp;

import com.google.gson.Gson;
import itovp.entities.Employee;
import itovp.entities.ManagementLevel;
import itovp.repositories.ManagementLevelsRepository;
import itovp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class EmployeeController {

    private static final String KEY_FOR_EMPLOYEES = "KEY_FOR_EMPLOYEES";

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ManagementLevelsRepository managementLevelsRepository;

    EmployeeController() {
        System.out.println("tratata 55");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView lookupMemberById() {
        initMethod();
        System.out.println("lookupMemberById");
        ModelAndView mnv = new ModelAndView("index");
        mnv.addObject("empl", employeeService.getAllEmployees());
        mnv.addObject("levels", managementLevelsRepository.findAll());
        System.out.println(employeeService.getAllEmployees().toString());
        return mnv;
    }

    @RequestMapping(value = "getEmployeeList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> getEmployeeList() {
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(employeeService.getAllEmployees()));
    }

    /*  testing only */
    public void initMethod() {

        System.out.println("insert test data st");
        ManagementLevel ml1 = new ManagementLevel();
        if (managementLevelsRepository.findOne(1) == null) {
            ml1.setLvl(1);
            ml1.setLvlName("dfdf");
            managementLevelsRepository.save(ml1);
        }
        if (employeeService.getAllEmployees().size() == 0) {
            Employee empl1 = new Employee();
            Employee empl2 = new Employee();
            empl1.setEmployeeId("id1");
            empl2.setEmployeeId("id2");
            empl1.setName("Name1");
            empl2.setName("Name2");
            empl1.setSurname("Surname1");
            empl2.setSurname("Surname2");
            empl1.setSalary(new BigDecimal(132));
            empl2.setSalary(new BigDecimal(132));
            empl1.setAddress("some adress");
            empl2.setAddress("some adress");
            empl1.setBirthday(new Date());
            empl2.setBirthday(new Date());
            empl1.setHiringDate(new Date());
            empl2.setHiringDate(new Date());
            empl1.setEmail("ghgh@gfhgg.gg");
            empl2.setEmail("g1hgh@gfhgg.gg");
            empl1.setManagementLevel_id(managementLevelsRepository.findOne(1));
            empl2.setManagementLevel_id(managementLevelsRepository.findOne(1));
            empl1.setManager(empl2);
            employeeService.addEmployee(empl2);
            employeeService.addEmployee(empl1);
        }

        System.out.println("insert test data fin");
    }
}
