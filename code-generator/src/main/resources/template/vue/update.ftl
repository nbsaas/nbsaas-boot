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

<script>
    import common from "@/mixins/common.js";

    <#if formBean.componentSet??>
    <#list formBean.componentSet as item>
    import ${item.name} from "${item.model!}";
    </#list>
    </#if>

    export default {
        name: "${formBean.className?uncap_first}_update",
        mixins: [common],
        components: {
            <#list formBean.componentSet as item>${item.name}<#sep>, </#list>
        },
        data() {
            return {
                form: {
                    <#list formBean.fields as item>
                    ${item.id!}: ''<#sep>,
                    </#list>
                },
                <#list formBean.fields as item>
                <#if item.option?length gt 2 >
                ${item.id}Options: [],
                </#if>
                </#list>
                rules: {
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
                }
            }
        },
        async mounted() {
            let id = this.$route.query.id;
            let data = {};
            data.id = id;
            let res = await this.$http.post("/${formBean.className?uncap_first}/view", data);
            if (res.code === 200) {
                this.form = res.data;
            }
            <#list formBean.fields as item>
            <#if item.option?length gt 2 >
            this.load${item.id?cap_first}Options();
            </#if>
            </#list>
        },
        methods: {
            async updateData() {
                try {
                    let valid = await this.$refs["ruleForm"].validate();
                    if (!valid) {
                        return;
                    }
                } catch (e) {
                    return;
                }
                await this.updateDataPost();
            },
            async updateDataPost() {
                let res = await this.$http.post("/${formBean.className?uncap_first}/update", this.form);
                if (res.code !== 200) {
                    this.$message.error(res.msg);
                    return
                }
                this.$message({
                    message: '更新数据成功',
                    type: 'success'
                });
                this.$router.go(-1);
            },
            <#list formBean.fields as item>
            <#if item.option?length gt 2 >
            async load${item.id?cap_first}Options() {
                let self = this;
                let param = {};
                param.sortMethod = "asc";
                param.sortField = "id";
                param.level = 1;
                param.size = 500;
                param.fetch = 0;
                let res = await this.$http.post("/${item.option?uncap_first}/list", param);
                if (res.code === 200) {
                    self.${item.id}Options = res.data;
                }
            },
            </#if>
            </#list>

            <#list formBean.fields as item>
            <#if item.type='selectRemote'>
            async remote${item.id?cap_first}(query) {
                if (query !== '') {
                }
                let self = this;
                let param = {};
                param.sortMethod = "asc";
                param.sortField = "id";
                param.level = 1;
                param.size = 500;
                param.fetch = 0;
                param.name = query;

                let res = await this.$http.post("/${item.id?uncap_first}/list", param);
                if (res.code === 0) {
                    self.${item.id}Options = res.data;
                }
            }
            </#if>
            </#list>
        }
    }


</script>

<style scoped>

</style>