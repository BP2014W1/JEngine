package de.uni_potsdam.hpi.bpt.bp2014.jcore;

import de.uni_potsdam.hpi.bpt.bp2014.jcore.soap.SoapClient;

import javax.xml.soap.SOAPMessage;

public class EventHandler {
    SoapClient soapClient = new SoapClient();

    public Boolean retrieveListofEvents() {
        //TODO: add logik
        try {
            SOAPMessage result = soapClient.createSOAPRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean supscribeEvents(int eventID, int listenerID ) {
        //TODO: add logik
        return true;
    }

}
