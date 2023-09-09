<#macro componentInput item>
    <#if item.type='date'>
        <el-date-picker v-model="form.${item.id!}" type="date" value-format="YYYY-MM-DD" placeholder="选择日期">
        </el-date-picker>
    <#elseif item.type='el_date_picker'>
        <el-date-picker v-model="form.${item.id!}" type="date" value-format="YYYY-MM-DD" placeholder="选择日期">
        </el-date-picker>
    <#elseif item.type='el_date_time_picker'>
        <el-date-picker v-model="form.${item.id!}" type="datetime" value-format="YYYY-MM-DD HH:mm"
                        placeholder="选择日期">
        </el-date-picker>
    <#elseif item.type='el_time_select'>
        <el-time-select
                placeholder="选择时间"
                v-model="form.${item.id!}"
                :picker-options="{
                     start: '08:30',
                     step: '00:15',
                     end: '18:30'
                     }">
        </el-time-select>
    <#elseif item.type='select'>
        <el-select style="width: 100%;" v-model="form.${item.id!}" filterable clearable
                   placeholder="请选择">
            <el-option v-for="item in ${item.option!}Options" :key="item.id"
                       :label="item.name" :value="item.id">
            </el-option>
        </el-select>
    <#elseif item.type='tree'>
        <el-tree-select ref="treeSelect" v-model="form.${item.id!}" :data="${item.option!}Options" node-key="id" check-strictly=true :render-after-expand="false" />
    <#elseif item.type='selectRemote'>
        <el-select style="width: 100%;" v-model="form.${item.id!}" filterable clearable
                   remote :remote-method="remote${item.id?cap_first}"
                   placeholder="请选择">
            <el-option v-for="item in ${item.option!}Options" :key="item.id"  :label="item.name" :value="item.id">
            </el-option>
        </el-select>
    <#elseif item.type='textarea'>
        <el-input v-model="form.${item.id!}" name="${item.id!}" type="textarea"></el-input>
    <#elseif item.type='el_input_number'>
        <el-input-number v-model="form.${item.id!}" name="${item.id!}" :min="0" :max="9999999" style="width: 100%;"></el-input-number>
    <#elseif item.type='el_cascader'>
        <el-cascader
                v-model="form.${item.id!}"
                :options="options"
                @change="handleChange"></el-cascader>
    <#elseif item.type='el_switch'>
        <el-switch
                v-model="form.${item.id!}"
                active-color="#13ce66"
                inactive-color="#ff4949">
        </el-switch>
    <#elseif item.type='el_slider'>
        <el-slider v-model="form.${item.id!}"></el-slider>
    <#elseif item.type='el_rate'>
        <el-rate v-model="form.${item.id!}"></el-rate>
    <#elseif item.type='el_radio_group'>
        <el-radio v-model="form.${item.id!}" label="1">备选项</el-radio>
        <el-radio v-model="form.${item.id!}" label="2">备选项</el-radio>
    <#elseif item.type='el_checkbox_group'>
        <el-checkbox-group v-model="form.${item.id!}">
            <el-checkbox label="复选框 A"></el-checkbox>
            <el-checkbox label="复选框 B"></el-checkbox>
            <el-checkbox label="复选框 C"></el-checkbox>
        </el-checkbox-group>
    <#elseif item.type='el_upload'>
        <avatar v-model="form.${item.id!}"></avatar>
    <#elseif item.type='image'>
        <avatar v-model="form.${item.id!}"></avatar>
    <#elseif item.type='dictionary'>
        <nb-select catalog="${item.id!}" v-model="form.${item.id!}"></nb-select>
    <#elseif item.type='money'>
        <el-input-number v-model="form.${item.id!}" name="${item.id!}" type="textarea" :min="0" :max="99999999.99"  style="width: 100%;" ></el-input-number>
    <#else>
        <el-input v-model="form.${item.id!}" name="${item.id!}">
        </el-input>
    </#if>
</#macro>