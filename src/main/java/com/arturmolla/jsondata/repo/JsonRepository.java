package com.arturmolla.jsondata.repo;

import com.arturmolla.jsondata.data.MultiPurposeJson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonRepository extends JpaRepository<MultiPurposeJson, Long> {
}
