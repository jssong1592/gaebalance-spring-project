package org.wecode23.springboot.domain.carts.entities;

import lombok.*;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import org.wecode23.springboot.domain.products.entities.Product;
import org.wecode23.springboot.domain.products.entities.Size;
import org.wecode23.springboot.domain.users.entities.User;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "size_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Size size;

    @Column(name = "count", columnDefinition = "INTEGER DEFAULT 0")
    private Integer count;

    @Builder
    public Cart(User user, Product product, Size size, Integer count) {

        this.user = user;
        this.product = product;
        this.size = size;
        this.count = count;
    }

    public void increaseCount(Integer count) {
        this.count += count;
    }
}
