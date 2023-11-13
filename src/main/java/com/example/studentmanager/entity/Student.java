package com.example.studentmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name="tbl_student"
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sId;
    @NotBlank(message="Enter the First Name")
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String emailId;
    @Length(min=10,max=10, message="Enter the valid phone number")
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String rollNo;
    private String dept;
    @Past(message = "enter the valid Date of birth")
    private java.sql.Date dob;
    private String guardianName;
}
