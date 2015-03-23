package de.uni_potsdam.hpi.bpt.bp2014.jconfiguration.rest;

import de.uni_potsdam.hpi.bpt.bp2014.database.DbEmailConfiguration;
import de.uni_potsdam.hpi.bpt.bp2014.database.DbScenario;
import de.uni_potsdam.hpi.bpt.bp2014.util.JsonUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is the rest interface for the JEngine configuration.
 * It holds methods to read and set the email template configurations.
 */
@Path("config/v1")
public class RestInterface {

    /**
     * Updates the email configuration for a specified task.
     * The Task is specified by the email Task ID and the new
     * configuration will submitted as a JSON-Object.
     *
     * @param emailTaskID The ControlNode id of the email task.
     * @param input       The new configuration.
     * @return A Response 202 (ACCEPTED) if the update was successful.
     * A 404 (NOT_FOUND) if the mail task could not be found.
     */
    @POST
    @Path("emailtask/{emailtaskID}/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmailConfiguration(
            @PathParam("emailtaskID") int emailTaskID,
            final EmailConfigJaxBean input) {
        DbEmailConfiguration dbEmailConfiguration = new DbEmailConfiguration();
        int result = dbEmailConfiguration.setEmailConfiguration(emailTaskID,
                input.receiver, input.subject, input.content);
        return Response.status(
                result > 0 ? Response.Status.ACCEPTED : Response.Status.NOT_ACCEPTABLE)
                .build();
    }



    /**
     * This method provides information about all email Tasks inside
     * a given scenario.
     * The information consists of the id and the label.
     * A Json Object will be returned with an array of ids and a Map
     * from ids to labels.
     *
     * @param scenarioID   The ID of the scenario, its mail tasks will be returned.
     * @param filterString A Filter String, only mail tasks with a label containing
     *                     this filter String will be returned.
     * @return The JSON Object with ids and labels.
     */
    @GET
    @Path("scenario/{scenarioID}/emailtask")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmailTasks(
            @PathParam("scenarioID") int scenarioID,
            @QueryParam("filter") String filterString) {
        DbScenario scenario = new DbScenario();
        DbEmailConfiguration mail = new DbEmailConfiguration();
        if (!scenario.existScenario(scenarioID)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .type(MediaType.APPLICATION_JSON)
                    .entity("{}")
                    .build();
        }
        String jsonRepresentation = JsonUtil.JsonWrapperLinkedList(mail.getAllEmailTasksForScenario(scenarioID));
        return Response.ok(jsonRepresentation, MediaType.APPLICATION_JSON).build();
    }

    /**
     * This method provides information about an email Task.
     * It will return a JSON-Object with information about the mail
     * configuration.
     * A Configuration contains a receiver, a subject and a content.
     * A Mail task is specified by:
     *
     * @param scenarioID The ID of the scenario model.
     * @param mailTaskID The control node ID of the mail Task.
     * @return Returns a 404 if the mail Task or scenario does not exist
     * and a 200 (OK) with a JSON-Object if the emailTask was found.
     */
    @GET
    @Path("scenario/{scenarioID}/emailtask/{emailTaskID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmailTaskConfiguration(
            @PathParam("scenarioID") int scenarioID,
            @PathParam("emailTaskID") int mailTaskID) {
        DbScenario scenario = new DbScenario();
        DbEmailConfiguration mail = new DbEmailConfiguration();
        EmailConfigJaxBean mailConfig = new EmailConfigJaxBean();
        mailConfig.receiver = mail.getReceiverEmailAddress(mailTaskID);
        if (!scenario.existScenario(scenarioID) || mailConfig.receiver.equals("")) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .type(MediaType.APPLICATION_JSON)
                    .entity("{}")
                    .build();
        }
        mailConfig.content = mail.getMessage(mailTaskID);
        mailConfig.subject = mail.getSubject(mailTaskID);
        return Response.ok(mailConfig, MediaType.APPLICATION_JSON).build();
    }

    /**
     * This is a data class for the email configuration.
     * It is used by Jersey to deserialize JSON.
     * Also it can be used for tests to provide the correct contents.
     * This class in particular is used by the POST for the email configuration.
     * See the {@link #updateEmailConfiguration(int, EmailConfigJaxBean)}
     * updateEmailConfiguration} method for more information.
     */
    @XmlRootElement
    public static class EmailConfigJaxBean {
        /**
         * The receiver of the email.
         * coded as an valid email address (as String)
         */
        public String receiver;
        /**
         * The subject of the email.
         * Could be any String but null.
         */
        public String subject;
        /**
         * The content of the email.
         * Could be any String but null.
         */
        public String content;
    }
}