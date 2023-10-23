package com.Usercommentproject.service_Impl;

import com.Usercommentproject.entity.Comment;
import com.Usercommentproject.entity.User;
import com.Usercommentproject.repository.CommentRepository;
import com.Usercommentproject.service.CommentService;
import com.Usercommentproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

// CommentServiceImpl.java
@Service
public class CommentService_Impl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    private boolean isValidUserName(String userName) {
        return !userName.isEmpty() && userName.matches("^[a-zA-Z]+$");
    }

    @Transactional
    @Override
    public String addComment(String fromUserName, String toUserName, String message) {
        if (!isValidUserName(fromUserName) || !isValidUserName(toUserName)) {
            throw new IllegalArgumentException("Invalid Request: User name should not be empty and must contain only alphabets.");
        }

        User fromUser = userService.addUser(fromUserName);
        User toUser = userService.addUser(toUserName);

        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setCommentDateTime(LocalDateTime.now());
        comment.setPostedByUser(fromUser);
        comment.setCommentToUser(toUser);

        commentRepository.save(comment);

        return "Comment added successfully";
    }

    @Override
    public List<Comment> getComments(String toUserName) {
        if (!isValidUserName(toUserName)) {
            throw new IllegalArgumentException("Invalid Request: User name should not be empty and must contain only alphabets.");
        }

        return commentRepository.findByCommentToUser_UserName(toUserName);
    }
}
