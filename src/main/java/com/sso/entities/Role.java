package com.sso.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = -7255545677800576509L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roleId;
	private String name;
	 
	@Transient
	@Override
	public String getAuthority() {
		return name;
	}	 
}