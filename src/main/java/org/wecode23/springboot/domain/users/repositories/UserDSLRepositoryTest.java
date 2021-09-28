package org.wecode23.springboot.domain.users.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.wecode23.springboot.domain.users.entities.User;

import static org.wecode23.springboot.domain.users.entities.QUser.user;

@Repository
public class UserDSLRepositoryTest extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public UserDSLRepositoryTest(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;
    }

    public User findById(Long id) {
        return queryFactory.selectFrom(user)
                .where(user.id.eq(Long.valueOf(id)))
                .fetchOne();
    }
}
