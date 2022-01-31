package com.example.application.data.repositories;


import com.example.application.data.entity.Imatge;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImatgeRepository extends JpaRepository<Imatge, Integer> {

    @Query("select c from Imatge c " +
            "where lower(c.title) like lower(concat('%', :searchTerm, '%'))")
    List<Imatge> search(@Param("searchTerm") String searchTerm);

    @EntityGraph(attributePaths={"profilePicture"})
    Imatge findWithPropertyPictureAttachedById(Integer id);
}
