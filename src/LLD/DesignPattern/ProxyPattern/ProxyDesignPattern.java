package LLD.DesignPattern.ProxyPattern;

public class ProxyDesignPattern {
    public static void main(String[] args) {
        Proxy googleProxy  = new Proxy(true);
        googleProxy.connect("www.google.com");

        Proxy yahooProxy  = new Proxy(false);
        yahooProxy.connect("www.yahoo.com");
    }
}


interface Internet{
    void connect(String url);
}

class RealObject implements Internet{

    @Override
    public void connect(String url) {
        System.out.println("Connecting to "+url);
    }
}


class Proxy implements Internet{

    private RealObject realObject = new RealObject();
    private boolean isAdmin;

    Proxy(boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    @Override
    public void connect(String url) {

        if(!isAdmin){
            System.out.println("Access Denied");
            return;
        }

        realObject.connect(url);

    }
}