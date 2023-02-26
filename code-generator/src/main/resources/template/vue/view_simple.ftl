<template>
    <div>
        <el-form class="viewForm" label-width="80px">
            <#if bean.fields??>
                <#list bean.fields as item>
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

    var config = {};
    config.methods = {};
    config.mixins = [common];

    config.data = function () {
        return {
            viewModel: {},
            activeIndex: "1"
        }
    };
    config.mounted = function () {
        var id = this.$route.query.id;
        var self = this;
        var data = {};
        data.id = id;
        this.postData("/tenantRest/${config_entity}/view.htm", data, function (res) {
            if (res.code == 0) {
                self.viewModel = res;
            }
        });
    }

    export default config;
</script>

<style scoped>

</style>