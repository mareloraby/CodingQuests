import java.lang.constant.Constable;

class NumberSpeller {


    public static String convert(int d, String suffix){
        String[] single = new String[] {
                "", "one", "two",   "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        String[] teens = new String[] {
                "ten",      "eleven",  "twelve",
                "thirteen",  "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"
        };


        String[] tens = new String[] {
                "",      "",      "twenty",  "thirty", "forty",
                "fifty", "sixty", "seventy", "eighty", "ninety"
        };


        if (d == 0) {
            return "";
        }
        if ((d+"").length() == 1){
            return single[d]  + " " + suffix;
        }
        if ((d+"").length() == 2){
            if (d>19){
                if ( d%10 ==0){
                    return (tens[d/10]  + " " + suffix);
                }
                else return (tens[d/10] +" " + single[d%10] + " " + suffix);

            }
            else
                return (teens[d%10] + " " + suffix);
        }

        return "";
    }

    public static String spellNumber(long num) {


        String[] tenpowers = new String[] {
                "",      "",      "hundred",  "thousand", "million", "trillion",
                "Quadrillion", "Quintillion"
        };



        StringBuilder res = new StringBuilder();

        String number = num+"";
        if (number.length()==0) return "zero";
        if (number.length() <= 2) {
            if (num == 0) return "zero";
            else
            res.append(convert(Math.toIntExact(num),""));
        }

        else{

            res.append(convert((Math.toIntExact(num / 1000000000000000000L) % 100), "quintillion "));

            res.append(convert((Math.toIntExact(num / 100000000000000000L) % 10), "hundred "));

            res.append(convert((Math.toIntExact(num / 1000000000000000L) % 100), "quadrillion "));

            res.append(convert((Math.toIntExact(num / 10000000000000L) % 10), "hundred "));

            res.append(convert((Math.toIntExact(num / 1000000000000L) % 100), "trillion "));

            res.append(convert((Math.toIntExact(num / 100000000000L) % 10), "hundred "));

            res.append(convert((Math.toIntExact(num / 1000000000 % 100)), "billion "));

            res.append(convert((Math.toIntExact(num / 100000000 % 10)), "hundred "));

            res.append(convert((Math.toIntExact(num / 1000000 % 100)), "million "));

            res.append(convert((Math.toIntExact(num / 100000 % 10)), "hundred "));

            res.append(convert((Math.toIntExact(num / 1000 % 100)), "thousand "));

            res.append(convert((Math.toIntExact(num / 100 % 10)),"hundred "));


            res.append(convert((Math.toIntExact(num % 100)),""));


        }



        return res.toString().trim();




    }

    public static void main(String [] args){

        System.out.println(spellNumber(900000));
    }



}