package LLD.DesignPattern.FactoryDesign;

public class FactoryMethodPattern {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotificationUsingFactory(new SMSNotificationFactory()," -> Hello World!! from factory");

    }
}
/*

Make Factory of SUBCLASS

interface INotificationFactory{
    INotification getInstance();
}

class SMSNotificationFactory implements INotificationFactory{

    @Override
    public INotification getInstance() {
        return new SMSNotification();
    }
}

class EmailNotificationFactory implements INotificationFactory{
    @Override
    public INotification getInstance() {
        return new EmailNotification();
    }
}
 */