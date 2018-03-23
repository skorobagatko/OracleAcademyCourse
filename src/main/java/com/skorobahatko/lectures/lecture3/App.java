package com.skorobahatko.lectures.lecture3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) throws IOException {
//        findSubstringsInText(htmlText, "<.*?>").forEach(s -> System.out.println(s + "\n"));
        try {
            try {
                if (1 > 0) {
                    throw new IOException();
                }

            } finally {
                if (true) throw new RuntimeException();
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getSuppressed()));
            System.out.println(e.getCause());
            System.out.println(e.getClass().getSimpleName());
        }

    }

    public static List<String> findSubstringsInText(String text, String regex) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    private static String htmlText = "<meta charset=\"UTF-8\">" +
            "  <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">" +
            "  <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"default\">" +
            "  <meta name=\"mobile-web-app-capable\" content=\"yes\">" +
            "  <meta name=\"HandheldFriendly\" content=\"True\">" +
            "  <meta name=\"MobileOptimized\" content=\"320\">" +
            "  <meta name=\"format-detection\" content=\"telephone=no\">" +
            "  <meta name=\"title\" content=\"Regex101\">" +
            "  <link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\" />" +
            "  <link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"/apple-icon-57x57.png\">" +
            "  <link rel=\"apple-touch-icon\" sizes=\"60x60\" href=\"/apple-icon-60x60.png\">" +
            "  <link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"/apple-icon-72x72.png\">" +
            "  <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"/apple-icon-76x76.png\">\n" +
            "  <link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"/apple-icon-114x114.png\">\n" +
            "  <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"/apple-icon-120x120.png\">\n" +
            "  <link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"/apple-icon-144x144.png\">\n" +
            "  <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"/apple-icon-152x152.png\">\n" +
            "  <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"/apple-icon-180x180.png\">\n" +
            "  <link rel=\"icon\" type=\"image/png\" href=\"/favicon-16x16.png\" sizes=\"16x16\">\n" +
            "  <link rel=\"icon\" type=\"image/png\" href=\"/favicon-32x32.png\" sizes=\"32x32\">\n" +
            "  <link rel=\"icon\" type=\"image/png\" href=\"/favicon-96x96.png\" sizes=\"96x96\">\n" +
            "  <link rel=\"icon\" type=\"image/png\" href=\"/android-icon-192x192.png\" sizes=\"192x192\">\n" +
            "  <meta name=\"viewport\" content=\"width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n" +
            "  <meta name=\"keywords\" content=\"javascript,regex,regular expression,debugger,explainer,helper,tester,match,pcre,php,golang,python,editor\">\n" +
            "  <meta name=\"description\" content=\"Online regex tester, debugger with highlighting for PHP, PCRE, Python, Golang and JavaScript.\">\n" +
            "  <meta name=\"author\" content=\"Firas Dib\">\n" +
            "  <meta property=\"twitter:card\" content=\"summary\">\n" +
            "  <meta property=\"twitter:site\" content=\"@regex101\">\n" +
            "  <meta property=\"twitter:title\" content=\"Regex101 - online regex editor and debugger\">\n" +
            "  <meta property=\"twitter:description\" content=\"Regex101 allows you to create, debug, test and have your expressions explained for PHP, PCRE, Python, Golang and JavaScript. The website also features a community where you can share useful expressions.\">\n" +
            "  <meta property=\"twitter:creator\" content=\"@regex101\">\n" +
            "  <meta property=\"twitter:image\" content=\"//regex101.com/preview.png\">\n" +
            "  <meta property=\"twitter:domain\" content=\"regex101.com\">\n" +
            "  <title>Online regex tester and debugger: PHP, PCRE, Python, Golang and JavaScript</title>";
}
