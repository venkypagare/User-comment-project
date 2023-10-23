package com.Usercommentproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime commentDateTime;

    @ManyToOne
    @JoinColumn(name = "posted_by_user_id", nullable = false)
    private User postedByUser;

    @ManyToOne
    @JoinColumn(name = "comment_to_user_id", nullable = false)
    private User commentToUser;
}
