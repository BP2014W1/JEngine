package de.uni_potsdam.hpi.bpt.bp2014.jcore.rest;

import com.ibatis.common.jdbc.ScriptRunner;
import de.uni_potsdam.hpi.bpt.bp2014.AbstractTest;
import de.uni_potsdam.hpi.bpt.bp2014.database.Connection;
import net.javacrumbs.jsonunit.core.Option;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.junit.Assert.*;

/**
 * This Class extends the {@link de.uni_potsdam.hpi.bpt.bp2014.AbstractTest}
 * to test the RestInterface of the JEngine core.
 * In order to do so it uses the functionality of the
 * {@link org.glassfish.jersey.test.JerseyTest}
 * There are test methods for every possible REST Call.
 * In order to stay independent from existing tests, the
 * database will be set up before and after the execution.
 * Define the database Properties inside the database_connection file.
 */
public class RestInterfaceTest extends AbstractTest {

    /**
     * The base url of the jcore rest interface.
     * Allows us to send requests to the {@link de.uni_potsdam.hpi.bpt.bp2014.jcore.rest.RestInterface}.
     */
    private WebTarget base;

    private static final String DEVELOPMENT_SQL_SEED_FILE = "src/main/resources/JEngineV2.sql";

    /**
     * Sets up the seed file for the test database.
     */
    static {
        TEST_SQL_SEED_FILE = "src/test/resources/JEngineV2RESTTest_new.sql";
    }

    @AfterClass
    public static void resetDatabase() throws IOException, SQLException {
        clearDatabase();
        ScriptRunner runner = new ScriptRunner(Connection.getInstance().connect(), false, false);
        runner.runScript(new FileReader(DEVELOPMENT_SQL_SEED_FILE));
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(de.uni_potsdam.hpi.bpt.bp2014.jcore.rest.RestInterface.class);
    }

    @Before
    public void setUpBase() {
        base = target("v2/");
    }

    /**
     * When you sent a GET to {@link RestInterface#getScenarios(String)}
     * the media type of the response will be JSON.
     */
    @Test
    public void testGetScenarioProducesJson() {
        Response response = base.path("scenario").request().get();
        assertEquals("The Response code of get Scenario was not 200",
                200, response.getStatus());
        assertEquals("Get Scenarios returns a Response with the wrong media Type",
                MediaType.APPLICATION_JSON, response.getMediaType().toString());
    }

    /**
     * When you sent a get to {@link RestInterface#getScenarios(String)}
     * the entity of the response will be a valid JSON array.
     */
    @Test
    public void testGetScenarioProducesValidJsonArray() {
        Response response = base.path("scenario").request().get();
        assertNotEquals("Get scenarios did not respond with a valid JSON Array",
                null, new JSONObject(response.readEntity(String.class)));
    }

    /**
     * When you sent a GET to {@link RestInterface#getScenarios(String)}
     * the returned JSON will contain the latest version of all Scenarios.
     */
    @Test
    public void testGetScenarioContent() {
        Response response = base.path("scenario").request().get();
        assertThat("Get Scenarios did not contain the expected information",
                "{\"ids\":[1,2,3,100,101,103,105,111,113,114,115,116,117,118,134,135,136,138,139,140,141,142,143,144],\"labels\":{\"1\":\"HELLOWORLD\",\"3\":\"EmailTest\",\"2\":\"helloWorld2\",\"100\":\"TestScenario\",\"101\":\"Test Insert Scenario\",\"134\":\"ReiseTestScenario\",\"103\":\"ScenarioTest1\",\"135\":\"ReiseTestScenario\",\"136\":\"TXOR1Scenario\",\"105\":\"TestScenarioTerminationCondition\",\"138\":\"TestEmail1Scenario\",\"139\":\"TestEmail1Scenario\",\"140\":\"TestEmail1Scenario\",\"141\":\"TestEmail2Scenario\",\"142\":\"TestEmail3Scenario\",\"111\":\"Test2_2ReferenceTest\",\"143\":\"TestEmail3Scenario\",\"144\":\"XORTest2Scenario\",\"113\":\"referencetest3_2\",\"114\":\"RT4Scenario\",\"115\":\"TT2Scenario\",\"116\":\"TT2Scenario\",\"117\":\"AT2Scenario\",\"118\":\"AT3Scenario\"}}",
                jsonEquals(response.readEntity(String.class)).when(Option.IGNORING_ARRAY_ORDER));
    }

