package net.kubepia.sam.restapp.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.kubepia.sam.restapp.mybatis.model.EmployeeDTO;

@Mapper
public interface SamEmployeeXmlMapper {
  List<EmployeeDTO> selectAll();

  List<HashMap<String, Object>> selectAllMap();

  EmployeeDTO findById(int id);

  void save(EmployeeDTO employee);

  void deleteEmployeeById(int id);
}
