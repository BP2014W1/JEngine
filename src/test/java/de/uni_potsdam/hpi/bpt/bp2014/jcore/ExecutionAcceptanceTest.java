package de.uni_potsdam.hpi.bpt.bp2014.jcore;

import de.uni_potsdam.hpi.bpt.bp2014.database.DbActivityInstance;
import de.uni_potsdam.hpi.bpt.bp2014.database.DbScenarioInstance;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by jaspar.mang on 02.02.15.
 */
public class ExecutionAcceptanceTest {

    //test AND
    @Test
    public void testScenario2() {
        System.out.println("\n ------------------ test Scenario 2 ------------------\n");
        int activity1 = 103;
        int activity2 = 104;
        ExecutionService executionService = new ExecutionService();
        int scenarioInstance = executionService.startNewScenarioInstance(2);
        System.out.println("Start Scenario 2");
        System.out.println("enabled Activities: "+executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());
        assertArrayEquals(new Integer[]{activity1, activity2}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());

        //do activity 1
        System.out.println("do activity " + activity1);
        executionService.beginActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{activity2}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{activity2}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 2
        System.out.println("do activity "+activity2);
        executionService.beginActivity(scenarioInstance, activity2);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity2);
        assertArrayEquals(new Integer[]{activity1, activity2}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 2
        System.out.println("do activity "+activity2);
        executionService.beginActivity(scenarioInstance, activity2);
        assertArrayEquals(new Integer[]{activity1}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity2);
        assertArrayEquals(new Integer[]{activity1}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        System.out.println("--- restart Service ---");
        executionService = null;
        executionService = new ExecutionService();
        executionService.openExistingScenarioInstance(2, scenarioInstance);

        assertArrayEquals(new Integer[]{activity1}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 1
        System.out.println("do activity " + activity1);
        executionService.beginActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{activity1, activity2}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

    }

    //test DataObjects
    @Test
    public void testScenario1() {
        System.out.println("\n ------------------ test Scenario 1 ------------------\n");
        ExecutionService executionService = new ExecutionService();
        int scenarioInstance = executionService.startNewScenarioInstance(1);
        int activity1 = 2;
        int activity2 = 5;
        int activity3 = 6;
        int activity4 = 4;
        int activity5 = 10;
        int activity6 = 16;

        System.out.println("Start Scenario 1");
        System.out.println("enabled Activities: "+executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());
        assertArrayEquals(new Integer[]{activity1, activity6}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());

        //do activity 1
        System.out.println("do activity " + activity1);
        executionService.beginActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{activity6}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{activity6, activity4, activity2}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 2
        System.out.println("do activity " + activity2);
        executionService.beginActivity(scenarioInstance, activity2);
        System.out.println("--- restart Service ---");
        executionService = null;
        executionService = new ExecutionService();
        executionService.openExistingScenarioInstance(1, scenarioInstance);
        assertArrayEquals(new Integer[]{activity4, activity6}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity2);
        System.out.println("--- restart Service ---");
        executionService = null;
        executionService = new ExecutionService();
        executionService.openExistingScenarioInstance(1, scenarioInstance);
        assertArrayEquals(new Integer[]{activity4, activity5, activity6}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        System.out.println("--- restart Service ---");
        executionService = null;
        executionService = new ExecutionService();
        executionService.openExistingScenarioInstance(1, scenarioInstance);
        assertArrayEquals(new Integer[]{activity4, activity5, activity6}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 4
        System.out.println("do activity " + activity4);
        executionService.beginActivity(scenarioInstance, activity4);
        System.out.println("--- restart Service ---");
        executionService = null;
        executionService = new ExecutionService();
        executionService.openExistingScenarioInstance(1, scenarioInstance);
        assertArrayEquals(new Integer[]{ activity6}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity4);
        assertArrayEquals(new Integer[]{activity6, activity3}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 3
        System.out.println("do activity " + activity3);
        executionService.beginActivity(scenarioInstance, activity3);
        assertArrayEquals(new Integer[]{activity6}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity3);
        assertArrayEquals(new Integer[]{activity6}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

    }

    //test Termination Condition
    @Test
    public void testScenario105() {
        System.out.println("\n ------------------ test Scenario 105 ------------------\n");
        ExecutionService executionService = new ExecutionService();
        int scenarioInstance = executionService.startNewScenarioInstance(105);
        int activity1 = 125;
        int activity2 = 126;
        int activity3 = 128;
        int activity4 = 130;

        System.out.println("Start Scenario 105");
        System.out.println("enabled Activities: "+executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());
        assertArrayEquals(new Integer[]{activity1}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());

        //do activity 1
        System.out.println("do activity " + activity1);
        executionService.beginActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{activity4, activity2}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 2
        System.out.println("do activity " + activity2);
        executionService.beginActivity(scenarioInstance, activity2);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity2);
        assertArrayEquals(new Integer[]{activity3}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 3
        System.out.println("do activity " + activity3);
        executionService.beginActivity(scenarioInstance, activity3);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity3);
        assertArrayEquals(new Integer[]{activity1}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 1
        System.out.println("do activity " + activity1);
        executionService.beginActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{activity4, activity2}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //do activity 4
        System.out.println("do activity " + activity4);
        executionService.beginActivity(scenarioInstance, activity4);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity4);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());

        //check termination in database
        DbScenarioInstance dbScenarioInstance = new DbScenarioInstance();
        assertEquals(1, dbScenarioInstance.getTerminated(scenarioInstance));
    }

    //test References1
    @Test
    public void testScenario111() {
        System.out.println("\n ------------------ test Scenario 111 ------------------\n");
        DbActivityInstance dbActivityInstance = new DbActivityInstance();
        ExecutionService executionService = new ExecutionService();
        int scenarioInstance = executionService.startNewScenarioInstance(111);
        int activity1 = 183;
        int activity2 = 184;
        int activity3 = 191;
        int activity4 = 193;
        int activity5 = 187;
        int activity6 = 189;

        System.out.println("Start Scenario 111");
        System.out.println("enabled Activities: "+executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());
        assertArrayEquals(new Integer[]{activity1}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());

        //do activity 1
        System.out.println("do activity " + activity1);
        executionService.beginActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        executionService.terminateActivity(scenarioInstance, activity1);
        assertArrayEquals(new Integer[]{activity3, activity2}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());


        int activity3instance_id = executionService.getScenarioInstance(scenarioInstance).getEnabledControlNodeInstances().getFirst().getControlNodeInstance_id();
        int activity2instance_id = executionService.getScenarioInstance(scenarioInstance).getEnabledControlNodeInstances().get(1).getControlNodeInstance_id();


        //do activity 2
        System.out.println("do activity " + activity2);
        executionService.beginActivity(scenarioInstance, activity2);
        assertArrayEquals(new Integer[]{}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        assertEquals("referentialRunning", dbActivityInstance.getState(activity3instance_id));
        executionService.terminateActivity(scenarioInstance, activity2);
        assertArrayEquals(new Integer[]{activity6, activity4, activity5}, ((LinkedList<Integer>) executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance)).toArray());
        System.out.println("enabled Activities: " + executionService.getEnabledActivitiesIDsForScenarioInstance(scenarioInstance).toString());


        assertEquals("terminated", dbActivityInstance.getState(activity2instance_id));
        assertEquals("terminated", dbActivityInstance.getState(activity3instance_id));
    }

}