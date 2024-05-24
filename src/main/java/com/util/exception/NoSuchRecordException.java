package com.util.exception;

public class NoSuchRecordException extends Exception{

    NoSuchRecordException(){
        super("Registro nao encontrado");
    }

    NoSuchRecordException(String message){
        super(message);
    }

    public NoSuchRecordException(Object record){
        super("Registro nao encontrado: " + record.toString());
    }


    public NoSuchRecordException(String message, Object record){
        super("message " + record.toString());
    }
}
