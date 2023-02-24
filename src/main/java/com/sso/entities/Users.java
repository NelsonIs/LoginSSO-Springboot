package com.sso.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	@Id
	private String username;
	private String password;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="username"), inverseJoinColumns=@JoinColumn(name="roleId"))
	private Set<Role> roles;
	private String email;
	private String firstName;
	private String lastName;
}