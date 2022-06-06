package com.kimcompany.jangbogbackendver2.Util;


public class ResponseDto {

    private int state;
    private String message;
    private Object data;

    public ResponseDto(int state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
}
