export default [
    {
        name: "${formBean.className?uncap_first}_home",
        path: "/${formBean.className?uncap_first}/index",
        component: () => import("@/views/pages/${formBean.className?uncap_first}/index.vue"),
        meta: {
            title: "${model!}管理",
            icon: "el-icon-platform-eleme"
        }
    }
]