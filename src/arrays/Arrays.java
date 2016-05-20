/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Arrays {

    public static int[] coordt = new int[2];
    public static int[] coordtt = new int[2];
    public static int[] coordttt = new int[2];
    public static int[] coordtttt = new int[2];
    public static int[] coordtr = new int[2];
    public static int[] coordtrr = new int[2];
    public static Player player;
    public static Enemy enemy;
    public static Treasure treasure;
    public static Enemy1 enemy1;
    static char[][] myArray = new char[40][40];
    static Scanner scan = new Scanner(System.in);
    static boolean thing = true;

    public static void main(String[] args) {
        enemy = new Enemy(18, 9);
        enemy1 = new Enemy1(1,9);
        player = new Player(9, 9);
        array();

    }

    public static void array() {
        System.out.println("You are an explorer, looking for his lost treasure(T) in an abandoned cave.");
        System.out.println(" Your goal is to collect the treasure, avoiding the old traps(*) and the creatures located in the cave(x)");
        myArray = new char[20][20];
        for (int i = 0; i < 20; i++) {
            for (int a = 0; a < 20; a++) {
                myArray[i][a] = '.';

                Random random = new Random();

                int r1 = random.nextInt(18);
                int r2 = random.nextInt(18);
                int r3 = random.nextInt(18);
                int r4 = random.nextInt(18);
                int r5 = random.nextInt(18);
                int r6 = random.nextInt(18);
                int r7 = random.nextInt(18);
                int r8 = random.nextInt(18);
                int r9 = random.nextInt(18);
                int r10 = random.nextInt(18);
                int r11 = random.nextInt(18);
                int r12 = random.nextInt(18);

                coordt[0] = r1;
                coordt[1] = r2;
                coordtt[0] = r3;
                coordtt[1] = r4;
                coordttt[0] = r5;
                coordttt[1] = r6;
                coordtttt[0] = r7;
                coordtttt[1] = r8;

                coordtr[0] = r9;
                coordtr[1] = r10;
                coordtrr[0] = r11;
                coordtrr[1] = r12;
            }

        }

        myArray[coordtr[0]][coordtr[1]] = 'T';
        myArray[coordtrr[0]][coordtrr[1]] = 'T';
        set();
    }

    public static void set() {

        myArray[player.x][player.y] = '@';

        myArray[coordt[0]][coordt[1]] = '*';
        myArray[coordtt[0]][coordtt[1]] = '*';
        myArray[coordttt[0]][coordttt[1]] = '*';
        myArray[coordtttt[0]][coordtttt[1]] = '*';
        myArray[enemy.x][enemy.y] = 'X';
        myArray[enemy1.x][enemy1.y] = 'X';
        while (thing) {
            if (player.score == 2) {
                System.out.println("   :::   ::: :::::::: :::    ::::::       ::::::::::::::::::    ::: \n"
                        + "  :+:   :+::+:    :+::+:    :+::+:       :+:    :+:    :+:+:   :+:  \n"
                        + "  +:+ +:+ +:+    +:++:+    +:++:+       +:+    +:+    :+:+:+  +:+   \n"
                        + "  +#++:  +#+    +:++#+    +:++#+  +:+  +#+    +#+    +#+ +:+ +#+    \n"
                        + "  +#+   +#+    +#++#+    +#++#+ +#+#+ +#+    +#+    +#+  +#+#+#     \n"
                        + " #+#   #+#    #+##+#    #+# #+#+# #+#+#     #+#    #+#   #+#+#      \n"
                        + "###    ########  ########   ###   ###  ##############    ####   ");
                thing = false;
            }
            if (player.x == coordtr[0] && player.y == coordtr[1]) {
                player.score += 1;
                System.out.println("Score: " + player.score);
                myArray[coordtr[0]][coordtr[1]] = '.';

            }
            if (player.x == coordtrr[0] && player.y == coordtrr[1]) {
                player.score += 1;
                System.out.println("Score: " + player.score);
                myArray[coordtrr[0]][coordtrr[1]] = '.';

            }

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
        myArray[player.x][player.y] = '.';
        myArray[enemy.x][enemy.y] = '.';
        myArray[enemy1.x][enemy1.y] = '.';
        if (player.x == coordt[0] && player.y == coordt[1]) {
            System.out.println("   :::   ::: :::::::: :::    ::::::       ::::::::  :::::::: :::::::::: \n"
                    + "  :+:   :+::+:    :+::+:    :+::+:      :+:    :+::+:    :+::+:         \n"
                    + "  +:+ +:+ +:+    +:++:+    +:++:+      +:+    +:++:+       +:+          \n"
                    + "  +#++:  +#+    +:++#+    +:++#+      +#+    +:++#++:++#+++#++:++#      \n"
                    + "  +#+   +#+    +#++#+    +#++#+      +#+    +#+       +#++#+            \n"
                    + " #+#   #+#    #+##+#    #+##+#      #+#    #+##+#    #+##+#             \n"
                    + "###    ########  ######## ##################  ######## ##########       \n"
                    + "");
            thing = false;
        } else if (player.x == coordtt[0] && player.y == coordtt[1]) {
            System.out.println("   :::   ::: :::::::: :::    ::::::       ::::::::  :::::::: :::::::::: \n"
                    + "  :+:   :+::+:    :+::+:    :+::+:      :+:    :+::+:    :+::+:         \n"
                    + "  +:+ +:+ +:+    +:++:+    +:++:+      +:+    +:++:+       +:+          \n"
                    + "  +#++:  +#+    +:++#+    +:++#+      +#+    +:++#++:++#+++#++:++#      \n"
                    + "  +#+   +#+    +#++#+    +#++#+      +#+    +#+       +#++#+            \n"
                    + " #+#   #+#    #+##+#    #+##+#      #+#    #+##+#    #+##+#             \n"
                    + "###    ########  ######## ##################  ######## ##########       \n"
                    + "");
            thing = false;
        } else if (player.x == coordttt[0] && player.y == coordttt[1]) {
            System.out.println("   :::   ::: :::::::: :::    ::::::       ::::::::  :::::::: :::::::::: \n"
                    + "  :+:   :+::+:    :+::+:    :+::+:      :+:    :+::+:    :+::+:         \n"
                    + "  +:+ +:+ +:+    +:++:+    +:++:+      +:+    +:++:+       +:+          \n"
                    + "  +#++:  +#+    +:++#+    +:++#+      +#+    +:++#++:++#+++#++:++#      \n"
                    + "  +#+   +#+    +#++#+    +#++#+      +#+    +#+       +#++#+            \n"
                    + " #+#   #+#    #+##+#    #+##+#      #+#    #+##+#    #+##+#             \n"
                    + "###    ########  ######## ##################  ######## ##########       \n"
                    + "");
            thing = false;
        } else if (player.x == coordtttt[0] && player.y == coordtttt[1]) {

            System.out.println("   :::   ::: :::::::: :::    ::::::       ::::::::  :::::::: :::::::::: \n"
                    + "  :+:   :+::+:    :+::+:    :+::+:      :+:    :+::+:    :+::+:         \n"
                    + "  +:+ +:+ +:+    +:++:+    +:++:+      +:+    +:++:+       +:+          \n"
                    + "  +#++:  +#+    +:++#+    +:++#+      +#+    +:++#++:++#+++#++:++#      \n"
                    + "  +#+   +#+    +#++#+    +#++#+      +#+    +#+       +#++#+            \n"
                    + " #+#   #+#    #+##+#    #+##+#      #+#    #+##+#    #+##+#             \n"
                    + "###    ########  ######## ##################  ######## ##########       \n"
                    + "");
            thing = false;
        }

        if (enemy.x == coordt[0] && enemy.y == coordt[1]) {

            enemy.isalive = false;
        } else if (enemy.x == coordtt[0] && enemy.y == coordtt[1]) {

            enemy.isalive = false;
        } else if (enemy.x == coordttt[0] && enemy.y == coordttt[1]) {

            enemy.isalive = false;
        } else if (enemy.x == coordtttt[0] && enemy.y == coordtttt[1]) {

            enemy.isalive = false;
        }
        if (enemy1.x == coordt[0] && enemy1.y == coordt[1]) {

            enemy1.isalive = false;
        } else if (enemy1.x == coordtt[0] && enemy1.y == coordtt[1]) {

            enemy1.isalive = false;
        } else if (enemy1.x == coordttt[0] && enemy1.y == coordttt[1]) {

            enemy1.isalive = false;
        } else if (enemy1.x == coordtttt[0] && enemy1.y == coordtttt[1]) {

            enemy1.isalive = false;
        }

        if (player.x == enemy.x && player.y == enemy.y) {
            System.out.println("   :::   ::: :::::::: :::    ::::::       ::::::::  :::::::: :::::::::: \n"
                    + "  :+:   :+::+:    :+::+:    :+::+:      :+:    :+::+:    :+::+:         \n"
                    + "  +:+ +:+ +:+    +:++:+    +:++:+      +:+    +:++:+       +:+          \n"
                    + "  +#++:  +#+    +:++#+    +:++#+      +#+    +:++#++:++#+++#++:++#      \n"
                    + "  +#+   +#+    +#++#+    +#++#+      +#+    +#+       +#++#+            \n"
                    + " #+#   #+#    #+##+#    #+##+#      #+#    #+##+#    #+##+#             \n"
                    + "###    ########  ######## ##################  ######## ##########       \n"
                    + "");
            thing = false;
        }
        if (player.x == enemy1.x && player.y == enemy1.y) {
            System.out.println("   :::   ::: :::::::: :::    ::::::       ::::::::  :::::::: :::::::::: \n"
                    + "  :+:   :+::+:    :+::+:    :+::+:      :+:    :+::+:    :+::+:         \n"
                    + "  +:+ +:+ +:+    +:++:+    +:++:+      +:+    +:++:+       +:+          \n"
                    + "  +#++:  +#+    +:++#+    +:++#+      +#+    +:++#++:++#+++#++:++#      \n"
                    + "  +#+   +#+    +#++#+    +#++#+      +#+    +#+       +#++#+            \n"
                    + " #+#   #+#    #+##+#    #+##+#      #+#    #+##+#    #+##+#             \n"
                    + "###    ########  ######## ##################  ######## ##########       \n"
                    + "");
            thing = false;
        }

    }

    public static void movement() {
        System.out.println("What direction do you want to move? North(N), North-East(NE), North-West(NW), South(S), South-East(SE), South-West(SW), East(E), or West(W)?");
        Scanner intro = new Scanner(System.in);
        String a = intro.nextLine().toLowerCase();
        if (enemy.x == 0) {
            enemy.x++;
        }
        if (enemy.x == 19) {
            enemy.x--;
        }
        if (enemy.y == 0) {
            enemy.y++;
        }
        if (enemy.y == 19) {
            enemy.y--;
        }
        if (enemy1.x == 0) {
            enemy1.x++;
        }
        if (enemy1.x == 19) {
            enemy1.x--;
        }
        if (enemy1.y == 0) {
            enemy1.y++;
        }
        if (enemy1.y == 19) {
            enemy1.y--;
        }
        if (player.x == 0) {
            player.x++;
        }
        if (player.x == 19) {
            player.x--;
        }
        if (player.y == 0) {
            player.y++;
        }
        if (player.y == 19) {
            player.y--;
        }
        if (enemy.isalive) {
            if (enemy.x < player.x) {
                enemy.x += 1;
            } else if (enemy.x > player.x) {
                enemy.x -= 1;
            }
            if (enemy.y < player.y) {
                enemy.y += 1;
            } else if (enemy.y > player.y) {
                enemy.y -= 1;
            }
        }
        if (enemy1.isalive) {
            if (enemy1.x < player.x) {
                enemy1.x += 1;
            } else if (enemy1.x > player.x) {
                enemy1.x -= 1;
            }
            if (enemy1.y < player.y) {
                enemy1.y += 1;
            } else if (enemy1.y > player.y) {
                enemy1.y -= 1;
            }
        }

        if (a.contains("ne")) {
            player.x -= 1;
            player.y += 1;
            printArray();
            System.out.println("North East");

        } else if (a.contains("nw")) {
            player.x -= 1;
            player.y -= 1;
            printArray();
            System.out.println("North West");

        } else if (a.contains("se")) {
            player.x += 1;
            player.y += 1;
            printArray();
            System.out.println("South East");

        } else if (a.contains("sw")) {
            player.x += 1;
            player.y -= 1;
            printArray();
            System.out.println("South West");

        } else if (a.contains("n")) {
            player.x -= 1;
            player.y += 0;
            printArray();
            System.out.println("North");
        } else if (a.contains("s")) {
            player.x += 1;
            player.y += 0;
            printArray();
            System.out.println("South");

        } else if (a.contains("w")) {
            player.x += 0;
            player.y -= 1;
            printArray();
            System.out.println("West");

        } else if (a.contains("e")) {
            player.x += 0;
            player.y += 1;
            printArray();
            System.out.println("East");

        }

        set();

    }

}
