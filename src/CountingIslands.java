public class CountingIslands {



    public void neighbours(boolean [][] g, boolean [][] documented,int r, int c){

        documented[r][c] = true;

        if (g[r][c]) {
            if (c<documented[0].length-1 && !documented[r][c+1]) neighbours(g, documented, r, c+1);
            if (c>0 && !documented[r][c-1]) neighbours(g, documented, r, c-1);
            if (r<documented.length-1 && !documented[r+1][c])neighbours(g, documented, r+1, c);
            if (r>0 && !documented[r-1][c] )neighbours(g, documented, r-1, c);

        }
    }

    public int countIslands(boolean[][] grid) {

        if (grid.length==0 ){
            return 0;
        }
        boolean [][] documented = new boolean[grid.length][grid[0].length];
        int num = 0;
        for (int r = 0; r< grid.length; r++){
            for (int c = 0; c<grid[r].length; c++) {

                boolean block = grid[r][c];

                if (block && documented[r][c] == false) {
                        neighbours(grid,documented,r,c);
                        num++;
                    }
            }
        }

        return num;
    }


    public static void main(String[] args) {
        boolean [][] arr = {
                {false,true,false,true},
                {true,true,false,false},{false,false,true,false},{false,false,true,false}


        };
        CountingIslands cis = new CountingIslands();

        System.out.println(cis.countIslands(arr));
    }
}