package com.nhoclahola.aloute_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User
{
    @Id
    private String userId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String description;
    private Boolean gender;
    private String avatarUrl;
    private String coverPhotoUrl;
    @Enumerated(EnumType.STRING)
    private Role role;

    // | follower_id | following_id |
    // |   (join)    |  (inverse)   |

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_follow",
            joinColumns = @JoinColumn(name = "follower_id"),        // userId of this entity
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private Set<User> followings;

    @ManyToMany(mappedBy = "followings",fetch = FetchType.LAZY)
    private Set<User> followers;

    // Post

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)  // Field user of Post class
    private List<Post> posts;

    @ManyToMany(mappedBy = "liked", fetch = FetchType.LAZY)
    private Set<Post> likedPost;

    @ManyToMany(mappedBy = "saved", fetch = FetchType.LAZY)
    private Set<Post> savedPost;

    // Comment

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @ManyToMany(mappedBy = "liked", fetch = FetchType.LAZY)
    private Set<Comment> likedComments;

    @PrePersist
    public void prePersist()
    {
        this.userId = "user-" + UUID.randomUUID().toString();
    }
}
