package LLD.DesignPattern.FactoryDesign;

/*
Simple Factory: One factory creates many products using conditional logic.
Factory Method: Each product has its own factory, and the client (or DI container) decides which factory to use.
 */

public class SimpleFactoryPattern {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification("email"," -> Hello World!!");

        notificationService.sendNotificationUsingFactory(new SMSNotificationFactory()," -> Hello World!! from factory");

    }
}

interface INotification{
    void send(String message);
}

class SMSNotification implements INotification{

    @Override
    public void send(String message) {
        System.out.println("SMS notification"+message);
    }
}

class EmailNotification implements INotification{

    @Override
    public void send(String message) {
        System.out.println("Email notification"+message);
    }
}

/*
NotificationService have to take care of object creation which is not this class job,
 */
class NotificationService{

    // ISSUE fixed with NotificationFactory which will take care of object
//    void sendNotification(String type,String message){
//        INotification notification = null;
//        if("SMS".equalsIgnoreCase(type)) {
//            notification = new SMSNotification();
//        } else if ("EMAIL".equalsIgnoreCase(type)) {
//            notification = new EmailNotification();
//        }else {
//            notification = new SMSNotification();
//        }
//        notification.send(message);
//    }

    void sendNotification(String type,String message){
        INotification notification = NotificationFactory.getInstance(type);
        notification.send(message);
    }


    // using NotificationFactory

    void sendNotificationUsingFactory(INotificationFactory factory,String message){
        INotification notification = factory.getInstance();
        notification.send(message);
    }
}

/*
ISSUE:
Breaking Open close principle as for new object need to modify the NotificationFactory class
Better way of using Interface(NotificationFactory) implements by subclass
 */
class NotificationFactory{
    static INotification getInstance(String type){
        INotification notification = null;
        if("SMS".equalsIgnoreCase(type)) {
            notification = new SMSNotification();
        } else if ("EMAIL".equalsIgnoreCase(type)) {
            notification = new EmailNotification();
        }else {
            notification = new SMSNotification();
        }
        return notification;
    }
    /*
    Now I cant use here As somewhere I need to define which object I need if I use here same PROBLEM
   Client need to call Directly and tell which factory they want
     */
}

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