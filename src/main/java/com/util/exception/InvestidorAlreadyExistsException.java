package com.util.exception;

public class InvestidorAlreadyExistsException extends Exception{
    public InvestidorAlreadyExistsException(){
        super("Investidor ja existente!");
    }

    public InvestidorAlreadyExistsException(String message){
        super(message);
    }
}
