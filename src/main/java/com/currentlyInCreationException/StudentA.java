package com.currentlyInCreationException;

/**
 * @Description
 * @ClassName StudentA
 * @Author Evan
 * @date 2020.04.02 10:19
 */
public class StudentA {
    private StudentB studentB ;

    public void setStudentB(StudentB studentB) {
        this.studentB = studentB;
    }

    public StudentA() {
    }

    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }

}
