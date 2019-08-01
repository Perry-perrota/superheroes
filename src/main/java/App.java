import java.util.*;
import models.*;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class
App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        post("/hero/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            String strength = request.queryParams("strength");
            String weakness = request.queryParams("weakness");
            int age = Integer.parseInt(request.queryParams("age"));

            Hero hero = new Hero(name, strength, weakness, age);

            model.put("hero", hero);

            return modelAndView(model, "newHero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAllSquads();
            model.put("squads", squads);
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads/new", (request, response) -> {
            String squadName = request.queryParams("squadName");
            request.session().attribute("squadName",squadName);
            String cause = request.queryParams("cause");
            int squadSize = Integer.parseInt(request.queryParams("squadSize"));
            Squad squad = new Squad(squadName, cause, squadSize);
            Map<String, Object> model = new HashMap<>();
            model.put("squad", squad);
            return new ModelAndView(model, "newSquad.hbs");
        }, new HandlebarsTemplateEngine());
