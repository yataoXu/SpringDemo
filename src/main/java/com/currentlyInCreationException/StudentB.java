package com.currentlyInCreationException;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName StudentB
 * @Author Evan
 * @date 2020.04.02 10:19
 */
@Component
public class StudentB{

    private StudentA studentA;

    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }
}
