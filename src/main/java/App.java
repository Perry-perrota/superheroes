import java.util.*;
import models.*;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class
App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAllHeroes();
            model.put("heroes", heroes);

            ArrayList<Squad> squads = Squad.getAllSquads();
            model.put("squads", squads);

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
            request.session().attribute("squadName", squadName);
            String cause = request.queryParams("cause");
            int squadSize = Integer.parseInt(request.queryParams("squadSize"));
            Squad squad = new Squad(squadSize, squadName, cause);
            Map<String, Object> model = new HashMap<>();
            model.put("squad", squad);
            return new ModelAndView(model, "newSquad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:heroID/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(req.params(":heroID"));
            Hero deleteHero = Hero.findHeroById(idOfHeroToDelete);
            deleteHero.deleteHero();
            return new ModelAndView(model, "newHero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:squadId/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToDelete = Integer.parseInt(req.params(":squadId"));
            Squad deleteSquad = Squad.findSquadById(idOfSquadToDelete);
            deleteSquad.deleteSquad();
            return new ModelAndView(model, "newSquad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/:squadId/hero/:heroID",(request, response) ->{
            int idOfSquadToAddTo=Integer.parseInt(request.queryParams("squadId"));
            int idOfHeroToAdded=Integer.parseInt(request.queryParams("heroID"));

            Squad squad=Squad.findSquadById(idOfSquadToAddTo);
            Hero hero=Hero.findHeroById(idOfHeroToAdded);

            squad.addHero(hero);

            Map<String,Object> model=new HashMap<>();
            model.put("fullsquad",squad);

            return new ModelAndView(model,"addToSquad.hbs");
        },new HandlebarsTemplateEngine());

    }
}
