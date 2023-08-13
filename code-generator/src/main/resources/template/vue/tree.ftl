<template>
    <div class="model-form">
        <section>
            <el-tabs v-model="activeName">
                <el-tab-pane label="${formBean.model!}树" name="third">
                    <el-button type="primary" size="small" @click="append()" style="margin-bottom:15px;">增加一级分类
                    </el-button>
                    <el-table :data="treeOptions.children" style="width: 100%;margin-bottom: 20px;" row-key="id" border  <#if formBean.lazy> lazy="true" :load="loadChildren" </#if>  >
                        <el-table-column prop="name" label="${model!}名称" sortable width="260" align="left">
                        </el-table-column>
                        <el-table-column prop="code" label="编码" width="120" sortable align="center">
                        </el-table-column>
                        <el-table-column prop="sortNum" label="排序号" width="120" sortable align="center">
                        </el-table-column>
                        <el-table-column prop="addDate" label="添加时间" width="160">
                        </el-table-column>
                        <el-table-column prop="demo" label="备注">
                        </el-table-column>
                        <el-table-column label="操作" width="240" align="center">
                            <template #default="scope">
                                <el-button type="primary" size="small" @click="append(scope.row)">增加
                                </el-button>
                                <el-button type="primary" size="small" @click="editView(scope.row)">编辑
                                </el-button>
                                <el-button type="danger" size="small" style="cursor: pointer;"
                                           @click="deleteData(scope.row)">删除
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
                <el-tab-pane label="${formBean.model!}图" name="second">
                    <vue2-org-tree class="tree-div" :data="treeOptions" :collapsable="collapsable"
                                   :expandAll="expandAll" :horizontal="horizontal" :label-class-name="labelClassName"
                                   :render-content="renderContent" @on-expand="onExpand" @on-node-click="onNodeClick"/>
                </el-tab-pane>
            </el-tabs>

            <el-dialog title="增加${formBean.model!}" v-model="showDialog" width="35%">
                <el-row :gutter="20">
                    <el-col :span="18" :offset="2">
                        <el-row class="input-line">
                            <el-col :span="8">
                                <span class="el-form-item__label title">上级${model!}：</span>
                            </el-col>
                            <el-col :span="16">
                                <el-input disabled="true" size="small" v-model="form.parentName"></el-input>
                            </el-col>
                        </el-row>
                        <el-row class="input-line">
                            <el-col :span="8">
                                <span class="el-form-item__label title">${model!}名称：</span>
                            </el-col>
                            <el-col :span="16">
                                <el-input size="small" v-model="form.name"></el-input>
                            </el-col>
                        </el-row>
                        <el-row class="input-line">
                            <el-col :span="8">
                                <span class="el-form-item__label title">编码：</span>
                            </el-col>
                            <el-col :span="16">
                                <el-input size="small" v-model="form.code"></el-input>
                            </el-col>
                        </el-row>
                        <el-row class="input-line">
                            <el-col :span="8">
                                <span class="el-form-item__label title">排序号：</span>
                            </el-col>
                            <el-col :span="16">
                                <el-input-number size="small" v-model="form.sortNum"></el-input-number>
                            </el-col>
                        </el-row>

                    </el-col>
                </el-row>

                <template #footer>
				<span class="dialog-footer">
					<el-button size="small" @click="showDialog = false">取 消</el-button>
					<el-button size="small" type="primary" @click="add" :loading="workLoad">确 定</el-button>
				</span>
                </template>
            </el-dialog>
            <el-dialog title="编辑${formBean.model!}" v-model="editDialog" width="35%">
                <el-row :gutter="20">
                    <el-col :span="18" :offset="2">
                        <el-row class="input-line">
                            <el-col :span="8">
                                <span class="el-form-item__label title">${model!}名称：</span>
                            </el-col>
                            <el-col :span="16">
                                <el-input size="small" v-model="form.name"></el-input>
                            </el-col>
                        </el-row>
                        <el-row class="input-line">
                            <el-col :span="8">
                                <span class="el-form-item__label title">编码：</span>
                            </el-col>
                            <el-col :span="16">
                                <el-input size="small" v-model="form.code"></el-input>
                            </el-col>
                        </el-row>
                        <el-row class="input-line">
                            <el-col :span="8">
                                <span class="el-form-item__label title">排序号：</span>
                            </el-col>
                            <el-col :span="16">
                                <el-input-number size="small" v-model="form.sortNum"></el-input-number>
                            </el-col>
                        </el-row>
                    </el-col>
                </el-row>

                <template #footer>
				<span class="dialog-footer">
					<el-button size="small" @click="editDialog = false">取 消</el-button>
					<el-button size="small" type="primary" @click="updateData" :loading="workLoad">确 定</el-button>
				</span>
                </template>
            </el-dialog>
            <el-dialog title="提示" v-model="dialogVisible" width="30%">
                <span>确认要删除该条数据吗?</span>

                <template #footer>
					<span class="dialog-footer">
						<el-button @click="dialogVisible = false">取 消</el-button>
						<el-button type="primary" @click="handleClose">确 定</el-button>
					</span>
                </template>
            </el-dialog>
            <!-- /.box -->
        </section>
    </div>
