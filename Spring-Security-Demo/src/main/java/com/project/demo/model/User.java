package com.project.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users") //if we have different table name
public class User {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) //hibernate will create id
	private int id;
	private String username;
	private String password;
}
