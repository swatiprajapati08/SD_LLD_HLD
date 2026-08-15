package LLD.DesignPattern.AdapterPattern.interfaces.Impl;

import LLD.DesignPattern.AdapterPattern.interfaces.JsonDataProvider;
import LLD.DesignPattern.AdapterPattern.interfaces.XMLDataProvider;

// 3. Adapter: implements JsonDataProvider by converting XML → JSON
public class Adapter implements JsonDataProvider {

    //'has-a' relationShip
    private XMLDataProvider xmlDataProvider;

    public Adapter(XMLDataProvider xmlDataProvider){
        this.xmlDataProvider = xmlDataProvider;
    }

    @Override //'is-a' relationShip
    public String getJSONData(String data) {
        // 1. Get XML from the adaptee
        String xml = xmlDataProvider.getXMLData(data);

        // 2. Naïvely parse out <name> and <id> values
        int startName = xml.indexOf("<name>") + 6;
        int endName   = xml.indexOf("</name>");
        String name   = xml.substring(startName, endName);

        int startId = xml.indexOf("<id>") + 4;
        int endId   = xml.indexOf("</id>");
        String id    = xml.substring(startId, endId);

        // 3. Build and return JSON
        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";
    }
}
