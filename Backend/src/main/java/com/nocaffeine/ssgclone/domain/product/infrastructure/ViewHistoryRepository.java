package com.nocaffeine.ssgclone.domain.product.infrastructure;

import com.nocaffeine.ssgclone.domain.member.domain.Member;
import com.nocaffeine.ssgclone.domain.product.domain.Product;
import com.nocaffeine.ssgclone.domain.product.domain.ViewHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViewHistoryRepository extends JpaRepository<ViewHistory, Long> {

    List<ViewHistory> findByMemberOrderByCreatedAtDesc(Member member);

    void deleteByMemberAndProduct(Member member, Product product);

    Optional<ViewHistory> findByMemberAndProduct(Member member, Product product);

    Page<ViewHistory> findByMemberOrderByCreatedAtDesc(Member member, Pageable pageable);
}