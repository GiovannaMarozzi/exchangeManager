package com.exchangeManager.investimentos.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "investimento")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
