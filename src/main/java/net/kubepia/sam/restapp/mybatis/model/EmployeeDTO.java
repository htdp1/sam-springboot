package net.kubepia.sam.restapp.mybatis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
  private int empNo;

  private String firstName;
  private String lastName;

  private java.util.Date hireDate;
  private String birthDate;

  private String gender;
}
