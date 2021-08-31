package net.kubepia.sam.restapp.employee;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.kubepia.sam.restapp.employee.model.EmployeeDTO;

@Service
@Slf4j
public class SamEmployeeService {
  @Autowired
  SamEmployeeMapper samEmployeeMapper;
  @Autowired
  SamEmployeeXmlMapper samEmployeeXmlMapper;

  // Annotation method
  public List<EmployeeDTO> getEmployees() {
    log.info("service called");
    return samEmployeeMapper.selectAll();
  }

  public List<HashMap<String, Object>> getEmployeesMap() {
    log.info("service called");
    return samEmployeeMapper.selectAllMap();
  }

  public EmployeeDTO getEmployee(int id) {
    return samEmployeeMapper.findById(id);
  }

  public void insertEmployee(EmployeeDTO employee) {
    this.samEmployeeMapper.save(employee);
  }

  public void deleteEmployeeById(int id) {
    this.samEmployeeMapper.deleteEmployeeById(id);
  }

  // Transaction test
  public void insertEmployees(EmployeeDTO employee) {
    this.samEmployeeMapper.save(employee);
    employee.setEmpNo(9900);
    this.samEmployeeMapper.save(employee);
  }

  @Transactional(rollbackFor = Exception.class)
  public void insertEmployeesTR(EmployeeDTO employee) throws Exception {
    this.samEmployeeMapper.save(employee);
    employee.setEmpNo(9900);
    throw new Exception("intended error");
    // this.samEmployeeMapper.save(employee);
  }

  // Mapp Xml service
  public List<EmployeeDTO> getEmployeesXml() {
    log.info("service called");
    return samEmployeeXmlMapper.selectAll();
  }

  public List<HashMap<String, Object>> getEmployeesMapXml() {
    log.info("service called");
    return samEmployeeXmlMapper.selectAllMap();
  }

  public EmployeeDTO getEmployeeXml(int id) {
    return samEmployeeXmlMapper.findById(id);
  }

  public void insertEmployeeXml(EmployeeDTO employee) {
    this.samEmployeeMapper.save(employee);
  }

  public void deleteEmployeeByIdXml(int id) {
    this.samEmployeeMapper.deleteEmployeeById(id);
  }
}
