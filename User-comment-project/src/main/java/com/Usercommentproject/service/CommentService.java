package com.Usercommentproject.service;

import com.Usercommentproject.entity.Comment;

import java.util.List;

// CommentService.java
public interface CommentService {
    String addComment(String fromUserName, String toUserName, String message);
    List<Comment> getComments(String toUserName);
}
