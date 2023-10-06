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
            case 2:
                futureValueCalculator();
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

    public static void futureValueCalculator() {

        Scanner myScanner = new Scanner(System.in);

            System.out.print("Enter the deposit amount:");
            double deposit = myScanner.nextDouble();

            System.out.print("Enter the interest rate (%):");
            double maturityRate = myScanner.nextDouble();

            System.out.print("Enter the number of years:");
            double years = myScanner.nextDouble();

            double n= 365; // since it is compounded daily

            double futureValue = deposit* (Math.pow(1+(maturityRate/100/n), n*years));
            System.out.println(futureValue);
            String roundedFutureValue = String.format("%.2f", futureValue);


            double totalDepositInterest = futureValue-deposit;
            System.out.println(totalDepositInterest);
            String roundedTotalDepositInterest = String.format("%.2f", totalDepositInterest);


            System.out.println("For the deposit amount of $" + deposit + " in a CD that earns "+ maturityRate +
                    "% interest and matures in " +years+ "years, your ending balance will be $" +roundedFutureValue+
                    "and you would have earned $" + roundedTotalDepositInterest+ "in interest." );


// "For the deposit amount of $ deposit in a CD that earns maturityRate % interest and matures in years years, your ending balance will be $ futureValue
// and you would have earned $ totalInterest in interest."

    }
    //    public static class futureValueCalculator
//    public static class Calculator
}
