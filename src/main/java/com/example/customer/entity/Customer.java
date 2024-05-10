package com.example.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "customers")
public class Customer {

@Id
@Column(name = "id", nullable = false)
private Long id;

@Column (name = "name", nullable = false)
private String name;

@Column (name = "email", nullable = false)
private String email;

@Column (name = "password", nullable = false)
private String password;

@Column (name = "phone")
private String phone;

}
