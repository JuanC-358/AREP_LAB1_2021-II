package edu.escuelaing.arep.sparkherokulive;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static spark.Spark.*;
import spark.Request;
import spark.Response;


/**/

public class App 
{
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");

        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
        get("/facadealpha", "application/json",(req, res) -> facadeAlpha(req,res));
        
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>HTML Forms</h2>"
                + "<form action=\"/results\">"
                + "  First name:<br>"
                + "  <input type=\"text\" name=\"firstname\" value=\"Mickey\">"
                + "  <br>"
                + "  Last name:<br>"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        return req.queryParams("firstname") + " " +
                req.queryParams("lastname");
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
    
    private static String facadeAlpha(Request req, Response res) {
        res.type("application/json");
        String stock = req.queryParams("st");
        String response = "None";
        HttpStockService stockService =CurrentServiceInstance.getInstance().getService();
        if (stock != null && stock != ""){
            stockService.setStock(stock);
        }
        try {
            response = stockService.TimeSeriesDaily();
        }catch(IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
}