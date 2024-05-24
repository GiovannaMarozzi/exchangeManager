package com.exchangeManager.investidor.model.dto;

import com.exchangeManager.carteira.model.dto.CarteiraRecord;
import com.exchangeManager.investidor.model.dto.interfaces.InvestidorRecordI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record InvestidorCarteiraRecord(
        String nome,
        List<DocumentoRecord> documento,
        Long celular,
        String email,
        SexoRecord sexo,
        String profissao,
        LocalDate dataNascimento,
        BigDecimal renda,
        EnderecoRecord enderecoRecord,
        CarteiraRecord carteiraRecord
) implements InvestidorRecordI {

}
