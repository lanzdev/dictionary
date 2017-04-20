package com.lanzdev.utils.validators;

public enum Regex {

    ORIGIN("[^(\\s\\d.;?!,)][a-zA-ZА-Яа-я\\d,;.?!\\s]{2,255}"),
    ANTONYM("[^(\\s\\d.;?!,)][a-zA-ZА-Яа-я\\d,;.?!\\s]{2,255}"),
    DEFINITION("[^(\\s\\d.;?!,)][a-zA-ZА-Яа-я\\d,;.?!\\s]{2,255}"),
    PERMISSION("[^(\\s\\d.;?!,)][a-zA-ZА-Яа-я\\d,;.?!\\s]{2,255}"),
    ROLE("[^(\\s\\d.;?!,)][a-zA-ZА-Яа-я\\d,;.?!\\s]{2,255}"),
    PRIVACY("[^(\\s\\d.;?!,)][a-zA-ZА-Яа-я\\d,;.?!\\s]{2,255}"),
    SYNONYM("[^(\\s\\d.;?!,)][a-zA-ZА-Яа-я\\d,;.?!\\s]{2,255}"),
    LOGIN("/^[a-z0-9_-]{3,16}$/"),
    PASSWORD("/^[a-z0-9_-]{6,18}$/"),
    EMAIL("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$");

    private String expression;

    Regex(String expression) {
        this.expression = expression;
    }

    public String getExpression( ) {
        return expression;
    }
}
