package com.sso.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sso.entities.Role;

public interface RoleRepository extends PagingAndSortingRepository< Role , Long > {
	
}