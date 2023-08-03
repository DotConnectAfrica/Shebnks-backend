package com.dotconnectafrica.shebnks_rest_api.mpesa.common;

public class Log {

    private String className;

    public Log(Class clazz) {
        this.className = clazz.getName();
    }

    public void info(String message) {
        System.out.println(this.className + "-INFO:" + message);
    }

}
