import java.util.HashMap;

public class Main {

    static final HashMap<String, Character> variantsMap = new HashMap<>();

    static {
        variantsMap.put("RR", 'R');
        variantsMap.put("BB", 'B');
        variantsMap.put("GG", 'G');
        variantsMap.put("RB", 'G');
        variantsMap.put("RG", 'B');
        variantsMap.put("GR", 'B');
        variantsMap.put("GB", 'R');
        variantsMap.put("BR", 'G');
        variantsMap.put("BG", 'R');
    }

    public static void main(String[] args) {

        System.out.println(String.format("expect %s - result %s", "B", triangle("B")));
        System.out.println(String.format("expect %s - result %s", "R", triangle("GB")));
        System.out.println(String.format("expect %s - result %s", "R", triangle("RRR")));
        System.out.println(String.format("expect %s - result %s", "B", triangle("RGBG")));
        System.out.println(String.format("expect %s - result %s", "G", triangle("RBRGBRB")));
        System.out.println(String.format("expect %s - result %s", "G", triangle("RBRGBRBGGRRRBGBBBGG")));
    }


    public static char triangle(final String row) {

        if (row.length() == 1) {
            return row.charAt(0);
        }
        char chars[] = row.toCharArray();
        char resultChars[] = getCharArray(chars);

        return resultChars[0];
    }

    public static char[] getCharArray(char chars[]) {
        if (chars.length == 1) return chars;

        char resultChars[] = new char[chars.length - 1];
        for (int i = 0; i < chars.length - 1; i++) {
            resultChars[i] = getCharFromPairs(chars[i], chars[i + 1]);
        }
        return getCharArray(resultChars);
    }

    public static char getCharFromPairs(char one, char two) {

        return variantsMap.get(String.format("%c%c", one, two));

        // Alternative option

        //        if (one == two) {
        //            return one;
        //        }
        //        char result;
        //        char r = 'R';
        //        char g = 'G';
        //        char b = 'B';
        //
        //        if ((one == r && two == g) || (one == g && two == r)) {
        //            result = b;
        //        } else if ((one == g && two == b) || (one == b && two == g)) {
        //            result = r;
        //        } else result = g;
        //
        //        return result;
    }
}