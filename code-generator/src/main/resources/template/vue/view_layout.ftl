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
    import common from "@/mixins/common.js";

    export default {
        name: "${config_entity}_layout_index",
        mixins: [common],
        data() {
            return {
                activeIndex: "1"
            }
        },
        methods: {
            handleSelect() {
                let selectId = this.selectId;
                if (index === "1") {
                    this.$router.replace({
                        path: '/${config_entity}/view',
                        query: {
                            id: selectId,
                            activeIndex: 1,
                            time: Math.random()
                        }
                    })
                } else if (index === "2") {
                    this.$router.replace({
                        path: '/${config_entity}/qrcode',
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
        },
        mounted() {
            let activeIndex = this.$route.query.activeIndex;
            this.selectId = this.$route.query.id;
            if (activeIndex) {
                this.activeIndex = activeIndex;
            }
        },
    }
</script>

<style scoped>

</style>