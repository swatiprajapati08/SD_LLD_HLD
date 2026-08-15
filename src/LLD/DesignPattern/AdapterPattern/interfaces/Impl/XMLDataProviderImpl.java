package LLD.DesignPattern.AdapterPattern.interfaces.Impl;

import LLD.DesignPattern.AdapterPattern.interfaces.XMLDataProvider;

public class XMLDataProviderImpl implements XMLDataProvider {
    @Override
    public String getXMLData(String data) {
        // Expect data in "name:id" format (e.g. "Alice:42")
        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String id = data.substring(sep + 1);
        // Build an XML representation
        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>" + id + "</id>"
                + "</user>";
    }
}

