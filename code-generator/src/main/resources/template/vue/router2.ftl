export default [
{
name: "${config_entity}_home",
path: "/${config_entity}/index",
component: () => import("@/views/pages/${config_entity}/index.vue"),
meta: {
title: "${model!}管理",
icon: "el-icon-platform-eleme"
}
},
{
name: "${config_entity}_add",
path: "/${config_entity}/add",
component: () => import("@/views/pages/${config_entity}/add.vue"),
meta: {
title: "添加${model!}",
icon: "el-icon-platform-eleme"
}
},
{
name: "${config_entity}_update",
path: "/${config_entity}/update",
component: () => import("@/views/pages/${config_entity}/update.vue"),
meta: {
title: "更新${model!}",
icon: "el-icon-platform-eleme"
}
},
{
name: "${config_entity}_layout",
path: "/${config_entity}/view_layout",
component: () => import("@/views/pages/${config_entity}/view_layout.vue"),
meta: {
title: "${model!}详情",
icon: "el-icon-platform-eleme"
},
children:[
{
name: "${config_entity}_view",
path: "/${config_entity}/view",
component: () => import("@/views/pages/${config_entity}/view.vue"),
meta: {
title: "${model!}详情",
icon: "el-icon-platform-eleme"
}
}
]

}
]