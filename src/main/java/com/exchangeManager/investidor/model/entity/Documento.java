package com.exchangeManager.investidor.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "documento")
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

    @Id
    private Long numeroDocumento;
    private TipoDocumento tipo;

    public enum TipoDocumento {
        RG,
        CPF,
        CNPJ;
    }
}
