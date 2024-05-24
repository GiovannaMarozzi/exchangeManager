package com.exchangeManager.investimentos.model.service;

import com.exchangeManager.investimentos.model.repository.InvestimentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InvestimentoService {

    @Autowired
    InvestimentoRepository investimentoRepository;

}
