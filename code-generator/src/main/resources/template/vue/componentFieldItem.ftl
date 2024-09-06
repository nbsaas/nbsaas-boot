<#include "componentFieldInput.ftl"/>

<#macro fieldItem item>
    <el-col :span="${item.col!12}">
        <#if item.type='richText'>
            <div style="margin-left: 160px;">
                <sc-editor v-model="form.${item.id!}" placeholder="请输入" style="width: 100%;"  :height="400"></sc-editor>
            </div>
        <#else>
            <el-form-item label="${item.title!}"  prop="${item.id!}">
                <@componentInput item />
            </el-form-item>
        </#if>

    </el-col>
</#macro>