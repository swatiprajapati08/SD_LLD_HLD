package LLD.DesignPattern.AdapterPattern;

import LLD.DesignPattern.AdapterPattern.interfaces.Impl.Adapter;
import LLD.DesignPattern.AdapterPattern.interfaces.Impl.XMLDataProviderImpl;
import LLD.DesignPattern.AdapterPattern.interfaces.JsonDataProvider;
import LLD.DesignPattern.AdapterPattern.interfaces.XMLDataProvider;

public class AdapterPattern {
    public static void main(String[] args) {
        // 1. Create the adaptee
        XMLDataProvider xmlProv = new XMLDataProviderImpl();

        // 2. Make our adapter
        JsonDataProvider adapter = new Adapter(xmlProv);

        // 3. Give it some raw data
        String rawData = "Alice:42";

        // 4. Client prints the JSON
        Client client = new Client();

        client.getReport(adapter, rawData);
    }
}
