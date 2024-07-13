import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter number of rounds you want to play: ");
        int round = 0;
        try {
            round = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("'WRONG INPUT, INPUT ACCEPT NUMBERS ONLY'");
        }
        for (int rounds = 1; rounds <= round; rounds++) {

            //2D array store the x and o spots numbers
            char[][] tictactoe_arr = new char[3][3];
            tictactoe_arr[0][0] = '1';
            tictactoe_arr[0][1] = '2';
            tictactoe_arr[0][2] = '3';
            tictactoe_arr[1][0] = '4';
            tictactoe_arr[1][1] = '5';
            tictactoe_arr[1][2] = '6';
            tictactoe_arr[2][0] = '7';
            tictactoe_arr[2][1] = '8';
            tictactoe_arr[2][2] = '9';


            // the user chose if he wants to play X or O and the computer will choose the opposite
            System.out.println("\nChose your side 'X' or 'O' to start the game: ");
            char user_side = input.next().charAt(0);

            while (user_side != 'x' && user_side != 'X' && user_side != 'o' && user_side != 'O') {
                System.out.println("'WRONG INPUT'" +
                        " Chose your user_side 'x' or 'o': ");
                user_side = input.next().charAt(0);
            }

            //the computer choose the opposite side of the user
            char computer_SIDE;
            if (user_side == 'O' || user_side == 'o') {
                computer_SIDE = 'X';
            } else {
                computer_SIDE = 'O';
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("|" + tictactoe_arr[i][j] + "|");
                }
                System.out.println("\n---------");
            }

            //count both user and computer terns so when the terns equal 9 the round end
            int count_terns = 0;


            int user_positionn = 0;

            //User turn--------------------------------------------------------------------------
            for (int i = 0; i <= 4; i++) {

                System.out.println("your turn, Chose your position: ");
                try {

                    // user choose the position and the position should be between 1 and 9
                    user_positionn = input.nextInt();
                    while (user_positionn > 9 || user_positionn <= 0) {
                        System.out.println("'POSITION NUMBER HIGHER OR LOWER THAN THE LIMIT' chose from '1' to '9': ");
                        user_positionn = input.nextInt();
                    }

                    // check if the chosen position from the user if it's free or token
                    while (!check_pos(user_positionn, tictactoe_arr, user_side, computer_SIDE)) {
                        user_positionn = input.nextInt();
                        System.out.println(check_pos(user_positionn, tictactoe_arr, user_side, computer_SIDE));
                    }
                    count_terns++;
                    user_tern(user_positionn, tictactoe_arr, user_side);

                    // check if the user complete the line or not
                    if (winner(tictactoe_arr, user_side, computer_SIDE)) {
                        break;
                    }
                } catch (InputMismatchException exception) {
                    System.out.println(" 'USER WRONG INPUT' ");
                }

                //COMPUTER TURN__________________________________________________________
                // when the count reach 8, the computer will stop generating random nimbers
                if (count_terns < 8) {

                    //generate number
                    Random rand_num = new Random();
                    int max = 9;
                    int min = 1;
                    int c_position;//computer positioning

                    System.out.println("computer turn");
                    c_position = rand_num.nextInt((max - min) + 1) + min;

                    // check if the chosen position from the user if it's free or token
                    while (!computer_check_pos(c_position, tictactoe_arr, computer_SIDE, user_side)) {
                        System.out.println("COMPUTER CHOSE TAKEN SPOT, SEARCHING ANOTHER...");
                        c_position = rand_num.nextInt((max - min) + 1) + min;
                        System.out.println(computer_check_pos(c_position, tictactoe_arr, computer_SIDE, user_side));
                    }


                    count_terns++;
                    //computer start playing
                    computer_tern(c_position, tictactoe_arr, computer_SIDE);


                    if (winner(tictactoe_arr, user_side, computer_SIDE)) {
                        break;
                    }
                    winner(tictactoe_arr, user_side, computer_SIDE);
                }
            }
            System.out.println("\nRound " + rounds + " finish");
        }
    }

    //method for the user to check the spot if it free or token
    public static boolean check_pos(int pos_state, char[][] position_arr, char user_side, char computer_SIDE) {
        switch (pos_state) {
            case 1:
                if (position_arr[0][0] == user_side || position_arr[0][0] == computer_SIDE) {
                    System.out.println("Position taken please try another.");
                    return false;
                }
                break;
            case 2:
                if (position_arr[0][1] == user_side || position_arr[0][1] == computer_SIDE) {
                    System.out.println("Position taken please try another.");
                    return false;
                }
                break;
            case 3:
                if (position_arr[0][2] == user_side || position_arr[0][2] == computer_SIDE) {
                    System.out.println("Position taken please try another.");
                    return false;
                }
                break;
            case 4:
                if (position_arr[1][0] == user_side || position_arr[1][0] == computer_SIDE) {
                    System.out.println("Position taken please try another.");
                    return false;
                }
                break;
            case 5:
                if (position_arr[1][1] == user_side || position_arr[1][1] == computer_SIDE) {
                    System.out.println("Position taken please try another.");
                    return false;
                }
                break;
            case 6:
                if (position_arr[1][2] == user_side || position_arr[1][2] == computer_SIDE) {
                    System.out.println("Position taken please try another.");
                    return false;
                }
                break;
            case 7:
                if (position_arr[2][0] == user_side || position_arr[2][0] == computer_SIDE) {
                    System.out.println("Position taken please try another.");
                    return false;
                }
                break;
            case 8:
                if (position_arr[2][1] == user_side || position_arr[2][1] == computer_SIDE) {
                    System.out.println("Position taken please try another.");
                    return false;
                }
                break;
            case 9:
                if (position_arr[2][2] == user_side || position_arr[2][2] == computer_SIDE) {
                    System.out.println("Position taken please try another.");
                    return false;
                }
                break;
        }
        return true;
    }

    //method for the computer to check the spot if it free or token
    public static boolean computer_check_pos(int pos_state, char[][] position_arr, char user_side, char computer_SIDE) {
        switch (pos_state) {
            case 1:
                if (position_arr[0][0] == computer_SIDE || position_arr[0][0] == user_side) {
                    return false;
                }
                break;
            case 2:
                if (position_arr[0][1] == computer_SIDE || position_arr[0][1] == user_side) {

                    return false;
                }
                break;
            case 3:
                if (position_arr[0][2] == computer_SIDE || position_arr[0][2] == user_side) {
                    return false;
                }
                break;
            case 4:
                if (position_arr[1][0] == computer_SIDE || position_arr[1][0] == user_side) {
                    return false;
                }
                break;
            case 5:
                if (position_arr[1][1] == computer_SIDE || position_arr[1][1] == user_side) {
                    return false;
                }
                break;
            case 6:
                if (position_arr[1][2] == computer_SIDE || position_arr[1][2] == user_side) {
                    return false;
                }
                break;
            case 7:
                if (position_arr[2][0] == computer_SIDE || position_arr[2][0] == user_side) {
                    return false;
                }
                break;
            case 8:
                if (position_arr[2][1] == computer_SIDE || position_arr[2][1] == user_side) {
                    return false;
                }
                break;
            case 9:
                if (position_arr[2][2] == computer_SIDE || position_arr[2][2] == user_side) {
                    return false;
                }
                break;
        }
        return true;
    }

    //method for computer to start play
    public static void computer_tern(int c_position, char[][] tictactoe_arr, char computer_side) {

        System.out.println("computer chose position: " + "'" + c_position + "'");

        switch (c_position) {
            case 1:
                tictactoe_arr[0][0] = computer_side;

                int i;
                int j;

                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 2:
                tictactoe_arr[0][1] = computer_side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 3:
                tictactoe_arr[0][2] = computer_side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 4:
                tictactoe_arr[1][0] = computer_side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 5:
                tictactoe_arr[1][1] = computer_side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 6:
                tictactoe_arr[1][2] = computer_side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 7:
                tictactoe_arr[2][0] = computer_side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 8:
                tictactoe_arr[2][1] = computer_side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 9:
                tictactoe_arr[2][2] = computer_side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
        }
    }

    //user playing method
    public static void user_tern(int position, char[][] tictactoe_arr, char side) {


        switch (position) {
            case 1:

                tictactoe_arr[0][0] = side;
                int i;
                int j;

                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 2:

                tictactoe_arr[0][1] = side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 3:

                tictactoe_arr[0][2] = side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 4:

                tictactoe_arr[1][0] = side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;

            case 5:
                tictactoe_arr[1][1] = side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 6:
                tictactoe_arr[1][2] = side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 7:
                tictactoe_arr[2][0] = side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 8:
                tictactoe_arr[2][1] = side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
            case 9:
                tictactoe_arr[2][2] = side;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        System.out.print("|" + tictactoe_arr[i][j] + "|");
                    }
                    System.out.println("\n---------");
                }
                break;
        }
    }

    //method to check the winner
    public static boolean winner(char[][] tictactoe_arr, char user_Side, char computer_SIDE) {

        //FIRST ROW
        if (tictactoe_arr[0][0] == user_Side && tictactoe_arr[0][1] == user_Side && tictactoe_arr[0][2] == user_Side) {
            System.out.println("[||CONGRATULATION YOU WIN||]");
            return true;
        } else if (tictactoe_arr[0][0] == computer_SIDE && tictactoe_arr[0][1] == computer_SIDE &&
                tictactoe_arr[0][2] == computer_SIDE) {
            System.out.println("YOU LOST | COMPUTER DEFEAT YOU");
            return true;
        }

        //SECOND ROW
        if (tictactoe_arr[1][0] == user_Side && tictactoe_arr[1][1] == user_Side && tictactoe_arr[1][2] == user_Side) {
            System.out.println("[||CONGRATULATION YOU WIN||]");
            return true;
        } else if (tictactoe_arr[1][0] == computer_SIDE && tictactoe_arr[1][1] == computer_SIDE &&
                tictactoe_arr[1][2] == computer_SIDE) {
            System.out.println("YOU LOST | COMPUTER DEFEAT YOU");
            return true;
        }

        //THIRD ROW
        if (tictactoe_arr[2][0] == user_Side && tictactoe_arr[2][1] == user_Side && tictactoe_arr[2][2] == user_Side) {
            System.out.println("[||CONGRATULATION YOU WIN||]");
            return true;
        } else if (tictactoe_arr[2][0] == computer_SIDE && tictactoe_arr[2][1] == computer_SIDE &&
                tictactoe_arr[2][2] == computer_SIDE) {
            System.out.println("YOU LOST | COMPUTER DEFEAT YOU");
            return true;
        }

        //FIRST COL
        if (tictactoe_arr[0][0] == user_Side && tictactoe_arr[1][0] == user_Side && tictactoe_arr[2][0] == user_Side) {
            System.out.println("[||CONGRATULATION YOU WIN||]");
            return true;
        } else if (tictactoe_arr[0][0] == computer_SIDE && tictactoe_arr[1][0] == computer_SIDE &&
                tictactoe_arr[2][0] == computer_SIDE) {
            System.out.println("YOU LOST | COMPUTER DEFEAT YOU");
            return true;
        }

        //SECOND COL
        if (tictactoe_arr[0][1] == user_Side && tictactoe_arr[1][1] == user_Side && tictactoe_arr[2][1] == user_Side) {
            System.out.println("[||CONGRATULATION YOU WIN||]");
            return true;
        } else if (tictactoe_arr[2][0] == computer_SIDE && tictactoe_arr[2][1] == computer_SIDE &&
                tictactoe_arr[2][2] == computer_SIDE) {
            System.out.println("YOU LOST | COMPUTER DEFEAT YOU");
            return true;
        }

        //THIRD COL
        if (tictactoe_arr[0][2] == user_Side && tictactoe_arr[1][2] == user_Side && tictactoe_arr[2][2] == user_Side) {
            System.out.println("[||CONGRATULATION YOU WIN||]");
            return true;
        } else if (tictactoe_arr[0][2] == computer_SIDE && tictactoe_arr[1][2] == computer_SIDE &&
                tictactoe_arr[2][2] == computer_SIDE) {
            System.out.println("YOU LOST | COMPUTER DEFEAT YOU");
            return true;
        }

        //TOP RIGHT TO DOWN LEFT CORNERS
        if (tictactoe_arr[0][2] == user_Side && tictactoe_arr[1][1] == user_Side && tictactoe_arr[2][0] == user_Side) {
            System.out.println("[||CONGRATULATION YOU WIN||]");
            return true;
        } else if (tictactoe_arr[0][2] == computer_SIDE && tictactoe_arr[1][1] == computer_SIDE &&
                tictactoe_arr[2][0] == computer_SIDE) {
            System.out.println("YOU LOST | COMPUTER DEFEAT YOU");
            return true;
        }

        //TOP LEFT TO DOWN RIGHT
        if (tictactoe_arr[0][0] == user_Side && tictactoe_arr[1][1] == user_Side && tictactoe_arr[2][2] == user_Side) {
            System.out.println("[||CONGRATULATION YOU WIN||]");
            return true;
        } else if (tictactoe_arr[0][0] == computer_SIDE && tictactoe_arr[1][1] == computer_SIDE &&
                tictactoe_arr[2][2] == computer_SIDE) {
            System.out.println("YOU LOST | COMPUTER DEFEAT YOU ");
            return true;
        }

        return false;
    }
}