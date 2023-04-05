package com.nbsaas.boot.jpa.data.strategy;


import com.nbsaas.boot.rest.filter.Operator;

import java.util.HashMap;
import java.util.Map;

public class StrategyList {

    private static final Map<Operator, OperatorStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(Operator.eq, new EqStrategy());
        strategyMap.put(Operator.ge, new GeStrategy());
        strategyMap.put(Operator.gt, new GtStrategy());
        strategyMap.put(Operator.in, new InStrategy());
        strategyMap.put(Operator.isNotNull, new IsNotNullStrategy());
        strategyMap.put(Operator.isNull, new IsNullStrategy());
        strategyMap.put(Operator.le, new LeStrategy());
        strategyMap.put(Operator.like, new LikeStrategy());
        strategyMap.put(Operator.lt, new LtStrategy());

    }

    public static OperatorStrategy getStrategy(Operator operator) {
        if (operator == null) {
            return null;
        }
        return strategyMap.get(operator);
    }
}
