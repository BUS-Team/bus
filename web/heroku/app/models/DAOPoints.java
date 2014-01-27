package models;

import java.sql.ResultSet;
import java.util.ArrayList;
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



import play.db.*;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.WS;
import play.mvc.*;
import views.html.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.*;
import akka.util.Convert;



public class DAOPoints {
	public ArrayList<Point> getPoint(final String line) {

		//play.libs.F.Promise<java.util.ArrayList<models.Point>> array = null;
		
		ArrayList<Point> array = new ArrayList<Point>();

		if (line.equals("213") || line.equals("106"))
		{
			/* TODO: Find a way to get these positions. */
		}
		else
		{
			/* Calling the web service to get a specific bus position */
			

			Promise<WS.Response> result = WS.url("http://site.tcgrandelondrina.com.br:8082/soap/buscamapa").setContentType("application/x-www-form-urlencoded").post("idLinha=" + line);
			
            //System.out.println(result.get().asJson());
			String[] arrayOfResponse = result.get().asJson().toString().split("&"); /* Parses response and splits the response per "&" */
        	int index = arrayOfResponse.length - 1; /* Controls the iteration of the result returned by the web service. */

            //System.out.println("Tamanho do vetor: " + index);
        	
            while(index > 0)
        	{
        		try
        		{
        			
						//= = = Debug = = =
        				//System.out.println(line + " " + arrayOfResponse[index-5] + arrayOfResponse[index-3] + arrayOfResponse[index-2]);
        			

        			/* Sets the attributes */
            		Point point = new Point();
            	    point.setLine(Integer.parseInt(line)); /* line */
            	    point.setDirection(arrayOfResponse[index-5]); /* direction */
            	    point.setLat(Float.parseFloat(arrayOfResponse[index-3])); /* lat */
            	    point.setLng(Float.parseFloat(arrayOfResponse[index-2])); /* lng */
            	    array.add(point);
            		index = index - 6; /* Jump for the next position. */
                    //System.out.println("PÓS WHILE = Tamanho do vetor: " + index);
        		}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        		}
        		
        		/*
        			= = = Debug = = =
        			//System.out.println(now + response.asJson().toString());
        		*/
        	}
            index = 0;
		}
        //System.out.println(array.size());
		return array;
	}
}