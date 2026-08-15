package LLD.DesignPattern.FacadePattern;

/*
provide a simple class to hide the complexity of complex subsystem
 */
public class FacadeDesignPattern {
}

class CPU{
    void start(){
        System.out.println("CPU started");
    }
}


class Memory{
    void load(){
        System.out.println("Memory Loaded");
    }
}


class Main{
    public static void main(String[] args) {
        /*
        Without Facade
        So much code in client side, increase in future


        CPU cpu = new CPU();
        Memory memory = new Memory();
        cpu.start();
        memory.load();

         */

        ComputerFacade facade = new ComputerFacade();
        facade.startComputer();
    }
}


class ComputerFacade{
    private CPU cpu;
    private Memory memory;
    ComputerFacade(){
        cpu = new CPU();
        memory = new Memory();
    }

    void startComputer(){
        cpu.start();
        memory.load();
    }

}