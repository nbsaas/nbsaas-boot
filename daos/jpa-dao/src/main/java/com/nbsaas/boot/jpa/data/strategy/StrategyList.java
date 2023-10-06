/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

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
        strategyMap.put(Operator.lt, new LtStrategy());
        strategyMap.put(Operator.like, new LikeStrategy());
        strategyMap.put(Operator.likeSuffix, new likeSuffixStrategy());
        strategyMap.put(Operator.likePrefix, new likePrefixStrategy());
        strategyMap.put(Operator.between, new BetweenStrategy());

    }

    public static OperatorStrategy getStrategy(Operator operator) {
        if (operator == null) {
            return null;
        }
        return strategyMap.get(operator);
    }
}
