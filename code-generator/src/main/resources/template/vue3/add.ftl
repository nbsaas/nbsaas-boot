<#include "componentFieldItem.ftl" />


<template>
    <div class="model-form">
        <el-page-header @back="goBack" content="增加${formBean.model!}">
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
                            <el-button type="primary" @click="createData">确定</el-button>
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
    import ${item.name} from "${item.model!}";
    </#list>
    </#if>
    import {ref} from "vue";
    import {useData} from "@/utils/useData";
    import {useRouter, useRoute} from "vue-router";
    import {useCreate} from "@/uses/useCreate";

    const router = useRouter();
    const route = useRoute()
    const form = ref({
       <#list formBean.fields as item>
         ${item.id!}: null <#sep>,
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

    const {createData,goBack} =useCreate("${formBean.className?uncap_first}",form,ruleForm)

</script>

<style scoped>
</style>