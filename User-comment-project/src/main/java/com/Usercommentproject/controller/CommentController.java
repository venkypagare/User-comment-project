package com.Usercommentproject.controller;

import com.Usercommentproject.entity.Comment;
import com.Usercommentproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// CommentController.java
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<String> addComment(
            @RequestParam String fromUserName,
            @RequestParam String toUserName,
            @RequestParam String message) {
        String result = commentService.addComment(fromUserName, toUserName, message);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Comment>> getComments(@RequestParam String toUserName) {
        List<Comment> comments = commentService.getComments(toUserName);
        return ResponseEntity.ok(comments);
    }
}
