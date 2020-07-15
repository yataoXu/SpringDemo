package com.evan.tx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @ClassName Blog
 * @Author Evan
 * @date 2020.07.15 13:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private int id;
    private String name;
    private String ur;
}