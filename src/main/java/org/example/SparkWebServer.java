package org.example;

import static spark.Spark.*;

import java.util.Arrays;

public class SparkWebServer {

    public static void main(String... args) {

        staticFiles.location("/public");
        port(getPort());

        get("linealsearch", (req, res) -> {
            String listNumbersParam = req.queryParams("list");
            String[] listNumbers = listNumbersParam.split(",");

            String num = req.queryParams("value");
            System.out.println("listnumbers: " + listNumbers);
            System.out.println("num : " + num);
            int positionResponse = Calculator.LinealSearch(listNumbers, num);
            String response = "{'operation': 'linearsearch','inputlist': " + listNumbersParam + ",'value': " + num
                    + "  'output':  " + positionResponse + "}";
            return response;
        });

        get("binarysearch", (req, res) -> {
            String listNumbersParam = req.queryParams("list");
            String[] listNumbersStrings = listNumbersParam.split(",");
            int[] listNumbers = new int[listNumbersStrings.length];

            for (int i = 0; i < listNumbersStrings.length; i++) {
                listNumbers[i] = Integer.parseInt(listNumbersStrings[i]);
            }

            String num = req.queryParams("value");
            int numInt = Integer.parseInt(num); 

            System.out.println("listnumbers: " + Arrays.toString(listNumbers));
            System.out.println("num : " + numInt);
            int positionResponse = Calculator.BinarySearch(listNumbers, numInt);
            String response = "{'operation': 'binarysearch','inputlist': " + listNumbersParam + ",'value': " + numInt
                    + "  'output':  " + positionResponse + "}";
            return response;
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}