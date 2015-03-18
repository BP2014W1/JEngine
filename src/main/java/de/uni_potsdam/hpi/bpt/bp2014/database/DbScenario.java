package de.uni_potsdam.hpi.bpt.bp2014.database;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ********************************************************************************
 * <p/>
 * _________ _______  _        _______ _________ _        _______
 * \__    _/(  ____ \( (    /|(  ____ \\__   __/( (    /|(  ____ \
 * )  (  | (    \/|  \  ( || (    \/   ) (   |  \  ( || (    \/
 * |  |  | (__    |   \ | || |         | |   |   \ | || (__
 * |  |  |  __)   | (\ \) || | ____    | |   | (\ \) ||  __)
 * |  |  | (      | | \   || | \_  )   | |   | | \   || (
 * |\_)  )  | (____/\| )  \  || (___) |___) (___| )  \  || (____/\
 * (____/   (_______/|/    )_)(_______)\_______/|/    )_)(_______/
 * <p/>
 * ******************************************************************
 * <p/>
 * Copyright © All Rights Reserved 2014 - 2015
 * <p/>
 * Please be aware of the License. You may found it in the root directory.
 * <p/>
 * **********************************************************************************
 */

/**
 * This class represents the Scenario in the database.
 * It provides the functionality to retrieve all existing scenarios as well as their name.
 */
public class DbScenario extends DbObject {
    /**
     * Returns you all the database ID's of all scenarios stored in the database.
     *
     * @return a list of database ID's of all scenarios.
     */
    public LinkedList<Integer> getScenarioIDs() {
        String sql = "SELECT id FROM scenario";
        return this.executeStatementReturnsListInt(sql, "id");
    }

    /**
     * checks if the scenario is stored in the database.
     *
     * @param scenario_id This is the database ID of a scenario.
     * @return a boolean which indicates if the scenario is present(true) or not(false).
     */
    public Boolean existScenario(int scenario_id) {
        String sql = "SELECT id FROM scenario WHERE id = " + scenario_id;
        return this.executeExistStatement(sql);
    }

    /**
     * This method gives you the corresponding name to a scenario ID.
     *
     * @param id This is the database ID of a scenario.
     * @return the name of the scenario as a String.
     */
    public String getScenarioName(int id) {
        String sql = "SELECT name FROM scenario WHERE id = " + id;
        return this.executeStatementReturnsString(sql, "name");
    }

    /**
     * This method provides access to the default information of a scenario.
     *
     * @return It returns a HashMap of the Database ids and their label.
     */
    public Map<Integer, String> getScenarios() {
        String sql = "SELECT id, name FROM scenario";
        return this.executeStatementReturnsHashMap(sql, "id", "name");
    }

    /**
     * This method provides access to the default information of a scenario.
     * The name of the scenario must contain the filterString.
     *
     * @return It returns a HashMap of the Database ids and their label.
     */
    public Map<Integer, String> getScenariosLike(String filterString) {
        String sql = "SELECT id, name FROM scenario WHERE name LIKE '%" + filterString + "%'";
        return this.executeStatementReturnsHashMap(sql, "id", "name");
    }

    /**
     * Provides information abut one Scenario.
     * The Information consists of the id, name and version.
     */
    public Map<String, Object> getScenarioDetails(int id) {
        String sql = "SELECT id, name, modelversion FROM scenario WHERE id = " + id;
        return this.executeStatementReturnsMapWithKeys(sql, "id", "name", "modelversion");
    }

    /**
     * Creates a Map for the SQL-Result.
     * Each Column will be added as a key and the first result as
     * the result.
     *
     * @param sql  The SQl query to be executed.
     * @param keys The column names.
     * @return A Map of the results.
     */
    private Map<String, Object> executeStatementReturnsMapWithKeys(String sql, String... keys) {
        java.sql.Connection conn = Connection.getInstance().connect();
        ResultSet results = null;
        Map<String, Object> keysValues = new LinkedHashMap<>();
        try {
            results = conn.prepareStatement(sql).executeQuery();
            if (results.next()) {
                for (String key : keys) {
                    keysValues.put(key, results.getObject(key));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                results.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return keysValues;
    }
}
