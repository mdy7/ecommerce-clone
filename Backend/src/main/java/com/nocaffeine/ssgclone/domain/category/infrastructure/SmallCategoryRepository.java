package com.nocaffeine.ssgclone.domain.category.infrastructure;

import com.nocaffeine.ssgclone.domain.category.domain.SmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmallCategoryRepository extends JpaRepository<SmallCategory, Long> {
    List<SmallCategory> findByMediumCategoryId(Long id);

}
