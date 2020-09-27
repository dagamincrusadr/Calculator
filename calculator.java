import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        ArrayList<String> str = new ArrayList<String>();
        ArrayList<String> A = new ArrayList<String>();
        String[] array = input.split(" ");
        Collections.addAll(str, array);
        int i;
        //checks for parenthesis
        for (i = 0; i < str.size(); i++) {
            if (str.get(i).contains("(")) {
                //adds the equation with parenthesis to a different array
                A.add(str.get(i));
                A.add(str.get(i+1));
                A.add(str.get(i+2));
                //does the operation, and excludes the parenthesis
                if (A.get(i+1).equals("^")) {
                    A.set(i, String.valueOf(Math.pow(Double.valueOf(A.get(i).substring(1)), Double.valueOf(A.get(i+2).substring(0, A.size()-1)))));
                }
                if (A.get(i+1).equals("*")) {
                    A.set(i, String.valueOf(Double.valueOf(A.get(i).substring(1)) * Double.valueOf(A.get(i+2).substring(0, A.size()-1))));
                }
                if (A.get(i+1).equals("/")) {
                    A.set(i, String.valueOf(Double.valueOf(A.get(i).substring(1)) / Double.valueOf(A.get(i+2).substring(0, A.size()-1))));
                }
                if (A.get(i+1).equals("%")) {
                    A.set(i, String.valueOf(Double.valueOf(A.get(i).substring(1)) % Double.valueOf(A.get(i+2).substring(0, A.size()-1))));
                }
                if (A.get(i+1).equals("+")) {
                    A.set(i, String.valueOf(Double.valueOf(A.get(i).substring(1)) + Double.valueOf(A.get(i+2).substring(0, A.size()-2))));
                }
                if (A.get(i+1).equals("-")) {
                    A.set(i, String.valueOf(Double.valueOf(A.get(i).substring(1)) - Double.valueOf(A.get(i+2).substring(0, A.size()-1))));
                }
                //replaces the equation with the parenthesis in the first array with the solution to the part in parenthesis
                str.set(i, A.get(i));
                str.remove(i+1);
                str.remove(i+1);
            }
        }
        //does the normal calculator math in the order of priority (exponents, then mult, division, and modulus)
        for (i = 1; i < str.size();) {
            System.out.println(str.size());
            if (1 >= str.size()) {
                System.out.println(str.get(0));
                return;
            }
            if (str.get(i).equals("^")) {
                str.set(i-1, String.valueOf(Math.pow(Double.valueOf(str.get(i-1)), Double.valueOf(str.get(i+1)))));
                str.remove(i);
                str.remove(i);
            }
            if (1 >= str.size()) {
                System.out.println(str.get(0));
                return;
            }
            if (i == str.size()) {
                i = 1;
            }
            if (str.get(i).equals("*")) {
                str.set(i-1, String.valueOf(Double.valueOf(str.get(i-1)) * Double.valueOf(str.get(i+1))));
                str.remove(i);
                str.remove(i);
            }
            if (1 >= str.size()) {
                System.out.println(str.get(0));
                return;
            }
            if (i == str.size()) {
                i = 1;
            }
            if (str.get(i).equals("/")) {
                str.set(i-1, String.valueOf(Double.valueOf(str.get(i-1)) / Double.valueOf(str.get(i+1))));
                str.remove(i);
                str.remove(i);
            }
            if (1 >= str.size()) {
                System.out.println(str.get(0));
                return;
            }  
            if (i == str.size()) {
                i = 1;
            }
            if (str.get(i).equals("%")) {
                str.set(i-1, String.valueOf(Double.valueOf(str.get(i-1)) % Double.valueOf(str.get(i+1))));
                str.remove(i);
                str.remove(i);
            }
            else if (!str.get(1).equals("*") && !str.get(1).equals("/") && !str.get(1).equals("^")) {
                i+=2;
            }
        }
        //does the addition and subtraction
        for (i = 1; i < str.size(); i++) {
            if (str.get(i).equals("+")) {
                str.set(i-1, String.valueOf(Double.valueOf(str.get(i-1)) + Double.valueOf(str.get(i+1))));
                str.remove(i);
                str.remove(i);
            }
            if (1 >= str.size()) {
                System.out.println(str.get(0));
                return;
            }
            if (i == str.size()) {
                i = 1;
            }
            if (str.get(i).equals("-")) {
                str.set(i-1, String.valueOf(Double.valueOf(str.get(i-1)) - Double.valueOf(str.get(i+1))));
                str.remove(i);
                str.remove(i);
            }
            else if (!str.get(1).equals("+")) {
                i+=2;
            }
            if (1 >= str.size()) {
            	System.out.println(str.get(0));
            	return;
            }
        }
    }
}