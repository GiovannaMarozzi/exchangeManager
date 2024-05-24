package com.exchangeManager.investidor.model.repository;

import com.exchangeManager.investidor.model.dto.InvestidorRecord;
import com.exchangeManager.investidor.model.entity.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvestidorRepository extends JpaRepository<Investidor, Long> {

    @Query("SELECT i FROM com.exchangeManager.investidor.model.entity.Investidor i")
    List<Investidor> findAllSemCarteira();

    Investidor findByDocumentos_NumeroDocumento(Long numeroDocumento);
}
