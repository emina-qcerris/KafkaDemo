package com.kafkademo.kafkademo.repository;

import com.kafkademo.kafkademo.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface BoxRepository extends JpaRepository<Box, Integer> {
    @Query(value = "select * from Box",nativeQuery = true)
    Collection<Box> getAll();
}
