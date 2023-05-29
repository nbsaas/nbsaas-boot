export default [
    {
        name: "${formBean.className?uncap_first}_home",
        path: "/${formBean.className?uncap_first}/index",
        component: () => import("@/views/pages/${formBean.className?uncap_first}/index.vue"),
        meta: {
            title: "${model!}管理",
            icon: "el-icon-platform-eleme"
        }
    },
    {
        name: "${formBean.className?uncap_first}_add",
        path: "/${formBean.className?uncap_first}/add",
        component: () => import("@/views/pages/${formBean.className?uncap_first}/add.vue"),
        meta: {
            title: "添加${model!}",
            icon: "el-icon-platform-eleme"
        }
    },
    {
        name: "${formBean.className?uncap_first}_update",
        path: "/${formBean.className?uncap_first}/update",
        component: () => import("@/views/pages/${formBean.className?uncap_first}/update.vue"),
        meta: {
            title: "更新${model!}",
            icon: "el-icon-platform-eleme"
        }
    },
    {
        name: "${formBean.className?uncap_first}_view",
        path: "/${formBean.className?uncap_first}/view",
        component: () => import("@/views/pages/${formBean.className?uncap_first}/view.vue"),
        meta: {
            title: "${model!}详情",
            icon: "el-icon-platform-eleme"
        }
    }
]