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
        post("/nest", (request, response) -> {
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

//get: show sighting form
        get("/yum",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"sightingform.hbs");
        },new HandlebarsTemplateEngine());


        //post: process a sighting form
        post ("/yes",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name =request.queryParams("id");
            String cause = request.queryParams("rangername");
            int size = Integer.parseInt(request.queryParams("location"));
            String rangername = "";
            int id = 0;
            String location = "";
            Sighting newSightingIdentity =new Sighting(id,rangername,location);
            model.put("id",newSightingIdentity.getId());
            model.put("rangername",newSightingIdentity.getRangername());
            model.put("location",newSightingIdentity.getLocation());

            return new ModelAndView(model,"pass2.hbs");
        }, new HandlebarsTemplateEngine());


        get("/yes",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Sighting> screw=Sighting.all();
            System.out.println(screw);
            model.put("screw", screw);
            return new ModelAndView(model,"sighting.hbs");
        },new HandlebarsTemplateEngine());

    }
}

