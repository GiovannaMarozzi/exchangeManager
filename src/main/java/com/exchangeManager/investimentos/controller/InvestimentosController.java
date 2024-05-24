package com.exchangeManager.investimentos.controller;

import com.exchangeManager.carteira.model.dto.CarteiraRecord;
import com.exchangeManager.carteira.model.form.CarteiraForm;
import com.exchangeManager.carteira.model.service.CarteiraService;
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
@RequestMapping("api/v1/investimentos")
@Slf4j
public class InvestimentosController {



}