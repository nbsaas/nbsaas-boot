/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

package com.nbsaas.boot.generator.rest.handle.field;

import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.InputType;
import com.nbsaas.boot.code.annotation.data.Dict;
import com.nbsaas.boot.code.annotation.data.DictKey;
import com.nbsaas.boot.generator.beans.ComponentSimple;
import com.nbsaas.boot.generator.beans.FieldBean;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.rest.handle.base.BaseFieldHandle;
import com.nbsaas.boot.generator.rest.handle.untils.FieldUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class GridFieldHandle extends BaseFieldHandle {
    @Override
    public void handle(Class<?> object,Field f, FormBean formBean) {
        f.setAccessible(true);


        FormField formField = f.getAnnotation(FormField.class);
        FieldBean bean = new FieldBean();

        Dict dict = f.getAnnotation(Dict.class);
        if (dict != null) {
            formBean.setDict(true);
            bean.setType("dictionary");
            bean.setExtName("Name");
            formBean.getComponentSet().add(ComponentSimple.builder()
                    .name("nbSelect").model("@/components/nbSelect.vue")
                    .build());

            formBean.getSearchComponentSet().add(ComponentSimple.builder()
                    .name("nbSelect").model("@/components/nbSelect.vue")
                    .build());
            DictKey dictKey = f.getAnnotation(DictKey.class);
            if (dictKey != null) {
                bean.setDictKey(dictKey.value());
            } else {
                bean.setDictKey(f.getName());
            }
        }

        if (formField == null) {
            return;
        }

        if (f.getType().isEnum()) {
            bean.setFieldType(4);
            bean.setExtName("Name");
        } else {
            bean.setFieldType(1);
            bean.setExtName("");
        }
        FieldName fieldName = f.getAnnotation(FieldName.class);
        if (fieldName != null) {
            bean.setFieldType(3);
            bean.setExtName("Name");
        }
        bean.setWidth(formField.width());
        bean.setClassName(formField.className());
        bean.setId(formField.id());
        if (bean.getId() == null) {
            bean.setId(f.getName());
        }
        bean.setType(formField.type().name());




        bean.setPlaceholder(formField.placeholder());
        Integer sortNum = FieldUtils.getInteger(formField);
        bean.setSortNum(sortNum);
        bean.setTitle(formField.title());
        bean.setCol(formField.col());
        bean.setRequired(formField.required());
        bean.setOption(formField.option());
        bean.setSort(formField.sort());
        if (formField.grid()) {
            formBean.getGrids().add(bean);
        }
        if (StringUtils.isEmpty(bean.getTitle())) {
            bean.setTitle(f.getName());
        }
        if (StringUtils.isEmpty(bean.getId())) {
            bean.setId(f.getName());
        }
        if (StringUtils.isEmpty(bean.getPlaceholder())) {
            bean.setPlaceholder(bean.getTitle());
        }
        if ("date".equals(bean.getType())) {
            formBean.setHasDate(true);
            formBean.getDates().add(bean);
        }
        if ("image".equals(bean.getType())) {
            formBean.setHasImage(true);
            formBean.getImages().add(bean);
        }
        if (formField.ignore()) {
            return;
        }
        if (!formBean.getGrids().contains(bean)) {
            formBean.getGrids().add(bean);
        }


        //
        if (formField.type() == InputType.image) {

            formBean.getComponentSet().add(ComponentSimple.builder()
                    .name("avatar").model("@/components/avatar.vue")
                    .build());
        }
        if (formField.type() == InputType.el_upload) {
            formBean.getComponentSet().add(ComponentSimple.builder()
                    .name("avatar").model("@/components/avatar.vue")
                    .build());
        }
        if (formField.type() == InputType.dictionary) {
            DictKey dictKey = f.getAnnotation(DictKey.class);
            if (dictKey != null) {
                bean.setDictKey(dictKey.value());
            } else {
                bean.setDictKey(f.getName());
            }
            formBean.getComponentSet().add(ComponentSimple.builder()
                    .name("nbSelect").model("@/components/nbSelect.vue")
                    .build());

            formBean.getSearchComponentSet().add(ComponentSimple.builder()
                    .name("nbSelect").model("@/components/nbSelect.vue")
                    .build());
        }
        if (formField.type() == InputType.richText) {
            formBean.getComponentSet().add(ComponentSimple.builder()
                    .name("VueUeditorWrap").model("vue-ueditor-wrap")
                    .build());
        }

        formBean.getFields().add(bean);

    }

    @Override
    public int getOrder() {
        return 100;
    }
}
