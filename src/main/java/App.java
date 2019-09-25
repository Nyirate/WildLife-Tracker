import org.sql2o.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        get("/nest", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animalsform.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new animal form
        post("/nest", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");


            Animals newIdentity = new Animals(name, age, health);
            newIdentity.save();
            model.put("newIdentity", newIdentity);

            return new ModelAndView(model, "pass.hbs");
        }, new HandlebarsTemplateEngine());

        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Animals> pests=Animals.all();
            model.put("pests",pests);
            return new ModelAndView(model,"animals.hbs");
        },new HandlebarsTemplateEngine());

//get: show sighting form
        get("/yum",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"sightingform.hbs");
        },new HandlebarsTemplateEngine());


        //post: process a sighting form
        post ("/yes",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String rangername = request.queryParams("rangername");
            String location = request.queryParams("location");



            Sighting newSightingIdentity =new Sighting(rangername, location);
            newSightingIdentity.save();
            model.put("rangername",newSightingIdentity.getRangername());
            model.put("location",newSightingIdentity.getLocation());

            return new ModelAndView(model,"pass2.hbs");
        }, new HandlebarsTemplateEngine());


        get("/pass2",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> screw=Sighting.all();
            System.out.println(screw);

            model.put("screw", screw);
            return new ModelAndView(model,"sighting.hbs");
        },new HandlebarsTemplateEngine());

    }
}

