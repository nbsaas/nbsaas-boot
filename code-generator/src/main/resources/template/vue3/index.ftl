<template>
    <div>
        <el-dialog title="提示" v-model="dialogVisible" width="30%">
            <span>确认要删除该条数据吗?</span>
            <template #footer>
                <span class="dialog-footer">
                  <el-button @click="dialogVisible = false">取 消</el-button>
                  <el-button type="primary" @click="handleDelete">确 定</el-button>
                </span>
            </template>
        </el-dialog>
        <div class="search">
            <el-form label-width="${formBean.searchWidth!80}px">
                <el-row>
                    <#if formBean.searches??>
                        <#list formBean.searches as item>
                            <#if item.show>
                                <el-col :span="6" style="padding: 0 8px;">
                                    <el-form-item label="${item.title}">
                                        <#if item.type='date'>
                                            <el-date-picker value-format="yyyy-MM-dd"    v-model="searchObject.${item.id!}" type="date"   placeholder="选择日期">
                                            </el-date-picker>
                                        <#elseif item.type='select'>
                                            <el-select style="width: 100%;" v-model="searchObject.${item.id!}" filterable clearable   placeholder="请选择">
                                                <el-option v-for="item in ${item.id!}Options" :key="item.id"   :label="item.name" :value="item.id">
                                                </el-option>
                                            </el-select>
                                        <#elseif item.type='dictionary'>
                                            <nb-select catalog="${item.id!}" v-model="searchObject.${item.id!}"></nb-select>
                                        <#elseif item.type='textarea'>
                                            <el-input v-model="searchObject.${item.id!}"   name="${item.id!}"  type="textarea"></el-input>
                                        <#else>
                                            <el-input v-model="searchObject.${item.id!}"  placeholder="${item.placeholder}" name="${item.id!}">
                                            </el-input>
                                        </#if>
                                    </el-form-item>
                                </el-col>
                            </#if>
                        </#list>
                    </#if>

                    <el-col :span="${formBean.leftSize!'6'}" style="padding: 0 10px;">
                        <el-row type="flex" justify="end">
                            <el-button  type="primary" @click="search">搜索</el-button>
                            <el-button   plain @click="clearSearch">清除条件</el-button>
                        </el-row>
                    </el-col>
                </el-row>
            </el-form>
        </div>
        <div class="data-content">
            <div class="tool-add">
                <el-button type="primary"   @click="addView">新增</el-button>
            </div>

            <el-table v-loading="loading" :data="pageData.data" @sort-change="changeTableSort"
                      style="width: 100%;font-size: 12px;">
                <#if formBean.grids??>
                    <#list formBean.grids as item>
                        <el-table-column label="${item.title}" prop="${item.id!}${item.extName!}"
                                         <#if item.sort>sortable="custom" </#if>  <#if item.width?length lt 4 > width="${item.width!}"  </#if> >
                        </el-table-column>
                    </#list>
                </#if>
                <#if formBean.showHandle>
                <el-table-column width="${formBean.handleWidth!'210'}" align="center" fixed="right" label="操作">
                    <template #default="scope">
                        <el-button text   class="operation_bt" :icon="InfoFilled" type="info"   @click="showView(scope.row)">详情
                        </el-button>

                        <el-button text   class="operation_bt" :icon="Edit" type="primary"   @click="editView(scope.row)">编辑
                        </el-button>

                        <el-button text :icon="Delete" class="operation_bt" type="danger"    style="cursor: pointer;"     @click="deleteData(scope.row)">删除
                        </el-button>
                    </template>
                </el-table-column>
                </#if>
            </el-table>

            <div class="page">
                <el-pagination background :current-page="searchObject.no" :page-sizes="[10, 20, 50, 100]"
                               :page-size="pageData.size" :pager-count="5"
                               layout="total, sizes, prev, pager, next, jumper" :page-count="pageData.totalPage"
                               :total="pageData.total" @size-change="sizeChange" @current-change="pageChange">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script setup>
    import {Delete, Edit,InfoFilled} from '@element-plus/icons-vue'
    import {defineStore} from 'pinia'
    import {usePage} from "@/utils/usePage";
    import {useDelete} from "@/utils/useDelete";
    import {useView} from "@/utils/useView";
    import {useData} from "@/utils/useData";
    <#if formBean.searchComponentSet??>
    <#list formBean.searchComponentSet as item>
    import ${item.name} from "${item.model!}";
    </#list>
    </#if>

    const searchStore = defineStore('${formBean.className?uncap_first}Store', {

        state: () => {
            return { searchObject: {
                    no: 1,
                    size: 10,
                    sortField: "${formBean.sortField!}",
                    sortMethod: "desc",
                    <#if formBean.searches??>
                    <#list formBean.searches as item>
                    ${item.id}: null<#sep>,
                    </#list>
                    </#if>
                }
            }
        }
    })

const  {searchObject}=searchStore();

const clearSearch =()=>{
    <#if formBean.searches??>
    <#list formBean.searches as item>
    searchObject.${item.id} = null;
    </#list>
    </#if>
}
const {pageData, sizeChange, pageChange, search, changeTableSort,loading}=usePage("/${formBean.className?uncap_first}/search", searchObject);
const {dialogVisible, deleteData,handleDelete}=useDelete("/${formBean.className?uncap_first}/delete",search);
const {showView,addView,editView}=useView();

<#list formBean.fields as item>
<#if item.option?length gt 2 >
const{listData:${item.id}Options}= useData("/${item.option?uncap_first}/list")
</#if>
</#list>
</script>

<style scoped>
    <#if formBean.searches?size gt 4>
    .el-col{
        margin-bottom: 10px;
    }
    <#else>
    </#if>
</style>