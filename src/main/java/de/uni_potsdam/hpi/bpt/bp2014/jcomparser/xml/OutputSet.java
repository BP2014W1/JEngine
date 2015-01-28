package de.uni_potsdam.hpi.bpt.bp2014.jcomparser.xml;

import de.uni_potsdam.hpi.bpt.bp2014.jcomparser.Connector;

import java.util.LinkedList;
import java.util.List;

public class OutputSet implements IPersistable {
    private List<Edge> associations;
    private List<Node> outputs;
    // The task which has the input set
    private Node producer;
    private int databaseId;

    public static OutputSet createOutputSetForTaskAndEdges(Node task, List<Edge> edges) {
        OutputSet instance = new OutputSet();
        instance.associations = new LinkedList<Edge>();
        instance.outputs = new LinkedList<Node>();
        instance.producer = task;
        for (Edge edge : edges) {
            if (edge.getTargetNodeId() == instance.producer.getId()) {
                instance.associations.add(edge);
                instance.outputs.add(edge.getSource());
            }
        }
        if (instance.outputs.isEmpty()) {
            return null;
        }
        return instance;
    }

    @Override
    public int writeToDatabase() {
        Connector connector = new Connector();
        databaseId = connector.insertDataSetIntoDatabase(false);
        updateEdges();
        return databaseId;
    }

    private void updateEdges() {
        for (Edge edge : associations) {
            edge.setSetId(databaseId);
        }
    }
}
