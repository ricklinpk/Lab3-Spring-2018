package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
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
        // write your code here
        int count = 0;
        String target = "prince";
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt").toLowerCase();
        while (text.contains(target)) {
            count++;
            text = text.substring(text.indexOf(target)+target.length());
        } System.out.println("Prince occurs "+count+" times.");
    }
}