    /**
     * When you sent a GET to {@link RestInterface#getScenarios(String)} and
     * you use a Filter
     * then the returned JSON will contain the latest version of all Scenarios with
     * a name containing the filterString.
     */
    @Test
    public void testGetScenarioContentWithFilter() {
        Response response = base.path("scenario").queryParam("filter", "HELLO").request().get();
        assertThat("Get Scenarios did not contain the expected information",
                "{\"ids\":[1,2],\"labels\":{\"1\":\"HELLOWORLD\",\"2\":\"helloWorld2\"}}",
                jsonEquals(response.readEntity(String.class)).when(Option.IGNORING_ARRAY_ORDER));
    }

    /**
     * When you send a GET to {@link RestInterface#getScenario(int) with an invalid id
     * a empty JSON with a 404 will be returned.
     */
    @Test
    public void testGetScenarioInvalidId() {
        Response response = base.path("scenario/99999").request().get();
        assertEquals("Get Scenario returns a Response with the wrong media Type",
                MediaType.APPLICATION_JSON, response.getMediaType().toString());
        assertEquals("Get scenario returns a not empty JSON, but the id was invalid",
                404, response.getStatus());
        assertEquals("The content of the invalid request is not an empty JSONObject",
                "{}",
                response.readEntity(String.class));
    }

    /**
     * If you send a GET to {@link RestInterface#getScenario(int)} with an valid id
     * a JSON containing the id, name and modelversion will be returned.
     */
    @Test
    public void testGetScenario() {
        Response response = base.path("scenario/1").request().get();
        String responseEntity = response.readEntity(String.class);
        assertEquals("The Response code of get Scenario was not 200",
                200, response.getStatus());
        assertEquals("Get Scenarios returns a Response with the wrong media Type",
                MediaType.APPLICATION_JSON, response.getMediaType().toString());
        assertNotEquals("Get scenarios did not respond with a valid JSON Array",
                null, new JSONObject(responseEntity));
        assertThat("The content of the valid request is not as expected",
                "{\"id\":1,\"name\":\"HELLOWORLD\",\"modelversion\":0}",
                jsonEquals(responseEntity).when(Option.IGNORING_ARRAY_ORDER));

    }

    /**
     * When you send a GET to {@link RestInterface#getAllEmailTasks(int, String)}
     * the response should be of type json.
     */
    @Test
    public void testGetMailTasksReturnsJson() {
        Response response = base.path("scenario/1/emailtask").request().get();
        assertEquals("The Response code of get all mail tasks was not 200",
                200, response.getStatus());
        assertEquals("Get all mail tasks returns a Response with the wrong media Type",
                MediaType.APPLICATION_JSON, response.getMediaType().toString());
    }

    /**
     * When you send a GET to {@link RestInterface#getAllEmailTasks(int, String)} and
     * the scenario does not contain any mail task an object with no ids will be returned.
     */
    @Test
    public void testGetAllMailTasksIfAbsent() {
        Response response = base.path("scenario/1/emailtask").request().get();
        assertThat("Get all mail Tasks returns not an empty JSON Object when the scenario has no mail tasks",
                "{\"ids\":[]}", jsonEquals(response.readEntity(String.class)));
    }

    /**
     * When you send a GET to {@link RestInterface#getAllEmailTasks(int, String)}
     * the returned JSON Object should be a specified.
     * {"ids":[1,2,...],"labels":{1:"abcd"...}}}
     */
    @Test
    public void testGetAllMailTasksJSONResponse() {
        Response response = base.path("scenario/142/emailtask").request().get();
        assertThat("Get all mail Tasks returns not an empty JSON Object when the scenario has no mail tasks",
                "{\"ids\":[362]}", jsonEquals(response.readEntity(String.class)));
    }

    /**
     * When you send a Get to {@link RestInterface#getAllEmailTasks(int, String)}
     * and the ScenarioID is invalid a 404 will be returned but the media type is still
     * JSON.
     */
    @Test
    public void testGetAllMailTasksMissingScenario() {
        Response response = base.path("scenario/99999/emailtask").request().get();
        assertEquals("The Response code of get all mail tasks was not 404",
                404, response.getStatus());
        assertEquals("Get all mail tasks returns a Response with the wrong media Type",
                MediaType.APPLICATION_JSON, response.getMediaType().toString());
    }


}
