package org.wecode23.springboot.domain.products.repositories;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.wecode23.springboot.domain.products.entities.Product;

import java.util.*;

import static org.wecode23.springboot.domain.products.entities.QProduct.product;

@Repository
public class ProductQueryDSLRepository extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public ProductQueryDSLRepository(JPAQueryFactory queryFactory) {
        super(Product.class);
        this.queryFactory = queryFactory;
    }

    public List findByFilter(Map<String, String[]> param) {
        String[] group = param.get("group");
        String[] subCategory = param.get("sub-category");
        String[] color = param.get("color");
        String[] size = param.get("size");
        String[] priceRange = param.get("price");
        String[] sort = param.getOrDefault("sort", new String[]{"id"});
        String[] limit = param.get("limit");
        String[] offset = param.get("offset");

        BooleanBuilder builder = new BooleanBuilder();

        if (!StringUtils.isEmpty(group)) {
            builder.and(product.group.in(group));
        }

        if (subCategory != null) {
            List<Long> subCategoryList = new ArrayList<>();
            for (String s : subCategory) {
                subCategoryList.add(Long.valueOf(s));
            }
            builder.and(product.subCategory.id.in(subCategoryList));
        }

        if (color != null) {
            List<Long> colorList = new ArrayList<>();
            for (String s : color) {
                colorList.add(Long.valueOf(s));
            }
            builder.and(product.color.id.in(colorList));
        }

        if (size != null) {
            List<Long> sizeList = new ArrayList<>();
            for (String s : size) {
                sizeList.add(Long.valueOf(s));
            }
            builder.and(product.productOptionSet.any().size.id.in(sizeList));
        }

        if (priceRange != null) {
            BooleanBuilder priceRangeBuilder = new BooleanBuilder();
            for (String s: priceRange) {
                priceRangeBuilder.or(getPriceRange(s));
            }
            builder.and(priceRangeBuilder);
        }

        JPAQuery<Product> resultQuery = queryFactory.selectFrom(product)
                .where(builder)
                .orderBy(getSortKey(sort[0]));

        if (offset != null) {
            resultQuery.offset(Long.parseLong(offset[0]));
        }

        if (limit != null) {
            resultQuery.limit(Long.parseLong(limit[0]));
        }

        return resultQuery.fetch();
    }

    public OrderSpecifier getSortKey(String sortKey) {
        switch (sortKey) {
            case "low-price" : return product.price.asc();
            case "high-price" : return product.price.desc();
            case "newest" : return product.manufactureDate.desc();
        }
        return product.id.asc();
    }

    public BooleanExpression getPriceRange(String priceRangeKey) {
        switch (priceRangeKey) {
            case "1" : return product.price.between(0,49999);
            case "2" : return product.price.between(50000,99999);
            case "3" : return product.price.between(100000,149999);
            case "4" : return product.price.between(150000,199999);
            case "5" : return product.price.goe(200000);
        }
        return null;
    }


}
