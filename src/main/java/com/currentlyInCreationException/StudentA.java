package com.currentlyInCreationException;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName StudentA
 * @Author Evan
 * @date 2020.04.02 10:19
 */
@Component
public class StudentA {

    private StudentB studentB;

    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }
}
