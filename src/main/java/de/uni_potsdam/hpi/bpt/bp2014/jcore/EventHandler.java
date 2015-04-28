package de.uni_potsdam.hpi.bpt.bp2014.jcore;

import de.uni_potsdam.hpi.bpt.bp2014.jcore.soap.SoapClient;

import javax.xml.soap.SOAPMessage;

public class EventHandler {
    SoapClient soapClient = new SoapClient();

    public Boolean retrieveListofEventProducer() {
        //TODO: add logik
        try {
            SOAPMessage result = soapClient.createSOAPRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean retrieveListofEventActivities() {
        //TODO: add logik via DB SELECT
        return true;
    }

    public Boolean subscribeEventProducer(int eventActivityID, int listenerID ) {
        //TODO: add logik
        //1. send subscribe call
        //2. store relation between eventActivityID and listenerID in order to map for incoming requests
        return true;
    }

}
