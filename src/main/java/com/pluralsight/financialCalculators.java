package com.pluralsight;

import java.util.Scanner;

public class financialCalculators {
    public static void main(String[] args) {

    Scanner myScanner = new Scanner(System.in);

    System.out.println("Select a calculator. Enter 1, 2 or 3:");
    System.out.println("(1) Mortgage Calculator");
    System.out.println("(2) Future Value Calculator");
    System.out.println("(3) Present Value Calculator");

    int option = myScanner.nextInt();
        switch (option){
            case 1:
                mortgageCalculator();
                break;
            default:
                System.out.println("Wait.");
    }
}

    public static void mortgageCalculator() {
        Scanner myScanner = new Scanner(System.in);

            System.out.print("Enter the principal of the loan:");
            double principal = myScanner.nextDouble();
            System.out.print("Enter the interest rate of the loan (%):");
            double interestRate = myScanner.nextDouble();
            System.out.print("Enter the length of the loan (years):");
            double loanLength = myScanner.nextDouble();

            //        System.out.println(principal);
            //        System.out.println(interestRate);
            //        System.out.println(loanLength);

            double monthlyRate = interestRate / 100 / 12;
            double numPay = loanLength * 12;


            double monthlyPayNum = (principal * monthlyRate * (Math.pow(1 + monthlyRate, numPay)));
            double monthlyPayDen = (Math.pow(1 + monthlyRate, numPay)) - 1;

            double monthlyPay = monthlyPayNum / monthlyPayDen;
            String roundedMonthlyPay = String.format("%.2f", monthlyPay);

            //System.out.println(roundedMonthlyPay);

            double totalInterest = (monthlyPay * numPay) - principal;
            String roundedTotalInterest = String.format("%.2f", totalInterest);

            //System.out.println(roundedTotalInterest);

            System.out.println("A $" + principal + " loan at "
                    + interestRate + "% interest for " + loanLength + " years would have a $"
                    + roundedMonthlyPay + "/mo payment with a total interest of $" + roundedTotalInterest + ".");


    }

    public static void FutureValueCalculator{

    }
    //    public static class futureValueCalculator
//    public static class Calculator
}
