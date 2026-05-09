package LLD.DesignPattern.CommandPattern.Command.CommandImpl;

import LLD.DesignPattern.CommandPattern.Command.Command;
import LLD.DesignPattern.CommandPattern.Receiver.Fan;

public class FanCommandImpl implements Command {
    Fan fan = new Fan();
    @Override
    public String execute() {
        return fan.fanOn();
    }

    @Override
    public String undo() {
        return fan.fanOff();
    }
}
