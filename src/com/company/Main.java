package com.company;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
    System.out.println(sumOfUrl("http://erdani.com/tdpl/hamlet.txt"));

        // write your code here
    }
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
    public static int sumOfUrl(final String url) {
        int sum = 0;
        String words = urlToString(url);
        int count = 0;
        while (count < words.length()) {
            if (!words.substring(count, count + 1).equals(" ")) {
                sum++;
                while (!words.substring(count, count + 1).equals(" ")) {
                    count++;
                    if (count == words.length()) {
                        break;
                    }
                }
            }
            count++;
        }
        return sum;
    }


}
