package com.company.hiding_test.hiding_inheritance;

public class ChildVariable extends ParentVariable {
    String instanceVariable = "child variable";

    @Override
    public void printInstanceVariable() {
        System.out.println(instanceVariable);
    }
}
