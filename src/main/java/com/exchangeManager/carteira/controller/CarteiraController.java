package com.exchangeManager.carteira.controller;

import com.exchangeManager.carteira.model.dto.CarteiraRecord;
import com.exchangeManager.carteira.model.form.CarteiraForm;
import com.exchangeManager.carteira.model.service.CarteiraService;
import com.util.exception.InvestidorAlreadyExistsException;
import com.util.exception.NoSuchRecordException;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/carteira")
@Slf4j
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;

    @GetMapping("/todas")
    public ResponseEntity<List<CarteiraRecord>> getAll() {
        ResponseEntity<List<CarteiraRecord>> response = null;
        try {
            List<CarteiraRecord> carteiraRecords = carteiraService.buscarTodasAsCarteiras();
            response = ResponseEntity.ok(carteiraRecords);

        }catch (NoSuchRecordException noSuchRecordException){
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception exception){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

        return response;
    }

    @PostMapping("/novaCarteira")
    public ResponseEntity<CarteiraRecord> criaCarteira(){

        ResponseEntity<CarteiraRecord> response = null;
        try{
            CarteiraRecord carteiraRecord =  carteiraService.criaNovaCarteira();
            response = ResponseEntity.status(HttpStatus.CREATED).body(carteiraRecord);
        }catch (Exception exception){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;

    }

    @PutMapping("/atualizaCarteira")
    public ResponseEntity<CarteiraRecord> atualizaCarteira(@RequestBody CarteiraForm carteiraForm){

        ResponseEntity<CarteiraRecord> response = null;
        try{
            CarteiraRecord carteiraRecord = carteiraService.atualizaCarteira(carteiraForm);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body(carteiraRecord);

        }catch (NoSuchRecordException noSuchRecordException){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (Exception exception){
            response = ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

        return response;


    }

    @GetMapping("/buscaPorNumeroConta")
    public ResponseEntity<CarteiraRecord> buscaPorNumeroConta(@PathParam("conta") String conta) {

        ResponseEntity<CarteiraRecord> response = null;
        try{
            CarteiraRecord carteiraRecord = carteiraService.buscaPorNumeroConta(conta);
            response = ResponseEntity.ok(carteiraRecord);
        }catch (NoSuchRecordException noSuchRecordException){
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return response;

    }

    @DeleteMapping("/delete/{numeroConta}")
    public ResponseEntity<CarteiraRecord> deleteCarteira(@PathVariable("numeroConta")@Valid String numeroConta) throws Exception {

        ResponseEntity<CarteiraRecord> response = null;
        try {
            CarteiraRecord carteiraRecord = carteiraService.deletaCarteira(numeroConta);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body(carteiraRecord);

        } catch (NoSuchRecordException noSuchRecordException) {
            log.error("Não existe nenhuma carteira com este número de conta");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (InvestidorAlreadyExistsException exception) {
            log.error("Não foi deletada a carteira solicitada com numero de conta: "+numeroConta);
            response = ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        } catch (Exception e){
            log.error("Erro: "+e.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;

    }


}