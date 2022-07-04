package com.example.news.repo;

import com.example.news.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM USER u where u.id = ?1", nativeQuery = true)
    User findUserById(Long userId);

}
