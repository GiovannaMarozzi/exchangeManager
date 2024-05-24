package com.exchangeManager.investidor.model.dto;

import com.exchangeManager.investidor.model.entity.Documento;

public record DocumentoRecord(Documento.TipoDocumento tipo, Long numeroDocumento) {
}
