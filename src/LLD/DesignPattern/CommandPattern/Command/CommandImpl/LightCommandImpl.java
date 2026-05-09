package LLD.DesignPattern.CommandPattern.Command.CommandImpl;

import LLD.DesignPattern.CommandPattern.Command.Command;
import LLD.DesignPattern.CommandPattern.Receiver.Light;

public class LightCommandImpl implements Command {
    Light light = new Light();

    @Override
    public String execute() {
        return light.lightOn();
    }

    @Override
    public String undo() {
        return light.lightOff();
    }
}
