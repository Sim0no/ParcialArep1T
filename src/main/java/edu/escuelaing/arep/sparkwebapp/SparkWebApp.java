
package edu.escuelaing.arep.sparkwebapp;

import java.io.IOException;
import java.util.ArrayList;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class SparkWebApp {
    public static void main(String[] args) throws IOException {
        port(getPort());     
        get("/input", (req, res) -> inputData(req, res));
        get("/results", (req, res) -> results(req, res));
        post("/info", (request, response) -> {
            Todo tarea = new Todo(request.body());
            String str= tarea.sort();
            LinkedList<Double> lista = tarea.getArray();
            return "{\"Lista Ordenada\":" +str + ", \"Sumatoria\":" + tarea.suma(lista) +", \"Promedio\":" + tarea.mean(lista) + "}";


        });
    }
    
 
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
            }
        return 4567; //returns default port if heroku-port isn't set  (i.e. on localhost)
            }
    
    private static String inputData(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Ingrese el arreglo separado por comas</h2>"
                + "<form action=\"/results\">"
                + "  lista:<br>"
                + "  <input type=\"text\" name=\"lista\" value=>"
                + "  <br>"
                + "  <br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
     }
    private static String results(Request req, Response res) {
        Todo a= new Todo(req.queryParams("lista"));
        //System.out.println(a.sort());
        String pageContent
                 = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>RESULTADO</h2>"
                + "<table class =\"egt\">"
                + "<tr>"
                + "<td>Lista ordenada</td>"
                + "<td>Sumatoria Lista</td>"
                + "<td>Promedio Lista</td>"
                + "</tr>"
                + "<tr>"
                + "<td>"+a.sort()+"</td>"
                + "<td>"+a.suma(a.getArray())+"</td>"
                + "<td>"+a.mean(a.getArray())+"</td>"
                + "</tr>"
                + "</table>"
                + "</body>"
                + "</html>"
                ; 
        return pageContent ;
    }
    
}
        
            
