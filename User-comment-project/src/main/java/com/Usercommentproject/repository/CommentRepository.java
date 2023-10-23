package com.Usercommentproject.repository;

import com.Usercommentproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// CommentRepository.java
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCommentToUser_UserName(String userName);
}