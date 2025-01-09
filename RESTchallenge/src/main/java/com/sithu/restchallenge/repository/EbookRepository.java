package com.sithu.restchallenge.repository;

import com.sithu.restchallenge.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Integer> {
}
