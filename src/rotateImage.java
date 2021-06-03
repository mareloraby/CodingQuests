public class rotateImage {


    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i< n; i++){
            for(int j=i; j< n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i< n; i++){
            for(int j=0; j< n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }

        printt(matrix);
    }


    static void printt(int[][] mat){
        for(int row =0; row< mat.length; row++){
            for (int e = 0; e < mat[row].length ; e++){
                System.out.print(mat[row][e] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int mat [][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(mat);



    }
}
