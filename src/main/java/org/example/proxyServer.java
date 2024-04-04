package org.example;
import static spark.Spark.*;


public class proxyServer {

    static int COUNT = 1;
    static String URL1 = "ec2-50-17-68-224.compute-1.amazonaws.com:4567/";
    static String URL2 = "ec2-3-89-228-197.compute-1.amazonaws.com:4567/";
    static String lineal = "linealsearch";
    static String binary = "linealsearch";
    public static void main(String... args) {
        port(getPort());


        get("linealsearch", (req, res) -> {
            
            String listNumbersParam = req.queryParams("list");
            String numero = req.queryParams("value");

            String respoString = "";
            if  (COUNT % 2 == 0) { 
                respoString = HttpConnectionExample.main(URL1+lineal+"value=" + numero + "&list=" + listNumbersParam);
            }  else {
                respoString = HttpConnectionExample.main(URL2+lineal+"value=" + numero + "&list=" + listNumbersParam);
            }
            COUNT += 1;
            return respoString;
        });


        get("binarysearch", (req, res) -> {
            String listNumbersParam = req.queryParams("list");
            String numero = req.queryParams("value");
            String respoString = "";
            if  (COUNT % 2 == 0) { 
                respoString = HttpConnectionExample.main(URL1+binary+"value=" + numero + "&list=" + listNumbersParam);
                COUNT += 1;
            }  else {
                respoString = HttpConnectionExample.main(URL1+binary+"value=" + numero + "&list=" + listNumbersParam);
            }
            COUNT += 1;
            return respoString;
        });

    }
    

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
