import org.sql2o.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class App {
    public static <Animal> void main(String[] args) { //type “psvm + tab” to autocreate this
        staticFileLocation("/public");

        //get: Animal form
        get("/new1", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animalsform.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new animal form
        post("/animal1", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int id = Integer.parseInt(request.queryParams("id"));

            Animals newIdentity = new Animals(name, id);
            model.put("name", newIdentity.getName());
            model.put("id", newIdentity);
            return new ModelAndView(model, "pass.hbs");
        }, new HandlebarsTemplateEngine());

        get("/nest",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            ArrayList<Animals> pests=Animals.all();
            model.put("pests",pests);
            return new ModelAndView(model,"animals.hbs");
        },new HandlebarsTemplateEngine());



    }
}