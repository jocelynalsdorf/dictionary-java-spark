
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
		
		get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all()); 
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
   	}, new VelocityTemplateEngine());

		get("/words/new", (request, response) -> {
     	HashMap<String, Object> model = new HashMap<String, Object>();
     	model.put("template", "templates/word-form.vtl");
     	return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


		post("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Word newWord = new Word(name);
      model.put("word", newWord);
      //only put .all if you want to return directly from post route to index with no reload/refresh
     // model.put("words", Word.all());
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

		get("/words/:id", (request, response) -> {
	    HashMap<String, Object> model = new HashMap<String, Object>();
	    model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
	    model.put("template", "templates/word.vtl");
	    return new ModelAndView(model, layout);
	  }, new VelocityTemplateEngine());

	  get("/words/:id/definitions/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/word-definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definitions", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      String description = request.queryParams("description");
      Definition newDefinition = new Definition(description);
      word.addDefinition(newDefinition);
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    get("/definition/:id", (request, response) -> {
   		HashMap<String, Object> model = new HashMap<String, Object>();
   		Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
   		model.put("definition", definition);
   		model.put("template", "templates/definition.vtl");
   		return new ModelAndView(model, layout);
 		}, new VelocityTemplateEngine());

	}//end of main
}//end of appclass