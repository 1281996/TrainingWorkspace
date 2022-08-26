package com.cog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cog.entity.UserMapping;
@Repository
public interface UserMappingRepo extends JpaRepository<UserMapping, Integer> {

}
