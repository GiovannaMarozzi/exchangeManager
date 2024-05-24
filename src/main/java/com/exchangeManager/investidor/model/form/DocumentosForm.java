package com.exchangeManager.investidor.model.form;

import com.exchangeManager.investidor.model.entity.Documento;
import lombok.Data;

@Data
public class DocumentosForm {

    private Documento.TipoDocumento tipo;
    private Long numeroDocumento;

    public enum TipoDocumento {
        RG,
        CPF,
        CNPJ;
    }
}
