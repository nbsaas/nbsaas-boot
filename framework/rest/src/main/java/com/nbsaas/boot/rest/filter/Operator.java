package com.nbsaas.boot.rest.filter;

/**
 * @author ada
 */
public enum Operator {
    eq,
    ne,
    gt,
    lt,
    ge,
    le,
    like,
    in,
    notIn,
    isNull,
    isNotNull,
    between;

    Operator() {
    }

    public Operator fromString(String value) {
        return valueOf(value.toLowerCase());
    }
}