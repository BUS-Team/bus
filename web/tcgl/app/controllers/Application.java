package controllers;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import play.db.*;
import play.libs.F;
import play.libs.WS;
import play.mvc.*;
import views.html.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.*;
import akka.util.Convert;

public class Application extends Controller
{

	/* Variable declarations */
	private static Connection conn = DB.getConnection("default"); /* Get the database connection from the conf/application.conf */

	/* Default method when localhost is requested. */
    public static Result index()
    {
        return ok(index.render("Your new application is ready."));
    }
  
  	/*
  		Author: Breno Kusunoki
  		Description: This method gets all buses positions and stores them in the database.
  	*/
    public static Result getAllBuses() throws InterruptedException, SQLException, IOException 
    {
    	String busLine; /* This variable represents a specific bus line. */
    	/* Array of bus lines (TODO: Get bus lines automatically.) */
    	int[] arrayOfBusLines = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 121, 200, 201, 206, 208, 209, 211, 213, 217, 220, 221, 223, 224, 225, 250, 301, 302, 303, 304, 305, 307, 308, 309, 310, 311, 312, 313, 314, 315, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 444, 445, 446, 501, 502, 503, 504, 505, 506, 512, 600, 601, 605, 611, 613, 701, 800, 801, 802, 803, 806, 810, 820, 830, 834, 835, 900, 901, 902, 903, 904, 905, 906, 908, 909, 912};
    	for (int i = 0; i < arrayOfBusLines.length; i++)
    	{
    		final int line = arrayOfBusLines[i];
    		busLine = "idLinha=" + arrayOfBusLines[i]; /* Parameter that will be passed for the web-service to get a specific bus position. */
    		if (arrayOfBusLines[i] == 213 || arrayOfBusLines[i] == 106)
    		{
    			/* TODO: Find a way to get these positions. */
    		}
    		else
    		{
    			/* Calling the web service to get a specific bus position */
    			play.libs.WS.url("http://site.tcgrandelondrina.com.br:8082/soap/buscamapa")
				.setContentType("application/x-www-form-urlencoded")                       
				.post(busLine).map(
										new F.Function<WS.Response, Result>() 
										{
							                public Result apply(WS.Response response) throws IOException, SQLException
							                {
							                	
							                	PreparedStatement preparedStatement;
							                	String[] arrayOfResponse = response.asJson().toString().split("&"); /* Parses response and splits the response per "&" */
							                	int index = arrayOfResponse.length - 1; /* Controls the iteration of the result returned by the web service. */
							                	Date date = new Date(); 
							                	Timestamp now = new Timestamp(date.getTime());

							                	while(index > 0)
							                	{
							                		try
							                		{
							                			/*
															= = = Debug = = =
							                				System.out.println(agora.toString() + line + arrayOfResponse[index-4] + arrayOfResponse[index-2] + arrayOfResponse[index-1] + arrayOfResponse[index]);
							                			*/

							                			/* Sets the attributes of the prepared statement and inserts the position on the database. */
								                		preparedStatement = conn.prepareStatement("INSERT INTO POSICOES (datahora, linha, sentido, latitude, longitude, tipo) VALUES (?, ?, ?, ?, ?, ?)");
								                		preparedStatement.setTimestamp(1, now);
								                		preparedStatement.setInt(2, line);
								                		preparedStatement.setString(3, arrayOfResponse[index-5]);
								                		preparedStatement.setFloat(4, Float.parseFloat(arrayOfResponse[index-3]));
								                		preparedStatement.setFloat(5, Float.parseFloat(arrayOfResponse[index-2]));
								                		preparedStatement.setInt(6, 1);
								                		preparedStatement.executeUpdate(); /* Persists on the database. */
								                		index -= 6; /* Jump for the next position. */
							                		}
							                		catch(Exception e)
							                		{
							                			e.printStackTrace();
							                		}
							                		index = 0;
							                		/*
							                			= = = Debug = = =
							                			System.out.println(now + response.asJson().toString());
							                		*/
							                	}
							                	return null;
						                	}
										}
									);
	    	}
	    }
	    return ok(index.render(""));
    }
}
