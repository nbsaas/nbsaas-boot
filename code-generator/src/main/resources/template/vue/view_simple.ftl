<template>
    <div>
        <el-form class="viewForm" label-width="${formBean.viewWidth!120}px">
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

<script setup>
    import {useShow} from "@/utils/useShow";
    const { goBack,viewModel} = useShow("/${formBean.className?uncap_first}/view")
</script>

<style scoped>

</style>