import java.util.List;

public class Tree {
    //Write a function that computes the length of the longest path of consecutive integers in a tree.

    private int root;
    private List<Tree> children;
    int longestPath;

    public Tree(int value, List<Tree> children) {
        root = value;
        children = children;
        longestPath = 0;
    }

    public int longestPath(Tree T, int value) {


        if(T == null)
        {
            return 0;
        }
        if (T.root == value+1) return 1 + longestPath(T.children.get(0),T.root) + longestPath(T.children.get(1),T.root);
        else {

            return  longestPath(T.children.get(0),T.root) + longestPath(T.children.get(1),T.root);
        }




    }

}