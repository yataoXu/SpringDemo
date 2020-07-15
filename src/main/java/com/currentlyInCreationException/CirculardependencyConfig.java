package com.currentlyInCreationException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @ClassName CirculardependencyConfig
 * @Author Evan
 * @date 2020.07.14 13:39
 */

@Configuration
@ComponentScan(basePackages = { "com.currentlyInCreationException" })
public class CirculardependencyConfig {
}
