// Data structure for the result.
class Coord {
    int y = 0;
    int x = 0;
};

class Rect {
    Coord topLeft = new Coord();
    Coord bottomRight = new Coord();
};

class Result {
    int sum;
  //  Rect rectangle = new Rect();
};

public class RectangleSums {
    public static Result findLargestSum(int[][] input) {
        Result r = new Result();
        r.sum = 0;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;



        int [] rs = new int [input.length];

        for (int row =0; row < input.length; row++){
            int row_sum = 0;
            for (int i =0; i<input[row].length; i++){
                row_sum = row_sum + input[row][i];

            }

            rs[row] = row_sum;
            if (max_so_far < row_sum)
                max_so_far = row_sum;

        }




        r.sum = max_so_far;
        System.out.println(max_so_far);

        return r;
    }

    public static void main(String [] args){
        int [][] arr = {{1,2},{3,4,5,6},{7,8},{9}};

        Result r = findLargestSum(arr);

    }
}