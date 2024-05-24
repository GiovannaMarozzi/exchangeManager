package com.util.mappers;

import com.exchangeManager.investidor.model.dto.DocumentoRecord;
import com.exchangeManager.investidor.model.entity.Documento;

import java.util.ArrayList;
import java.util.List;

public class DocumentoMapper {

    public static DocumentoRecord convert(Documento documento) {
        return new DocumentoRecord(documento.getTipo(), documento.getNumeroDocumento());
    }

    public static List<DocumentoRecord> convert(List<Documento> documentos) {
        List<DocumentoRecord> documentoRecords = new ArrayList<DocumentoRecord>();
        documentos.forEach(
                (documento) -> {
                    documentoRecords.add(convert(documento));
                }
        );

        return documentoRecords;
    }
}
