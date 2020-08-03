package com.test.birds.repository;

import com.test.birds.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdRepository extends JpaRepository<Bird, String> {

    List<Bird> findAllByName(String name);

//    @Query(value="SELECT * FROM birds  limit ?2 offset ?1", nativeQuery = true)
//    Bird saveAndFlush(Bird bird);

    @Query(value="SELECT * FROM birds  limit ?2 offset ?1", nativeQuery = true)
    public List<Bird> findByAttributeWithOffsetAndLimit(int offset, int limit);

    @Query(value="SELECT * FROM birds  limit ?1", nativeQuery = true)
    public List<Bird> findAllWithLimit(int limit);


}

