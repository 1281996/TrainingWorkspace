package com.cog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cog.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
