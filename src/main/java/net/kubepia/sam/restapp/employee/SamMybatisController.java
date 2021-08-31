package net.kubepia.sam.restapp.employee;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.kubepia.sam.restapp.employee.model.EmployeeDTO;

@RestController
@Slf4j
@RequestMapping("mybatis")
public class SamMybatisController {
  @Autowired
  SamEmployeeService samEmployeeService;

  @GetMapping(value = "")
  public String index() {
    log.info("mybatis home called");
    return "mybatis api";
  }

  /**
   * Annotation API Start
   */
  @GetMapping(value = "employees")
  public @ResponseBody List<EmployeeDTO> getEmployees() {
    return samEmployeeService.getEmployees();
  }

  @GetMapping(value = "employeesmap")
  public @ResponseBody List<HashMap<String, Object>> getEmployeesMap() {
    return samEmployeeService.getEmployeesMap();
  }

  @GetMapping(value = "employees/{id}")
  public @ResponseBody EmployeeDTO findEmployee(@PathVariable(required = false) Integer id) {
    return samEmployeeService.getEmployee(id);
  }

  @PostMapping(value = "employee")
  public EmployeeDTO insertEmployee(@RequestBody EmployeeDTO employee) {
    this.samEmployeeService.insertEmployee(employee);
    return samEmployeeService.getEmployee(employee.getEmpNo());
  }

  @DeleteMapping(value = "employees/{id}")
  public String removeEmployee(@PathVariable(required = false) Integer id) {
    this.samEmployeeService.deleteEmployeeById(id);
    return "{\"status\":\"ok\"}";
  }

  /******************************* */

  /**
   * Transaction Test
   */
  @PostMapping(value = "employees")
  public EmployeeDTO insertEmployees(@RequestBody EmployeeDTO employee) {
    this.samEmployeeService.insertEmployees(employee);
    return samEmployeeService.getEmployee(employee.getEmpNo());
  }

  @PostMapping(value = "tr/employees")
  public EmployeeDTO insertEmployeestr(@RequestBody EmployeeDTO employee) {
    try {
      this.samEmployeeService.insertEmployeesTR(employee);
    } catch (Exception e) {
    }

    return samEmployeeService.getEmployee(employee.getEmpNo());
  }

  /************************** */

  /**
   * Mapp XML API Start
   */

  @GetMapping(value = "xml/employees")
  public @ResponseBody List<EmployeeDTO> getEmployeesXml() {
    return samEmployeeService.getEmployees();
  }

  @GetMapping(value = "xml/employeesmap")
  public @ResponseBody List<HashMap<String, Object>> getEmployeesMapXml() {
    return samEmployeeService.getEmployeesMap();
  }

  @GetMapping(value = "xml/employees/{id}")
  public @ResponseBody EmployeeDTO findEmployeeXml(@PathVariable(required = false) Integer id) {
    return samEmployeeService.getEmployee(id);
  }

  @PostMapping(value = "xml/employee")
  public EmployeeDTO insertEmployeeXml(@RequestBody EmployeeDTO employee) {
    this.samEmployeeService.insertEmployee(employee);
    return samEmployeeService.getEmployee(employee.getEmpNo());
  }

  @DeleteMapping(value = "xml/employees/{id}")
  public String removeEmployeeXml(@PathVariable(required = false) Integer id) {
    this.samEmployeeService.deleteEmployeeById(id);
    return "{\"status\":\"ok\"}";
  }

  /******************************* */

}
