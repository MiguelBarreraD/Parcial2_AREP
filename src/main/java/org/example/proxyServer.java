package org.example;

import static spark.Spark.*;

import java.io.IOException;

public class proxyServer {
    private static final String MATH_SERVICE_1_URL = "http://ec2-user@ec2-18-209-43-76.compute-1.amazonaws.com:4567";
    private static final String MATH_SERVICE_2_URL = "http://ec2-user@ec2-54-80-171-222.compute-1.amazonaws.com:4567";
    

    private static int currentServiceIndex = 0;

    public static void main(String[] args) {
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });
        port(getPort());
        staticFiles.location("/public");    

        get("linealsearch", (req, res) -> {
            String listNumbersParam = req.queryParams("list");
            String num = req.queryParams("value");
            return delegateToMathService("linealsearch", listNumbersParam, num);
        });

        get("binarysearch", (req, res) -> {
            String listNumbersParam = req.queryParams("list");
            String num = req.queryParams("value");
            return delegateToMathService("binarysearch", listNumbersParam, num);
        });
    }

    private static String delegateToMathService(String operation, String listNumbersParam, String num) throws IOException {
        String mathServiceUrl;
        if (currentServiceIndex == 0) {
            mathServiceUrl = MATH_SERVICE_1_URL;
        } else {
            mathServiceUrl = MATH_SERVICE_2_URL;
        }

            currentServiceIndex = (currentServiceIndex + 1) % 2;

        String url = mathServiceUrl + "/" + operation + "?list=" + listNumbersParam + "&value=" + num;
        String response = HttpConnectionExample.main(url);
        return response;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;
    }
}
