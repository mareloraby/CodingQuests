import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class missingNumber {

    public static void main(String[] args) throws IOException {

        int sum = 0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        for(int i=0; i< line.length;i++){
            sum= sum + Integer.parseInt(line[i]);

        }

        System.out.println(55 - sum);

    }



    }
