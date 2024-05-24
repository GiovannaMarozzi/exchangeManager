package com.exchangeManager.investidor.model.service;

import com.exchangeManager.investidor.model.dto.interfaces.InvestidorRecordI;
import com.exchangeManager.investidor.model.entity.Investidor;
import com.exchangeManager.investidor.model.form.InvestidorForm;
import com.exchangeManager.investidor.model.repository.InvestidorRepository;
import com.util.exception.InvestidorAlreadyExistsException;
import com.util.exception.NoSuchRecordException;
import com.util.mappers.InvestidorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestidorService {

    private static final Logger log = LoggerFactory.getLogger(InvestidorService.class);
    @Autowired
    InvestidorRepository investidorRepository;

    public List<InvestidorRecordI> findAll(Boolean carteira ) throws NoSuchRecordException {
        List<InvestidorRecordI> investidorRecordIList = null;
        List<Investidor>  investidores = null;
        if(Boolean.TRUE.equals(carteira)){
            investidores = investidorRepository.findAll();
            investidorRecordIList = InvestidorMapper.converterComCarteira(investidores);
        }else{
            investidores = investidorRepository.findAllSemCarteira();
            investidorRecordIList = InvestidorMapper.converterSemCarteira(investidores);
        }

        if(investidorRecordIList == null || investidorRecordIList.isEmpty())
            throw new NoSuchRecordException("Nao foram encontrados investidores usando filtro de carteira " + carteira);

        return investidorRecordIList;
    }

    private InvestidorRecordI criaOuAtualiza(InvestidorForm investidorForm, boolean atualizacao) throws InvestidorAlreadyExistsException, NoSuchRecordException {
        InvestidorRecordI investidorRecord = null;

        Investidor investidor = InvestidorMapper.converter(investidorForm);
        Investidor investidorExistente = investidorRepository.findByDocumentos_NumeroDocumento(investidorForm.getDocumentos().get(0).getNumeroDocumento());

        if (investidorExistente == null && Boolean.FALSE.equals(atualizacao)){
            investidorRecord = persistInvestidor(investidor);
            log.info("Investidor Criado");
            return investidorRecord;
        }else if(investidorExistente != null && Boolean.TRUE.equals(atualizacao)){
            investidor.setId(investidorExistente.getId());
            investidorRecord = persistInvestidor(investidor);
            log.info("Investidor Atualizado");
            return investidorRecord;
        }
        else{
            if (Boolean.FALSE.equals(atualizacao)){
                throw new InvestidorAlreadyExistsException("Erro ao criar o investidor: "+investidorForm.getDocumentos().get(0).getTipo().name()+" de numero: "+investidorForm.getDocumentos().get(0).getNumeroDocumento());
            }else {
                throw new NoSuchRecordException("Erro ao atualizar o investidor: "+investidorForm.getDocumentos().get(0).getTipo().name()+" de numero: "+investidorForm.getDocumentos().get(0).getNumeroDocumento());
            }
        }
    }

    private InvestidorRecordI persistInvestidor(Investidor investidor) {
        InvestidorRecordI investidorRecord;
        Investidor novoInvestidor = investidorRepository.save(investidor);
        investidorRecord = InvestidorMapper.converterComCarteira(novoInvestidor);
        return investidorRecord;
    }

    public InvestidorRecordI novoInvestidor(InvestidorForm investidorForm) throws InvestidorAlreadyExistsException, NoSuchRecordException {
        return criaOuAtualiza(investidorForm, false);
    }

    public InvestidorRecordI buscaPorDocumento(Long numeroDocumento) throws NoSuchRecordException {
        Investidor investidorExistente = investidorRepository.findByDocumentos_NumeroDocumento(numeroDocumento);

        if (investidorExistente != null){
            return InvestidorMapper.converterComCarteira(investidorExistente);
        }else{
            throw new NoSuchRecordException("O investidor com o numero de documento: "+numeroDocumento+" não existente!");
        }

    }

    public InvestidorRecordI atualizarInvestidor(InvestidorForm investidorForm) throws NoSuchRecordException, InvestidorAlreadyExistsException {
        return criaOuAtualiza(investidorForm, true);
    }


    public InvestidorRecordI deleteInvestidor(Long numeroDocumento) throws NoSuchRecordException {
        Investidor investidor = investidorRepository.findByDocumentos_NumeroDocumento(numeroDocumento);
        if (investidor == null){
            throw new NoSuchRecordException("O investidor com o numero de documento: "+numeroDocumento+" não existente!");
        }else {
            investidorRepository.delete(investidor);
            return InvestidorMapper.converterComCarteira(investidor);
        }
    }
}
