import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Susie {

    /**

     * Retrieve contents from a URL and return them as a string.

     *

     * @param url url to retrieve contents from

     * @return the contents from the url as a string, or an empty string on error

     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] args) {
    String str = urlToString("http://erdani.com/tdpl/hamlet.txt");
    System.out.println(str);
    System.out.println(countWords(str));
    }
    public static int countWords(String s){

    int wordCount = 0;

    boolean word = false;
    int endOfLine = s.length() - 1;

    for (int i = 0; i < s.length(); i++) {
        if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
            word = true;
        } else if (!Character.isLetter(s.charAt(i)) && word) {
            wordCount++;
            word = false;
        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
            wordCount++;
        }
    }
    return wordCount;
     }

}

