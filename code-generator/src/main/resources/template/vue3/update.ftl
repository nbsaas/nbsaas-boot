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
import ${item.name} from "${item.model!}";
</#list>
</#if>
import {onMounted, ref} from "vue";
import {useData} from "@/utils/useData";
import http from "@/utils/request";
import {useRouter, useRoute} from "vue-router";
import {ElMessage} from "element-plus";
import {useView} from "@/utils/useView";

const router = useRouter();
const route = useRoute()
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

onMounted(async () => {
  let id = route.query.id;
  let data = {};
  data.id = id;
  let res = await http.post("/${formBean.className?uncap_first}/view", data);
  if (res.code === 200) {
    form.value = res.data;
  }
})
const updateData = async () => {
  try {
    let valid = await ruleForm.value.validate();
    if (!valid) {
      return;
    }
  } catch (e) {
    return;
  }

  let res = await http.post("/${formBean.className?uncap_first}/update", form.value);
  if (res.code !== 200) {
    ElMessage.error(res.msg)
    return
  }

  ElMessage({
    message: '更新数据成功',
    type: 'success',
  })
  router.go(-1);

}
const { goBack} = useView()

</script>

<style scoped>

</style>