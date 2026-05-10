package LLD.DesignPattern.AdapterPattern;

import LLD.DesignPattern.AdapterPattern.interfaces.JsonDataProvider;

class Client {
    public void getReport(JsonDataProvider report, String rawData) {
        System.out.println("Processed JSON: "
                + report.getJSONData(rawData));
    }
}