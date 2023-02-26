package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.context.TableContext;
import org.apache.commons.chain2.Processing;

public class FinishCommand extends BaseCommand {
    @Override
    public Processing handle(TableContext context) {

        if (context.getTable() != null) {
            System.out.println(context.getTable().getName() + "代码生成完成");
        }
        if (context.getFormBean() != null) {
            System.out.println(context.getFormBean().getClassName() + "代码生成完成");
        }
        return Processing.CONTINUE;
    }

    @Override
    public String outPath() {
        return null;
    }
}
