import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Double> results = new ArrayList<Double>();

        System.out.println("Welcome to calculator");
        Scanner input = new Scanner(System.in);

        int options =0;
try {


    do {
        while (options < 0 || options > 10) {
            System.out.println("WRONG INPUT,Please enter from 1 to 10 or -1 to exit.");
            options = input.nextInt();
            if (options == -1) {
                break;
            }
        }
        if (options == -1) {
            break;
        }
        System.out.println("\n" +
                "Enter 1 to addition the numbers\n" +
                "\n" +
                "Enter 2 to subtraction the numbers\n" +
                "\n" +
                "Enter 3 to multiplication the numbers\n" +
                "\n" +
                "Enter 4 to division the numbers\n" +
                "\n" +
                "Enter 5 to modulus the numbers\n" +
                "\n" +
                "Enter 6 to find minimum number\n" +
                "\n" +
                "Enter 7 to find maximum number\n" +
                "\n" +
                "Enter 8 to find the average of numbers\n" +
                "\n" +
                "Enter 9 to print the last result in calculator\n" +
                "\n" +
                "Enter 10 to print the list of all results in calculator");
        System.out.println("\nChose the operation: ");
        options = input.nextInt();
        if (options == -1) {
            break;
        }

        if (options == 1) {
            System.out.println(addition(results));
        }
        if (options == 2) {
            System.out.println(subtraction(results));
        }
        if (options == 3) {
            System.out.println(multiplication(results));
        }
        if (options == 4) {
            System.out.println(division(results));
        }
        if (options == 5) {
            System.out.println(modulus(results));
        }
        if (options == 6) {
            System.out.println("minimum number is: " + minimum_num(results));
        }
        if (options == 7) {
            System.out.println("maximum number is: " + maximum_num(results));
        }
        if (options == 8) {
            System.out.println("The average is: " + average_num(results));
        }
        if (options == 9) {
            for (double l : results) {
                System.out.print("Last results: " + l + "|");
            }
        }
        if (options == 10) {
            System.out.println("ALL RESULT: " + results);
        }
    } while (options != -1);

}catch (InputMismatchException e){
    System.out.println("'WRONG INPUT',ENTER NUMBERS ONLY.");
}
    }


    //OPERATIONS METHODS

    public static double addition(ArrayList results) {

        System.out.println("--- Addition operation ---");
        Scanner add = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num_1 = add.nextDouble();
        System.out.println("Enter second number: ");
        double num_2 = add.nextDouble();

        double add_Result = 0;
        add_Result = num_1 + num_2;
        results.add(add_Result);
        System.out.println(" 'ADDITION COMPLETE SUCCESSFULLY'  ");
        return add_Result;

    }

    public static double subtraction(ArrayList results) {
        System.out.println("--- Subtraction operation ---");
        Scanner sub = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num_1 = sub.nextDouble();
        System.out.println("Enter second number: ");
        double num_2 = sub.nextDouble();
        double sub_Result = 0;
        sub_Result = num_1 - num_2;
        results.add(sub_Result);
        System.out.println(" 'SUBTRACTION COMPLETE SUCCESSFULLY'  ");
        return sub_Result;
    }

    public static double multiplication(ArrayList results) {
        System.out.println("--- Multiplication operation ---");
        Scanner mul = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num_1 = mul.nextDouble();
        System.out.println("Enter second number: ");
        double num_2 = mul.nextDouble();
        double mul_Result = 0;
        mul_Result = num_1 * num_2;
        results.add(mul_Result);
        System.out.println(" 'MULTIPLICATION COMPLETE SUCCESSFULLY'  ");
        return mul_Result;
    }

    public static double division(ArrayList results) {
        System.out.println("--- Division operation ---");
        Scanner div = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num_1 = div.nextDouble();
        System.out.println("Enter second number: ");
        double num_2 = div.nextDouble();
        if (num_1 == 0 || num_2==0){
            System.out.println("'No number can be divide on zero'");
        }
        double div_Result = 0;
        div_Result = num_1 / num_2;
        results.add(div_Result);
        System.out.println(" 'DIVISION COMPLETE'  ");
        return div_Result;
    }

    public static double modulus(ArrayList results) {
        System.out.println("--- Modulus operation ---");
        Scanner mod = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num_1 = mod.nextDouble();
        System.out.println("Enter second number: ");
        double num_2 = mod.nextDouble();
        double mod_Result = 0;
        mod_Result = num_1 % num_2;
        results.add(mod_Result);
        System.out.println(" 'MODULUS COMPLETE SUCCESSFULLY'  ");
        return mod_Result;
    }

    public static double minimum_num(ArrayList results) {
        System.out.println("--- Find minimum number ---");
        Scanner min = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num_1 = min.nextDouble();
        System.out.println("Enter second number: ");
        double num_2 = min.nextDouble();
        double min_Result = 0;
        if (num_1 < num_2) {
            min_Result = num_1;
        } else if (num_2 < num_1) {
            min_Result = num_2;
        } else System.out.println("both equals");

        results.add(min_Result);
        System.out.println(" 'MINIMUM NUMBER FOUND'  ");
        return min_Result;
    }

    public static double maximum_num(ArrayList results) {
        System.out.println("--- Find maximum number ---");
        Scanner max = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num_1 = max.nextDouble();
        System.out.println("Enter second number: ");
        double num_2 = max.nextDouble();
        double max_Result = 0;
        if (num_1 > num_2) {
            max_Result = num_1;
        } else if (num_2 > num_1) {
            max_Result = num_2;
        } else System.out.println("both equals");

        results.add(max_Result);
        System.out.println(" 'MAXIMUM NUMBER FOUND'  ");
        return max_Result;
    }

    public static double average_num(ArrayList results) {
        System.out.println("--- Find average ---");
        Scanner avr = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num_1 = avr.nextDouble();
        System.out.println("Enter second number: ");
        double num_2 = avr.nextDouble();
        double avr_Result = 0;
        avr_Result = (num_1 + num_2) / 2;
        results.add(avr_Result);
        System.out.println(" 'AVERAGE OPERATION COMPLETE'  ");
        return avr_Result;
    }
}