package org.wecode23.springboot.domain.reviews.entities;

import lombok.*;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import org.wecode23.springboot.domain.products.entities.Category;
import org.wecode23.springboot.domain.users.entities.User;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "review_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Review review;

    @Column(name = "like")
    private Boolean like;

    @Builder
    public Like(User user, Review review, Boolean like) {

        this.user    = user;
        this.review  = review;
        this.like    = like;

    }
}
