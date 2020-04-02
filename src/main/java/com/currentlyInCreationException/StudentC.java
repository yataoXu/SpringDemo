package com.currentlyInCreationException;

/**
 * @Description
 * @ClassName StudentC
 * @Author Evan
 * @date 2020.04.02 10:19
 */
public class StudentC {
    private StudentA studentA;

    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }

    public StudentC() {
    }

    public StudentC(StudentA studentA) {
        this.studentA = studentA;
    }


}
