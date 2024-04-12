<template>
    <div class="model-form">
        <el-page-header @back="goBack" content="详情">
        </el-page-header>

        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="1">
                ${model!}详情
            </el-menu-item>
        </el-menu>
        <div style="margin-top:15px;">
            <router-view></router-view>
        </div>

    </div>
</template>

<script>
    import {useLayoutView} from "@/uses/useLayoutView";
    import {useRouter} from "vue-router";
    const {selectIndex,activeIndex,goBack}=useLayoutView();
    const router = useRouter();


    const handleSelect=(index)=> {
        let selectId = selectIndex.value;
        if (index === "1") {
            router.replace({
                path: '/${formBean.className?uncap_first}/view',
                query: {
                    id: selectId,
                    activeIndex: 1,
                    time: Math.random()
                }
            })
        } else if (index === "2") {
            router.replace({
                path: '/${formBean.className?uncap_first}/qrcode',
                query: {
                    id: selectId,
                    activeIndex: 2,
                    time: Math.random()
                }
            })
        } else {
            console.log(index)
        }
    }
</script>

<style scoped>

</style>