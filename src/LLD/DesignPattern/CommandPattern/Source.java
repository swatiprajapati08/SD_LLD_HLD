package LLD.DesignPattern.CommandPattern;

public class Source {

    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();

        remoteController.setCommand(0);
        remoteController.pressButton(0);
        remoteController.pressButton(0);


        remoteController.setCommand(1);
        remoteController.pressButton(1);
        remoteController.pressButton(1);

        // invalid
        remoteController.setCommand(3);
    }
}
