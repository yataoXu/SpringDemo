package com.evan.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;


public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        System.out.println("======MyImportSelector method start=======");
        annotationTypes.stream().forEach(System.out::println);
        System.out.println("======MyImportSelector method end=======");
        return new String[]{"com.evan.bean.Black","com.evan.bean.Red"};
    }
}
