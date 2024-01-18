package com.proj.CrudApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.CrudApp.Students;
import java.util.*;

@Repository
public interface StudentDAO extends JpaRepository<Students, Integer> {

    List<Students> findByCourse(String course);

}
