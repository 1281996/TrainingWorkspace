package com.cog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cog.entity.User;

@Repository
public interface UserRepostority extends JpaRepository<User, Integer> {

}
