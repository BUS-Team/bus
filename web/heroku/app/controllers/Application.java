package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;                     
import play.cache.Cache;
import play.libs.Json;
import views.html.*;
import models.*;
import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(main.render());
    }

    @BodyParser.Of(play.mvc.BodyParser.Json.class)
    public static Result getLine(String line) {
    	DAOPoints pointsDAO = new DAOPoints();
    	System.out.println(line);
    	return ok(Json.toJson(pointsDAO.getPoint(line)));
    	//return TODO;
    }
}
