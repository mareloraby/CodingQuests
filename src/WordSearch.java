import java.util.*;

class Dictionary {

    Collection lex;
    public Dictionary(Collection<String> words) {
        lex = words;
    }

    public boolean isWord(String word) {
        return lex.contains(word);
    }

    public boolean isPrefix(String prefix) {
        Iterator<String> iterator = lex.iterator();

        // while loop
        while (iterator.hasNext()) {
            String st = iterator.next();
            if (st.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
}

public class WordSearch {

    static int width;
    static int height;
    static HashSet<String> s;

    static void findWordsUtil(char grid[][], boolean visited[][], int i,
                              int j, String str,Dictionary dictionary)
    {
     // Mark current cell as visited and append current character
        // to str
        visited[i][j] = true;
        str = str + grid[i][j];


        if (dictionary.isWord(str))
            s.add(str);

        if(dictionary.isPrefix(str)) {

            for (int row = i - 1; row <= i + 1 && row < height; row++)
                for (int col = j - 1; col <= j + 1 && col < width; col++){
                    if (row >= 0 && col >= 0 && !visited[row][col]) {

                        findWordsUtil(grid, visited, row, col, str, dictionary);
                    }
                }


        }

        // Erase current character from string and mark visited
        // of current cell as false
        str = "" + str.charAt(str.length() - 1);
        visited[i][j] = false;
    }

    public static HashSet<String> findWords(char[][] grid, Dictionary dictionary) {

        s = new HashSet<String>();
        if (grid.length == 0){
            return new HashSet<>();
        }

         width = grid[0].length;
        height = grid.length;
        boolean visited[][] = new boolean[height][width];

        String str = "";

        // starting with this character
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if (dictionary.isPrefix(grid[i][j]+""))
                    findWordsUtil(grid, visited, i, j, str,dictionary);

        return  s;
    }

}