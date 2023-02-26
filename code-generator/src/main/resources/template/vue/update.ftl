<#include "componentFieldItem.ftl"/>
<template>
    <div class="model-form">
        <el-page-header @back="goBack" content="更新${model!}">
        </el-page-header>
        <div class="model-content">
            <el-form ref="ruleForm" :rules="rules" :model="form" label-width="160px">
                <el-row :gutter="10">
                    <#list bean.fields as item>
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
    <#if componentState>
    <#list componentSet as item>
    import common from "@/mixins/common.js";

    </#list>
    </#if>

    export default {
        name: "${config_entity}_update",
        mixins: [common],
        components: {
            <#list componentSet as item>${item.name}<#sep>, </#list>
        },
        data() {
            return {
                form: {
                    <#list bean.fields as item>
                    ${item.id!}: ''<#sep>,
                    </#list>
                },
                <#list bean.fields as item>
                <#if item.option?length gt 2 >
                ${item.id}Options: [],
                </#if>
                </#list>
                rules: {
                    <#list bean.fields as item>
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
            let res = await this.$http.form("/tenantRest/${config_entity}/view.htm", data);
            if (res.code === 0) {
                this.form = res;
            }
            <#list bean.fields as item>
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
                let res = await this.$http.form("/tenantRest/${config_entity}/update.htm", this.form);
                if (res.code !== 0) {
                    this.$message.error(res.msg);
                    return
                }
                this.$message({
                    message: '更新数据成功',
                    type: 'success'
                });
                this.$router.go(-1);
            },
            <#list bean.fields as item>
            <#if item.option?length gt 2 >
            async load${item.id?cap_first}Options() {
                let self = this;
                let param = {};
                param.sortMethod = "asc";
                param.sortField = "id";
                param.level = 1;
                param.size = 500;
                param.fetch = 0;
                let res = await this.$http.form("/tenantRest/${item.id?lower_case}/list.htm", param);
                if (res.code === 0) {
                    self.${item.id}Options = res.list;
                }
            },
            </#if>
            </#list>

            <#list bean.fields as item>
            <#if item.type='selectRemote'>
            remote${item.id?cap_first}(query) {
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
                this.postData("/tenantRest/${item.id}/list.htm", param, function (result) {
                    if (result.code === 0) {
                        self.${item.id}Options = result.list;
                    }
                });
            }
            </#if>
            </#list>
        }
    }


</script>

<style scoped>

</style>