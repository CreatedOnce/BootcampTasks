package com.bootcamp.alexander.dictionaryCities.manager;

import java.util.Scanner;

public  class Manager {

    public static void  menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter choose the steps:\n" +
                "1 - Show list\n" +
                "2 - Show value\n" +
                "3 - Show something\n" +
                "4 - Show the steps\n");

        boolean check = false;

        while(!check){
            int choice = in.nextInt();
            switch (choice){

                case 1:
                    System.out.println("Module 1: \n");
                    break;
                case 2:
                    System.out.println("Module 2: \n");
                    break;
                case 3:
                    System.out.println("Module 3: \n");
                    break;
                case 4:
                    System.out.println("Module 4: \n");
                    break;
                case 5:
                    check = true;
                    break;
                default:
                    System.out.println("Not correct input\n");

            }
        }

    }
}
