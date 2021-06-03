import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class rotateLeft {
    public static void main(String[] args) throws IOException {

        //Scanner sc= new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstline = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int len =  Integer.parseInt(firstline[0]);

        int [] arr= new int [len] ;
        int d =   Integer.parseInt(firstline[1]);
        d = len - d;

        for (int i = 0; i< len; i++){
            arr[(i+d)%len] =  Integer.parseInt(arrTemp[i]);
        }

        for (int i =0; i<len; i++){
            if (i==len-1){
                System.out.print(arr[i]);
            } else {
            System.out.print(arr[i]+ " ");}
        }

    }
}