package com.api.apiregions_backend.Controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.api.apiregions_backend.Modeles.Comment;
import com.api.apiregions_backend.Repositories.CommentRepository;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment createdComment = commentRepository.save(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.OK);
    }

    @GetMapping("/region/{regionId}")
    public ResponseEntity<List<Comment>> getCommentsByRegion(@PathVariable Long regionId) {
        List<Comment> comments = commentRepository.findByRegionId(regionId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
