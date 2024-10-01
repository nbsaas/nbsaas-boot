<#include "componentFieldItem.ftl" />


<template>
    <el-dialog v-model="dialogVisible" :title="title" width="500px" @close="cancel">
       <el-form ref="ruleForm" :rules="rules" :model="form" label-width="160px">
           <el-row :gutter="10">
               <#list formBean.fields as item>
                   <@fieldItem item />
               </#list>

               <el-col :span="22">
                   <el-form-item>
                       <el-button @click="cancel">取消</el-button>
                       <el-button type="primary" @click="operateData">确定</el-button>
                   </el-form-item>
               </el-col>
           </el-row>
       </el-form>
    </el-dialog>
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
    import {onMounted, ref} from "vue";
    import {useForm} from "@/uses/useForm";
    import http from "@/utils/request";

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

    const disabledState = ref(false);
    const dialogVisible = ref(true);
    const title = ref(null);
    const props = defineProps(['dataId', "model"])
    const emit = defineEmits(['cancel', 'submit'])
    const {operateData} = useForm("${formBean.className?uncap_first}", form, ruleForm,props.model,()=>{
        emit("success")
    })


    onMounted(async () => {
        if (props.model !== 'create') {
            let param={};
            param.id=props.dataId;
            let res = await http.post(`/${formBean.className?uncap_first}/view`, param);
            if (res.code===200){
                form.value=res.data;
            }

        }
        if (props.model === 'view') {
            disabledState.value=true;
            title.value="查询${formBean.model!}"
        }
        else if (props.model === 'create') {
            title.value="新增${formBean.model!}"
        }  if (props.model === 'update') {
            title.value="更新${formBean.model!}"
        }


    })

    const cancel=()=>{
        emit("cancel")
    }
</script>

<style scoped>
</style>