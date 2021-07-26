package net.kubepia.sam.restapp.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.kubepia.sam.restapp.mybatis.model.EmployeeDTO;

@Mapper
public interface SamEmployeeMapper {
  @Select("select * from employees limit 1")
  List<EmployeeDTO> selectAll();

  @Select("select * from employees limit 1")
  List<HashMap<String, Object>> selectAllMap();

  @Select("select * from employees where emp_no=#{emp_no}")
  EmployeeDTO findById(@Param("emp_no") int id);

  @Insert("insert into employees (emp_no,gender, birth_date, last_name, first_name,hire_date) values (#{empNo},#{gender}, #{birthDate}, #{lastName}, #{firstName},#{hireDate})")
  void save(EmployeeDTO employee);

  @Delete("Delete from employees where emp_no=#{emp_no}")
  void deleteEmployeeById(@Param("emp_no") int id);
}
