package com.sushant.BookMyshow.BookMyshow.Repository;

import com.sushant.BookMyshow.BookMyshow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
