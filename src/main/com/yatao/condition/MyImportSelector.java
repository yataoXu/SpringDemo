package com.yatao.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Iterator;
import java.util.Set;


// 自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    /**
     *
     * 返回值，就是要导入到容器中的组件的全类名
     *
     * @param annotationMetadata 当前标注 @import 注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        System.out.println("=============");
        for (String annotation : annotationTypes){
            System.out.println(annotation);
        }
        System.out.println("=============");

        Iterator<String> iterator = annotationTypes.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println("=============");
        return new String[]{"com.yatao.bean.Blue","com.yatao.bean.Yellow"};
    }
}
