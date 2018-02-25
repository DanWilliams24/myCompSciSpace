package com.example.daniel.mycompsciworkspace.School.OOP.MovieProject;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by tina on 2/22/18.
 */

public class Main {
    private static Rental[] rentals;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rentals: ");
        int N = sc.nextInt();
        rentals = new Rental[N];
        retrieveUserInput(N);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Outstanding Late Fees Total for " + N + " Movie Rentals:\n "
                + currency.format(lateFeesOwed(rentals)));
        sc.close();
    }

    public static void retrieveUserInput(int n) {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            System.out.println("Enter Movie Rating(G,PG,PG-13,R): ");
            MPAA rating = new MPAA(input.next());
            System.out.println("Enter Movie ID: ");
            int movieID = input.nextInt();
            System.out.println("Enter Customer ID: ");
            int customerID = input.nextInt();
            System.out.println("Enter Title(No Spaces): ");
            String title = input.next();
            System.out.println("Enter Days Late: ");
            int daysLate = input.nextInt();
            System.out.println("Enter Movie Genre: ");
            String genre = input.next();
            Rental rental;
            switch (genre.toLowerCase()){
                case "comedy":
                    rental = new Rental(new Comedy(rating,movieID,title),customerID,daysLate);
                    System.out.println(rental.toString());
                    rentals[i] = rental;
                    break;
                case "action":
                    rental = new Rental(new Action(rating, movieID, title), customerID, daysLate);
                    rentals[i] = rental;
                    System.out.println(rental.toString());
                    break;
                case "drama":
                    rental = new Rental(new Drama(rating,movieID,title),customerID,daysLate);
                    rentals[i] = rental;
                    System.out.println(rental.toString());
                    break;
                default: throw new IllegalArgumentException("Genre must be a comedy, action or drama.");
            }
            System.out.println("=================================================================");
        }
        input.close();
    }

    public static double lateFeesOwed(Rental[] arr){
        double sum = 0;
        for(int i = 0; i < arr.length;i++){
            sum += arr[i].calculateLateFees();
        }
        return sum;
    }
}
