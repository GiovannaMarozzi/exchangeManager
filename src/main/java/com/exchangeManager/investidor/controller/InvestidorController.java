package com.exchangeManager.investidor.controller;

import com.exchangeManager.investidor.model.dto.interfaces.InvestidorRecordI;
import com.exchangeManager.investidor.model.form.InvestidorForm;
import com.exchangeManager.investidor.model.service.InvestidorService;
import com.util.exception.InvestidorAlreadyExistsException;
import com.util.exception.NoSuchRecordException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/investidor")
@Slf4j
public class InvestidorController {

    @Autowired
    private InvestidorService investidorService;

    @PostMapping("/novo")
    public ResponseEntity novoInvestidor(@RequestBody InvestidorForm investidorForm){
        ResponseEntity response = null;

        try{
            InvestidorRecordI investidorRecord = investidorService.novoInvestidor(investidorForm);
            response = ResponseEntity.status(HttpStatus.CREATED).body(investidorRecord);
        } catch (InvestidorAlreadyExistsException exception){
            log.error(exception.getMessage());
            response = ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        } catch (Exception exception){
            log.error(exception.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
        return response;
    }

    @GetMapping("/busca")
    public ResponseEntity<List<InvestidorRecordI>>busca(@RequestParam Boolean carteira) {
        ResponseEntity<List<InvestidorRecordI>> response = null;

        try {
            List<InvestidorRecordI> investidorRecordIList =  investidorService.findAll(carteira);
            response = ResponseEntity.ok(investidorRecordIList);
        }catch (NoSuchRecordException noSuchRecordException){
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception exception){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }

    @GetMapping("/documento")
    public ResponseEntity buscaPorDocumento(@RequestParam Long documento) throws Exception {
        ResponseEntity response = null;

        try {
            InvestidorRecordI investidor =  investidorService.buscaPorDocumento(documento);
            response = ResponseEntity.ok(investidor);
        }catch (NoSuchRecordException exception){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }catch (Exception exception){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        return response;
    }

    @PutMapping("/editar")
    public ResponseEntity updateInvestidor(@RequestBody @Valid InvestidorForm investidorForm) throws Exception {
        ResponseEntity response = null;

        try{
            InvestidorRecordI investidorRecord = investidorService.atualizarInvestidor(investidorForm);
            response = ResponseEntity.ok(investidorRecord);
        } catch (NoSuchRecordException exception){
            log.error(exception.getMessage());
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception){
            log.error(exception.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
        return response;
    }

    @DeleteMapping("/delete/{numeroDocumento}")
    public ResponseEntity deleteInvestidor(@PathVariable("numeroDocumento") Long numeroDocumento) throws Exception {

        ResponseEntity response = null;

        try {
            InvestidorRecordI investidorRecordI = investidorService.deleteInvestidor(numeroDocumento);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body(investidorRecordI);
        }catch (NoSuchRecordException exception){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }catch (Exception exception){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        return response;
    }
}