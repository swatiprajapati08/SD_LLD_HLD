package LLD.DesignPattern.DecoratorPattern;


interface Logger{
    void log(String message);
}

class CreateLogger implements Logger{

    @Override
    public void log(String message) {
        System.out.println("Printing log: "+ message);
    }
}


/*
What if I use the interface DecoratorLog instead of abstract DecoratorLog
1. error if I do only
interface DecoratorLog {
    void log(String message);
}

when i do
Logger logger = (Logger) new JsonLogger(new CreateLogger());

fails because:

JsonLogger IS-A DecoratorLog
JsonLogger IS-NOT-A Logger

So to make it work EXTEND the Logger
interface DecoratorLog extends Logger OR directly do class JsonLogger implements Logger


2. Now bcz of this construction repetition is happening
     Logger logger;
    JsonLogger(Logger logger){
        this.logger=logger;
    }

    To avoid this we have use the abstract
 */
interface DecoratorLog extends Logger {
    void log(String message);
}

class JsonLogger implements DecoratorLog {

    Logger logger;
    JsonLogger(Logger logger){
        this.logger=logger;
    }

    @Override
    public void log(String message) {
        System.out.println("Json Formatter");
        logger.log(message);
    }
}


class FormatterLogger implements DecoratorLog{

    Logger logger;
    FormatterLogger(Logger logger){
        this.logger=logger;
    }

    @Override
    public void log(String message) {
        System.out.println("Formatter Logger");
        logger.log(message);
    }
}

abstract class LoggerDecorator implements Logger{
    Logger baseLogger;
    LoggerDecorator(Logger logger){
        this.baseLogger = logger;
    }
}
class JsonLoggerAbstract extends LoggerDecorator {

    JsonLoggerAbstract(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        System.out.println("Json Formatter");
        baseLogger.log(message);
    }
}

class FormatterLoggerAbstract extends LoggerDecorator{
    FormatterLoggerAbstract(Logger logger) {
        super(logger);
    }
    @Override
    public void log(String message) {
        System.out.println("Formatter Logger");
        baseLogger.log(message);
    }
}


public class DecoratorPattern {
    public static void main(String[] args) {
        Logger logger = new FormatterLogger( new JsonLogger(new CreateLogger()));
        logger.log(" Hello Decorator using Interface DecoratorLog");

        logger.log("----------------------------------");

        Logger logger1 = new JsonLoggerAbstract( new FormatterLoggerAbstract(new CreateLogger()));
        logger1.log(" Hello Decorator using Abstract DecoratorLog");
    }
}
