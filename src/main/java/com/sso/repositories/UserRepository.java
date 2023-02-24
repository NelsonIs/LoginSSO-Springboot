package com.sso.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sso.entities.Users;

public interface UserRepository extends PagingAndSortingRepository< Users , String > {
	
}