package LLD.DesignPattern.CommandPattern;

import LLD.DesignPattern.CommandPattern.Command.Command;
import LLD.DesignPattern.CommandPattern.Command.CommandImpl.FanCommandImpl;
import LLD.DesignPattern.CommandPattern.Command.CommandImpl.LightCommandImpl;


public class RemoteController {

    private Command command;
    boolean[] isOn = new boolean[]{false, false};

    private Command[] commandAppliance = {
            new LightCommandImpl(),
            new FanCommandImpl()
    };

    void setCommand(int index) {
        if(index < 0 || index >= commandAppliance.length) {
            throw new IllegalArgumentException("Invalid index");
        }

        this.command = commandAppliance[index];
    }

    void pressButton(int index) {
        if (isOn[index]) {
            isOn[index] = false;
            System.out.println(command.undo());
        } else {
            isOn[index] = true;
            System.out.println(command.execute());
        }
    }
}

/*
Take away
1. If any new appliance comes RemoteController have to add in Command and isOn flag
2. Command needs to implements its
3. Source only need to call without any worry
 */