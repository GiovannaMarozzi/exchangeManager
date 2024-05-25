package com.exchangeManager.carteira.model.service;

import com.exchangeManager.carteira.model.dto.CarteiraRecord;
import com.exchangeManager.carteira.model.entity.Carteira;
import com.exchangeManager.carteira.model.form.CarteiraForm;
import com.exchangeManager.carteira.model.repository.CarteiraRepository;
import com.exchangeManager.investidor.model.entity.Investidor;
import com.exchangeManager.investidor.model.repository.InvestidorRepository;
import com.util.exception.InvestidorAlreadyExistsException;
import com.util.exception.NoSuchRecordException;
import com.util.mappers.CarteiraMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarteiraService {

    @Autowired
    CarteiraRepository carteiraRepository;

    @Autowired
    InvestidorRepository investidorRepository;

    public List<CarteiraRecord> buscarTodasAsCarteiras() throws NoSuchRecordException {
        List<CarteiraRecord> carteiraRecords = null;
        List<Carteira> carteiras = carteiraRepository.findAll();
        if (carteiras == null || carteiras.isEmpty())
            throw new NoSuchRecordException("nao existem carteiras cadastradas no sistema");
        else {
            carteiraRecords = CarteiraMapper.convert(carteiras);
        }
        return carteiraRecords;
    }

    public CarteiraRecord criaNovaCarteira() {
        CarteiraRecord carteiraRecord = null;
        Carteira carteira = carteiraRepository.save(new Carteira());
        log.info("carteira criada: " + carteira);
        carteiraRecord = CarteiraMapper.convert(carteira);
        return carteiraRecord;

    }

    public CarteiraRecord atualizaCarteira(CarteiraForm carteiraForm) throws NoSuchRecordException {
        CarteiraRecord carteiraRecord = null;
        carteiraRecord = carteiraRepository.findByNumeroConta(carteiraForm.getNumeroConta());
        if (carteiraRecord == null)
            throw new NoSuchRecordException("carteira nao encontrada para atualização", carteiraRecord);

        return carteiraRecord;
    }

    public CarteiraRecord buscaPorNumeroConta(String numeroConta) throws NoSuchRecordException {
        CarteiraRecord carteiraRecord = null;
        carteiraRecord = carteiraRepository.findByNumeroConta(numeroConta);
        if (carteiraRecord != null)
            return carteiraRecord;
        else
            throw new NoSuchRecordException(carteiraRecord);
    }

    public CarteiraRecord deletaCarteira(String numeroConta) throws NoSuchRecordException, InvestidorAlreadyExistsException {
        CarteiraRecord carteiraRecord = null;
        carteiraRecord = carteiraRepository.findByNumeroConta(numeroConta);
        Investidor investidor = investidorRepository.findByCarteira_NumeroConta(numeroConta);

        if (carteiraRecord == null){
            log.error("Erro ao deletar carteira");
            throw new NoSuchRecordException("Erro ao deletar carteira");
        }else {
            Carteira carteira = CarteiraMapper.convertCarteira(carteiraRecord);
            if (investidor != null){
                investidor.setCarteira(null);
                investidorRepository.save(investidor);
                carteiraRepository.delete(carteira);
                log.info("carteira deletada: " + carteira);
                return carteiraRecord;
            }else {
                carteiraRepository.delete(carteira);
                log.info("carteira deletada: " + carteira);
                return carteiraRecord;
            }
        }
    }

}
