/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;
import java.util.Random;

public class Arrays {

    public static int[] coord = new int[2];
    public static int[] coordt = new int[2];
    public static int[] coordtt = new int[2];
    public static int[] coordttt = new int[2];
    public static int[] coordtttt = new int[2];
    public static int[] coorde = new int[2];
    static char[][] myArray = new char[40][40];
    static Scanner scan = new Scanner(System.in);
    static boolean thing = true;

    public static void main(String[] args) {
        array();
        enemySet(19,19);
        set(9, 9);
        
        

    }

    public static void array() {

        myArray = new char[20][20];
        for (int i = 0; i < 20; i++) {
            for (int a = 0; a < 20; a++) {
                myArray[i][a] = 'O';
                Random random = new Random();
        int r1 = random.nextInt(18);
        int r2 = random.nextInt(18);
        int r3 = random.nextInt(18);
        int r4 = random.nextInt(18);
        int r5 = random.nextInt(18);
        int r6 = random.nextInt(18);
        int r7 = random.nextInt(18);
        int r8 = random.nextInt(18);
        coordt[0] = r1;
        coordt[1] = r2;
        coordtt[0] = r3;
        coordtt[1] = r4;
        coordttt[0] = r5;
        coordttt[1] = r6;
        coordtttt[0] = r7;
        coordtttt[1] = r8;

            }

        }

    }

    public static void set(int x, int y) {
        
        coord[0] = x;
        coord[1] = y;
        myArray[coord[0]][coord[1]] = '@';
        
        myArray[coordt[0]][coordt[1]] = '*';
        myArray[coordtt[0]][coordtt[1]] = '*';
        myArray[coordttt[0]][coordttt[1]] = '*';
        myArray[coordtttt[0]][coordtttt[1]] = '*';
        while (thing) {
            printArray();
            movement();
        }
    }

    public static void printArray() {
        for (int i = 0; i < 20; i++) {
            for (int a = 0; a < 20; a++) {
                if (a < 19) {
                    System.out.print(myArray[i][a] + " ");
                } else {
                    System.out.println(myArray[i][a] + " ");
                }

            }

        }
        myArray[coord[0]][coord[1]] = 'O';
        myArray[coorde[0]][coorde[1]] = 'O';
        if (myArray[coord[0]][coord[1]] == myArray[coordt[0]][coordt[1]]) {
            thing = false;
        } else if (myArray[coord[0]][coord[1]] == myArray[coordtt[0]][coordtt[1]]) {
            thing = false;
        } else if (myArray[coord[0]][coord[1]] == myArray[coordttt[0]][coordttt[1]]) {
            thing = false;
        } else if (myArray[coord[0]][coord[1]] == myArray[coordtttt[0]][coordtttt[1]]) {
            thing = false;
        }
    }

    public static void movement() {
        System.out.println("What direction do you want to move? North(N), North-East(NE), North-West(NW), South(S), South-East(SE), South-West(SW), East(E), or West(W)?");
        Scanner intro = new Scanner(System.in);
        String a = intro.nextLine().toLowerCase();
        if (coorde[0] < coord[0]){
            coorde[0] += 1; 
        } else if( coorde[0] > coord[0]){
            coorde[0] -=1;
        }
        if (a.contains("ne")) {
            coord[0] -= 1;
            coord[1] += 1;
            printArray();
            System.out.println("North East");

        } else if (a.contains("nw")) {
            coord[0] -= 1;
            coord[1] -= 1;
            printArray();
            System.out.println("North West");

        } else if (a.contains("se")) {
            coord[0] += 1;
            coord[1] += 1;
            printArray();
            System.out.println("South East");

        } else if (a.contains("sw")) {
            coord[0] += 1;
            coord[1] -= 1;
            printArray();
            System.out.println("South West");

        } else if (a.contains("n")) {
            coord[0] -= 1;
            coord[1] += 0;
            printArray();
            System.out.println("North");
        } else if (a.contains("s")) {
            coord[0] += 1;
            coord[1] += 0;
            printArray();
            System.out.println("South");

        } else if (a.contains("w")) {
            coord[0] += 0;
            coord[1] -= 1;
            printArray();
            System.out.println("West");

        } else if (a.contains("e")) {
            coord[0] += 0;
            coord[1] += 1;
            printArray();
            System.out.println("East");

        }
        
        set(coord[0], coord[1]);
        set(coorde[0], coord[1]);
    }

    public static void enemySet(int ex, int ey) {
        coorde[0] = ex;
        coorde[1] = ey;
        myArray[coorde[0]][coorde[1]] = 'X';
    }
}
