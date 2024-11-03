package com.nhoclahola.aloute_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment
{
    @Id
    private String commentId;
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name ="comment_liked",
            joinColumns = { @JoinColumn(name = "comment_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<User> liked;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist()
    {
        this.commentId = "comment-" + UUID.randomUUID().toString();
    }
}
