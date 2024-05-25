package com.exchangeManager.carteira.model.repository;

import com.exchangeManager.carteira.model.dto.CarteiraRecord;
import com.exchangeManager.carteira.model.entity.Carteira;
import com.exchangeManager.investidor.model.entity.Investidor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

    CarteiraRecord findByNumeroConta(String numeroConta);
    CarteiraRecord deleteByNumeroConta(String numeroConta);
}
