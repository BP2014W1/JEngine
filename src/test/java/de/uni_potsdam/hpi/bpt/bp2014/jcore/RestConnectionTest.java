package de.uni_potsdam.hpi.bpt.bp2014.jcore;

import org.easymock.IAnswer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.matcher.RestAssuredMatchers.*;
import com.jayway.restassured.*;
import de.uni_potsdam.hpi.bpt.bp2014.config.Config;

import java.util.LinkedList;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@RunWith(PowerMockRunner.class)
public class RestConnectionTest {

    private ExecutionService executionService = new ExecutionService();
    private HistoryService historyService = new HistoryService();

    String serverURL = Config.jcoreServerUrl;

    private static final String GET_ALL_SCENARIOS = "getAllScenarioIDs";
    private static final String LIST_ALL_SCENARIO_INSTANCES = "listAllScenarioInstancesForScenario";

    @Before
    public void setUp() {
        ExecutionService executionService = PowerMock.createPartialMock(ExecutionService.class,
                GET_ALL_SCENARIOS,
                LIST_ALL_SCENARIO_INSTANCES);
    }

    @Test
    public void testGetScenarios() {

        try {
            PowerMock.expectPrivate(executionService, GET_ALL_SCENARIOS).andAnswer(new IAnswer<LinkedList>() {
                @Override
                public LinkedList answer() throws Throwable {
                    LinkedList ll = new LinkedList();
                    ll.add(1);
                    ll.add(2);
                    ll.add(3);
                    return (ll);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        int scenarioID = 1;
        int newInstanceID =executionService.startNewScenarioInstance(scenarioID);
        String url = serverURL + "jcomparser/scenarios/" + scenarioID +"/instance/" + newInstanceID + "/activityinstance/0/";
        get("/products").then().assertThat().body(matchesJsonSchemaInClasspath("json/products-schema.json"));
    }

    @Test
    public void testGetAllEnabledActivities() {
        int scenarioID = 1;
        int newInstanceID =executionService.startNewScenarioInstance(scenarioID);
        String url = serverURL + "jcomparser/scenarios/" + scenarioID +"/instance/" + newInstanceID + "/activityinstance/0/";
        get("/products").then().assertThat().body(matchesJsonSchemaInClasspath("json/products-schema.json"));
    }
    //create a new instance for our test


    //get("/lotto").then().body("lotto.lottoId", equalTo(5));
    //get("/lotto").then().body("lotto.winners.winnerId", hasItems(23, 54));

    // get("/products").then().assertThat().body(matchesJsonSchemaInClasspath("json/products-schema.json"));
    //given().param("key1", "value1").param("key2", "value2").when().post("/somewhere").then().body(containsString("OK"));

}
