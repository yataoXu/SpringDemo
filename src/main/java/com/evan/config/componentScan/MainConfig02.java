package com.evan.config.componentScan;


import com.evan.filter.MyTypeFilter;
import com.evan.service.BookService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
// excludeFilters =  Filter[] 排除那些组件
//@ComponentScan(value = "com.evan",excludeFilters ={
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})})


// 配置只包含的过滤规则的时候需要屏蔽掉默认的过滤规则
// includeFilters =  Filter[] 只包含 Filter 中的 组件，注意点就是要屏蔽掉spring默认的过滤规则
@ComponentScan(value = "com.evan",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})},
        useDefaultFilters = false)
public class MainConfig02 {
}
