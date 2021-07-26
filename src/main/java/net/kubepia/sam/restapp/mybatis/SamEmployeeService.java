package net.kubepia.sam.restapp.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.kubepia.sam.restapp.mybatis.model.EmployeeDTO;

@Service
@Slf4j
public class SamEmployeeService {
  @Autowired
  SamEmployeeMapper samEmployeeMapper;

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

  public void insertEmployees(EmployeeDTO employee) {
    this.samEmployeeMapper.save(employee);
    employee.setEmpNo(9900);
    this.samEmployeeMapper.save(employee);
  }

  @Transactional(rollbackFor = Exception.class)
  public void insertEmployeesTR(EmployeeDTO employee) {
    this.samEmployeeMapper.save(employee);
    employee.setEmpNo(9900);
    this.samEmployeeMapper.save(employee);
  }

  public void deleteEmployeeById(int id) {
    this.samEmployeeMapper.deleteEmployeeById(id);
  }
}
