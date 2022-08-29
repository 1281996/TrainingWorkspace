package com.cog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cog.entity.UserMapping;

public interface UserMappingRepository extends JpaRepository<UserMapping, Integer> {

}