</template>

<script>
    import common from "@/mixins/common.js";
    import {Delete, Edit} from '@element-plus/icons-vue'

    function clone(Obj) {
        var buf;
        if (Obj instanceof Array) {
            buf = [];
            var i = Obj.length;
            while (i--) {
                buf[i] = clone(Obj[i]);
            }
            return buf;
        } else if (Obj instanceof Object) {
            buf = {};
            for (var k in Obj) {
                buf[k] = clone(Obj[k]);
            }
            return buf;
        } else {
            return Obj;
        }
    }

    function restObject(Obj) {
        var buf;
        if (Obj instanceof Array) {
            buf = [];
            var i = Obj.length;
            while (i--) {
                buf[i] = clone(Obj[i]);
            }
            return buf;
        } else if (Obj instanceof Object) {
            buf = {};
            for (var k in Obj) {
                buf[k] = restObject(Obj[k]);
            }
            return buf;
        } else {
            return "";
        }
    }

    export default {
        name: "${formBean.className?uncap_first}_index",
        mixins: [common],
        data() {
            return {
                Edit: Edit,
                deleteIcon: Delete,
                searchObject: {
                    no: 1,
                    size: 8,
                    <#if formBean.searchs??>
                    <#list formBean.searchs as item>
                    ${item.id}: ''<#sep>,
                    </#list>
                    </#if>
                },
                dialogVisible: false,
                editDialog: false,
                defaultProps: {
                    children: 'children',
                    label: 'name'
                },
                loading: false,
                tableData: {},
                treeOptions: {
                    id: -1,
                    name: '${model!}结构',
                    children: []
                },
                props: {
                    label: 'name',
                    children: 'children',
                    expand: 'expand'
                },
                horizontal: true,
                collapsable: false,
                expandAll: false,
                labelClassName: 'bg-white',
                contextMenuVisible: false,
                contextMenuTarget: document.body,
                showDialog: false,
                form: {
                    name: "",
                    parent: "",
                    sortNum: "",
                },
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
                },
                activeName: "third",
                <#list formBean.fields as item>
                <#if item.option?length gt 2 >
                ${item.id}Options: [],
                </#if>
                </#list>
                workLoad: false
            }
        },
        mounted() {

            let search = this.$tool.data.get("${formBean.className?uncap_first}_search");
            if (search) {
                this.searchObject = search;
            }
            this.getSearchList();

            <#list formBean.fields as item>
            <#if item.option?length gt 2 >
            this.load${item.id?cap_first}Options();
            </#if>
            </#list>
        },
        methods: {
            async getSearchList() {
                this.loading = true;
                let data = this.searchObject;

                <#if formBean.lazy>
                data.fetch = 0;
                <#else>
                data.fetch = 1;
                </#if>

                data.size = 500;
                data.sortMethod = "asc";
                data.sortField = "sortNum";
                data.depth = 1;
                let res = await this.$http.form("/${formBean.className?uncap_first}/list", data);
                if (res.code === 200) {
                    this.treeOptions.children = res.data;
                }
                this.loading = false;
                this.$tool.data.set("${formBean.className?uncap_first}_search", this.searchObject);

            },
            <#if formBean.lazy>
            async loadChildren(event,treeNode, resolve) {
                this.loading = true;
                let data = {};
                data.fetch = 0;
                data.size = 500;
                data.sortMethod = "asc";
                data.sortField = "sortNum";
                data.parent=event.id;
                let res = await this.$http.form("/${formBean.className?uncap_first}/list", data);
                if (res.code === 200) {
                    resolve(res.data);
                }
                this.loading = false;
            },
            </#if>
            addView() {
                this.$router.push({
                    path: 'add'
                });
            },
            async add() {
                // let valid = await this.$refs["ruleForm"].validate();
                // if (!valid) {
                // 	return false;
                // }
                this.workLoad = true;
                await this.addData();
                this.workLoad = false;
            },
            async addData() {
                let data = this.form;
                let res = await this.$http.form("/${formBean.className?uncap_first}/create", data);
                if (res.code !== 200) {
                    this.$message.error(res.msg);
                    return;
                }

                this.$message({
                    message: '添加数据成功',
                    type: 'success'
                });
                await this.getSearchList();
                this.showDialog = false;
            },
            async updateData() {
                // let res = await this.$refs["ruleForm"].validate();
                // if (!res) {
                // 	return;
                // }
                this.workLoad = true;
                await this.updateDataPost();
                this.workLoad = false;
            },
            async updateDataPost() {
                let res = await this.$http.form("/${formBean.className?uncap_first}/update", this.form);
                if (res.code !== 200) {
                    this.$message.error(res.msg);
                    return
                }
                this.$message({
                    message: '更新数据成功',
                    type: 'success'
                });
                await this.getSearchList();
                this.editDialog = false;
            },
            append(data) {
                this.showDialog = true;
                this.form = restObject(this.form);
                if (data) {
                    this.form.parent = data.id;
                    this.form.parentName = data.name;
                    this.selectData = data;
                }
            },
            showView(row) {
                let data = {};
                data.id = row.id;
                this.$router.push({
                    path: 'view',
                    query: data
                });
            },
            editView(row) {
                this.form = clone(row);
                this.form.children = "";
                this.editDialog = true;
            },
            deleteData(row) {
                this.selectId = row.id;
                this.dialogVisible = true;
            },
            <#list formBean.fields as item>
            <#if item.option?length gt 2 >
            async load${item.id?cap_first}Options() {
                let self = this;
                var param = {};
                param.sortMethod = "asc";
                param.sortField = "id";
                param.level = 1;
                param.size = 500;
                param.fetch = 0;

                let res = await this.$http.form("/${item.id?lower_case}/list", param);
                if (res.code === 200) {
                    self.${item.id}Options = res.data;
                }
            },
            </#if>
            </#list>
            clearSearch() {
                this.searchObject.key = "";
                this.searchObject.name = "";
                <#if searchs??>
                <#list searchs as item>
                this.searchObject.${item.id} = "";
                </#list>
                </#if>
            },
            async handleClose() {

                this.dialogVisible = false;
                if (this.selectId) {
                    let params = {};
                    params.id = this.selectId;
                    let res = await this.$http.form("/${formBean.className?uncap_first}/delete", params);
                    if (res.code === 200) {
                        this.$message({
                            message: '删除数据成功',
                            type: 'success'
                        });
                        await this.getSearchList();
                    } else {
                        this.$message.error(res.msg);
                    }
                }

            }

        },
    }
</script>
<style scoped>
    .bg-white {
        cursor: pointer;
    }

    .bg-white-curren {
        background-color: #409EFF;
        color: #fff;
    }

    .right-menu {
        border: 1px solid #eee;
        box-shadow: 0 .5em 1em 0 rgba(0, 0, 0, .1);
        border-radius: 1px;
    }

    .right-menu {
        position: fixed;
        background: #fff;
        border: 1px solid rgba(0, 0, 0, .2);
        border-radius: 3px;
        z-index: 999;
        display: none;
    }

    .right-menu a {
        padding: 2px;
    }

    .right-menu a {
        width: 75px;
        height: 28px;
        line-height: 28px;
        text-align: center;
        display: block;
        color: #1a1a1a;
    }

    .custom-tree-node {
        flex: 1;
        display: flex;
        align-items: center;
        justify-content: space-between;
        font-size: 14px;
        padding-right: 8px;
    }

    .tree-div {
        width: 100%;
    }

    .el-tabs {
        background-color: #fff;
        padding: 15px;
    }

    .input-line {
        margin: 5px 0px;
    }

    .input-line .title {
        line-height: 32px;
        float: right;
        font-size: 12px;
    }
</style>