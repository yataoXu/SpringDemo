package com.evan.annotation;

import com.evan.condition.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(MyImportSelector.class)
public @interface EnableMyImportSelector {
    String name ();

}
