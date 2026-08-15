package LLD.DesignPattern.ChainOfResponsibilityPattern;

public class LoggingCORPattern {
    public static void main(String[] args) {
        Level5 level5 = new Level5(null);
        Level4 level4 = new Level4(level5);
        Level3 level3 = new Level3(level4);
        Level2 level2 = new Level2(level3);
        Level1 level1 = new Level1(level2);

        Log message = new Log("Message 1 received",LogLevel.DEBUG);
        level1.handle(message);

        System.out.println("New message......");
        message = new Log("Message 2 received",LogLevel.ERROR);
        level1.handle(message);


        System.out.println("New message......");
        message = new Log("Message 3 received",LogLevel.FATAL);
        level1.handle(message);

    }
}


enum LogLevel {
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    FATAL(5);

    private final int severity;

    LogLevel(int severity) {
        this.severity = severity;
    }

    public int getSeverity() {
        return severity;
    }
}

class Log{
    String message;
    LogLevel level;


    public Log(String message, LogLevel level) {
        this.message = message;
        this.level = level;
    }
}


abstract class Handler{
    private Handler nextHandler;

    Handler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    abstract boolean canHandle(Log log);
    abstract void handle(Log log);

    // off loading to next Level
    void sendToNextHandler(Log log){
        nextHandler.handle(log);
    }
}


class Level1 extends Handler{
    Level1(Handler nextHandler){
        super(nextHandler);
    }

    @Override
    boolean canHandle(Log log) {
        return log.level.getSeverity() <= LogLevel.DEBUG.getSeverity();
    }

    @Override
    void handle(Log log) {
        if(canHandle(log)){
            System.out.println("Successfully Handled by Level1");
        }else{
            System.out.println("Transferring to Level2");
            sendToNextHandler(log);
        }
    }
}


class Level2 extends Handler{
    Level2(Handler nextHandler){
        super(nextHandler);
    }

    @Override
    boolean canHandle(Log log) {
        return log.level.getSeverity() <= LogLevel.INFO.getSeverity();
    }

    @Override
    void handle(Log log) {
        if(canHandle(log)){
            System.out.println("Successfully Handled by Level2");
        }else{
            System.out.println("Transferring to Level3");
            sendToNextHandler(log);
        }
    }
}


class Level3 extends Handler{
    Level3(Handler nextHandler){
        super(nextHandler);
    }

    @Override
    boolean canHandle(Log log) {
        return log.level.getSeverity() <= LogLevel.WARN.getSeverity();
    }

    @Override
    void handle(Log log) {
        if(canHandle(log)){
            System.out.println("Successfully Handled by Level3");
        }else{
            System.out.println("Transferring to Level4");
            sendToNextHandler(log);
        }
    }
}

class Level4 extends Handler{
    Level4(Handler nextHandler){
        super(nextHandler);
    }

    @Override
    boolean canHandle(Log log) {
        return log.level.getSeverity() <= LogLevel.ERROR.getSeverity();
    }

    @Override
    void handle(Log log) {
        if(canHandle(log)){
            System.out.println("Successfully Handled by Level4");
        }else{
            System.out.println("Transferring to Level5");
            sendToNextHandler(log);
        }
    }
}


class Level5 extends Handler{
    Level5(Handler nextHandler){
        super(nextHandler);
    }

    @Override
    boolean canHandle(Log log) {
        return log.level.getSeverity() <= LogLevel.FATAL.getSeverity();
    }

    @Override
    void handle(Log log) {
            System.out.println("Successfully Handled by Level5");
        // cant transfer to another level as last level, so need to handle
    }
}








