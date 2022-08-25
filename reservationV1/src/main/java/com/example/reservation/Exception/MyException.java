package com.example.reservation.Exception;

import lombok.Data;

@Data
public class MyException extends Exception{

    private String errorMsg;

    public MyException() {
    }

    public MyException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
}
