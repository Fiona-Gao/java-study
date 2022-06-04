package com.solution;

import com.solution.StackQueen.StackTest;
import com.solution.array.ArrayTest;

public class Main {
    public static void main(String[] args) {
//        ArrayTest f = new ArrayTest();
//        int[] a = new int[]{1,1,0,3,4,0,5,5};
//        int[] b =f.moveZeroes(a);
//        for (int i = 0; i < b.length; i++){
//            System.out.println(b[i]);
//        }

//        String s = "()";
//        StackTest test = new StackTest();
//        System.out.println(test.isValid(s));
        String s = "(3 + 2) * 2";
        StackTest test = new StackTest();
        System.out.println(test.calculate(s));




    }
}
