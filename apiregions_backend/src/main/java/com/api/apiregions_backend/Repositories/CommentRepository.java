package com.api.apiregions_backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.apiregions_backend.Modeles.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByRegionId(Long regionId);
}