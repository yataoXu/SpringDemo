package com.currentlyInCreationException;

/**
 * @Description
 * @ClassName StudentB
 * @Author Evan
 * @date 2020.04.02 10:19
 */
public class StudentB {
    private StudentC studentC ;

    public void setStudentC(StudentC studentC) {
        this.studentC = studentC;
    }

    public StudentB() {
    }

    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }

}
