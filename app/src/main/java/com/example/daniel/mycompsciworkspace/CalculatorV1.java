package com.example.daniel.mycompsciworkspace;

import java.util.Scanner;

/**
 * Created by tina on 9/30/17.
 */

public class CalculatorV1 {
    static String operator;
    static Integer firstOperand;
    static Integer secondOperand;
    static Integer result;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input first Number");
        firstOperand = input.nextInt();

        System.out.println("Input operator");
        operator = input.next();

        System.out.println("Input last Number");
        secondOperand = input.nextInt();

        if (operator.equals("*")) {
            result = firstOperand * secondOperand;
        } else if (operator.equals("/")) {
            result = firstOperand / secondOperand;
        } else if (operator.equals("+")) {
            result = firstOperand + secondOperand;
        } else if (operator.equals("-")) {
            result = firstOperand - secondOperand;
        }
        System.out.println(firstOperand + operator + secondOperand + "=");
        System.out.print(result);

    }
}