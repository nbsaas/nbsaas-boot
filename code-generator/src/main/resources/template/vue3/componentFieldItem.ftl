<#include "componentFieldInput.ftl"/>

<#macro fieldItem item>
    <el-col :span="${item.col!12}">
        <#if item.type='richText'>
            <div style="margin-left: 160px;">
                <vue-ueditor-wrap v-model="form.${item.id!}" :config="config" ref="${item.id!}"></vue-ueditor-wrap>
            </div>
        <#else>
            <el-form-item label="${item.title!}"  prop="${item.id!}">
                <@componentInput item />
            </el-form-item>
        </#if>

    </el-col>
</#macro>