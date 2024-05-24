package com.exchangeManager.investidor.model.dto;

import com.exchangeManager.investidor.model.dto.interfaces.InvestidorRecordI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record InvestidorRecord(

        String nome,
        List<DocumentoRecord> documentos,
        Long celular,
        String email,
        SexoRecord sexo,
        String profissao,
        LocalDate dataNascimento,
        BigDecimal renda,
        EnderecoRecord enderecoRecord


) implements InvestidorRecordI {

}
