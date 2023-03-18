package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public class FinishCommand extends BaseCommand {
    @Override
    public ResponseObject handle(InputRequestObject context) {

        if (context.getTable() != null) {
            System.out.println(context.getTable().getName() + "代码生成完成");
        }
        if (context.getFormBean() != null) {
            System.out.println(context.getFormBean().getClassName() + "代码生成完成");
        }
        return ResponseObject.success();
    }

    @Override
    public String outPath() {
        return null;
    }
}
