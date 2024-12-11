package com.mydemo.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "student")
@Setter
@Getter
public class Student  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(max = 45, message = "Name must be less than 45 characters")
    private String name;

    private String address;

    @NotBlank(message = "Gender is required")
    private String gender = "M";

    @NotBlank(message = "Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @Email(message = "Invalid email format")
    private String email;

    @Size(max = 15, message = "Phone number must be less than 15 characters")
    private String phone;


}
