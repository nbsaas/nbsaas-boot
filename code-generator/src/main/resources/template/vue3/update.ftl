<#include "componentFieldItem.ftl"/>
<template>
    <div class="model-form">
        <el-page-header @back="goBack" content="更新${formBean.model!}">
        </el-page-header>
        <div class="model-content">
            <el-form ref="ruleForm" :rules="rules" :model="form" label-width="160px">
                <el-row :gutter="10">
                    <#list formBean.fields as item>
                        <@fieldItem item />
                    </#list>

                    <el-col :span="22">
                        <el-form-item>
                            <el-button @click="goBack">取消</el-button>
                            <el-button type="primary" @click="updateData">确定</el-button>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </div>
    </div>
</template>

<script setup>
<#if formBean.componentSet??>
<#list formBean.componentSet as item>
    <#if item.name =="sc-editor">
    import {defineAsyncComponent} from "vue";
    const scEditor = defineAsyncComponent(() => import('@/components/scEditor/index.vue'));
    <#else>
    import ${item.name} from "${item.model!}";
    </#if>
</#list>
</#if>
import {ref} from "vue";
import {useData} from "@/utils/useData";
import {useUpdate} from "@/uses/useUpdate";

const form = ref({
   <#list formBean.fields as item>
     ${item.id!}: ''<#sep>,
    </#list>
})

const rules = ref({
 <#list formBean.fields as item>
   <#if item.required>
   ${item.id}: [
       {required: true, message: '请输入${item.title!}', trigger: 'blur'}
       <#if item.type='money'>
       , {type: 'number', message: '${item.title!}必须为数字值'}
       </#if>
   ]<#sep>,
   </#if>
   </#list>
})

const ruleForm = ref(null);
<#list formBean.fields as item>
<#if item.option?length gt 2 >
const{listData:${item.id}Options}= useData("/${item.option?uncap_first}/list")
</#if>
</#list>

const {updateData,goBack}=useUpdate("${formBean.className?uncap_first}",form,ruleForm)

</script>

<style scoped>

</style>