package com.nocaffeine.ssgclone.domain.review.infrastructure;

import com.nocaffeine.ssgclone.domain.order.domain.Orders;
import com.nocaffeine.ssgclone.domain.product.domain.Product;
import com.nocaffeine.ssgclone.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByOrder(Orders orders);

    List<Review> findByProduct(Product product);

    List<Review> findByMemberUuid(String uuid);

    List<Review> findAllByOrderAndProductId(Orders orders, Long product);
}
