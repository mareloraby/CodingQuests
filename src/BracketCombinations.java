
import java.util.*;
import java.io.*;

/*

Bracket Combinations
Have the function BracketCombinations(num) read num which will be an integer greater than or equal to zero, and return the number of valid combinations that can be formed with num pairs of parentheses. For example, if the input is 3, then the possible combinations of 3 pairs of parenthesis, namely: ()()(), are ()()(), ()(()), (())(), ((())), and (()()). There are 5 total combinations when the input is 3, so your program should return 5.

*/
public class BracketCombinations {

    static int res=0;


    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(')
                balance = balance + 1;
            else
                balance = balance - 1;
            if (balance < 0)
                return false;
        }
        return (balance == 0);
    }

    public static void generateAll(char[] current, int pos) {
        if (pos == current.length) {
            if (valid(current))
                res++;
        } else {
            current[pos] = '(';
            generateAll(current, pos+1);
            current[pos] = ')';
            generateAll(current, pos+1);
        }
    }


    public static int BracketCombinations(int num) {

        char [] current = new char[2*num];
        generateAll(current, 0);
        return res;
    }


    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(BracketCombinations(Integer.parseInt(s.nextLine())));
    }

}

