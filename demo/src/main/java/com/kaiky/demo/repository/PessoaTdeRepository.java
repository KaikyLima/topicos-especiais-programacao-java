package com.kaiky.demo.repository;

import com.kaiky.demo.model.PessoaTde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaTdeRepository extends JpaRepository<PessoaTde, Long> {

}
