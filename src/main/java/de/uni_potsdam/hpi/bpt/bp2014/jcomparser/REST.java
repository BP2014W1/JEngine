package de.uni_potsdam.hpi.bpt.bp2014.jcomparser;

import com.google.gson.Gson;
import org.xml.sax.SAXException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/***********************************************************************************
*   
*   _________ _______  _        _______ _________ _        _______ 
*   \__    _/(  ____ \( (    /|(  ____ \\__   __/( (    /|(  ____ \
*      )  (  | (    \/|  \  ( || (    \/   ) (   |  \  ( || (    \/
*      |  |  | (__    |   \ | || |         | |   |   \ | || (__    
*      |  |  |  __)   | (\ \) || | ____    | |   | (\ \) ||  __)   
*      |  |  | (      | | \   || | \_  )   | |   | | \   || (      
*   |\_)  )  | (____/\| )  \  || (___) |___) (___| )  \  || (____/\
*   (____/   (_______/|/    )_)(_______)\_______/|/    )_)(_______/
*
*******************************************************************
*
*   Copyright © All Rights Reserved 2014 - 2015
*
*   Please be aware of the License. You may found it in the root directory.
*
************************************************************************************/


/*
As a part of the JComparser we need to provide a REST API in order to manage changes or updates in the JEngine Database.
 */

@Path("JComparser")
public class REST {

	//fire Comparser Execution
    @POST   
    @Path("launch")   
    public void startComparser() throws IOException, SAXException, ParserConfigurationException {
        String $pcm_url = "http://localhost:1205/models/936367220.pm";
        String $processserver = "http://localhost:1205";

        return de.uni_potsdam.hpi.bpt.bp2014.jcomparser.JComparser.main($pcm_url, $processserver);
    }

    @GET    //to show ids and labels of all available scenarios
    @Path("Scenarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showScenarios(){
        LinkedList<Integer> scenarioIDs = executionService.de.uni_potsdam.hpi.bpt.bp2014.jcomparser.JComparser.getAllScenarios();

        if(scenarioIDs.size() == 0) return Response.ok(new String("{empty}"), MediaType.APPLICATION_JSON_TYPE).build();//no scenarios present

        Gson gson = new Gson();
        JsonIntegerList json = new JsonIntegerList(scenarioIDs);
        String jsonRepresentation = gson.toJson(json);

        return Response.ok(jsonRepresentation,MediaType.APPLICATION_JSON).build();

    }
}
