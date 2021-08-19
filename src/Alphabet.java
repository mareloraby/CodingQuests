import java.util.ArrayList;

class Alphabet {

    public static Character[] findAlphabet(String[] words) {

        ArrayList<Character> Chars = new ArrayList<>();



        for (int i = 0; i < words.length - 1; i++)
        {
            // Take the current two words and find the first mismatching character
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++)
            {
                // If we find a mismatching character, then add an edge
                // from character of word1 to that of word2
                if (word1.charAt(j) != word2.charAt(j))
                {

                    if (!Chars.contains(word1.charAt(j))){
                        if(!Chars.contains(word2.charAt(j))){
                            Chars.add(word1.charAt(j));
                            Chars.add(word2.charAt(j));
                        }
                        else
                        {
                            Chars.add(Chars.indexOf(word2.charAt(j)), word1.charAt(j) );
                        }
                    }
                    else {
                        if(!Chars.contains(word2.charAt(j))){
                            Chars.add(Chars.indexOf(word1.charAt(j))+1, word2.charAt(j));
                        }
                        else
                        {
                            if (Chars.indexOf(word1.charAt(j)) > Chars.indexOf(word2.charAt(j)) ){
                                return new Character[0];

                            }                        }
                    }

                    break;
                }
            }
        }

        Character[] ans = new Character[Chars.size()];

        System.arraycopy(Chars.toArray(), 0, ans, 0, Chars.size());
        for(int i = 0; i<ans.length;i++){
            System.out.println(ans[i]);
        }
        return ans;



    }

    public static void main(String [] args){

      findAlphabet(new String[]{"aba", "bba", "aaa"})   ;
    }



}