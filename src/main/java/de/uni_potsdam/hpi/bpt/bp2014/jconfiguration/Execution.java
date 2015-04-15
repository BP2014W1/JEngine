package de.uni_potsdam.hpi.bpt.bp2014.jconfiguration;

import java.util.List;

/**
 * This class executes configurations.
 */
public class Execution {

    /**
     * This method marks the scenario as deleted as far as there are no running instances thereof.
     *
     * @param scenarioID DatabaseID of the scenario that is supposed to get marked as deleted
     * @throws Exception Running instances of the scenario exist.
     */
    public void deleteScenario (int scenarioID) throws Exception{
        DbConfigurationConnection conn = new DbConfigurationConnection();
        List<Integer> runningInstances = conn.getRunningScenarioInstances(scenarioID);
        if (runningInstances.size() > 0) {
            throw new Exception("Scenario can't be deleted as there are still running scenarioInstances");
        } else {
            conn.deleteScenario(scenarioID);
        }
    }
}
