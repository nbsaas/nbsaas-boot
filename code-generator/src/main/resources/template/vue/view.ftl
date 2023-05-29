<template>
    <div class="model-form">
        <el-page-header @back="goBack" content="${model!}详情">
        </el-page-header>
        <el-form class="viewForm" label-width="80px">
            <#if formBean.fields??>
                <#list formBean.fields as item>
                    <el-col :span="${item.col!12}">
                        <el-form-item label="${item.title}">
                            <div v-html="viewModel.${item.id!}${item.extName!}"></div>
                        </el-form-item>
                    </el-col>
                </#list>
            </#if>
        </el-form>
    </div>
</template>

<script>
    import common from "@/mixins/common.js";

    export default {
        name: "${formBean.className?uncap_first}_view",
        mixins: [common],
        data() {
            return {
                viewModel: {},
                activeIndex: "1"
            }
        },
        async mounted() {
            let id = this.$route.query.id;
            let data = {};
            data.id = id;
            let res = await this.$http.form("/${formBean.className?uncap_first}/view", data);
            if (res.code === 200) {
                this.viewModel = res.data;
            }
        }
    }
</script>

<style scoped>

</style>