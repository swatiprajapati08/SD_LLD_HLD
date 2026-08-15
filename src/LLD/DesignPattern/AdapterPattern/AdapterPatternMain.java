package LLD.DesignPattern.AdapterPattern;

public class AdapterPatternMain {
    public static void main(String[] args) {
        Application app = new Application(new RazorPayAdapter());
        app.pay();
    }
}


interface IPaymentProcessor{
    void pay();
}

class InHousePayment implements IPaymentProcessor{

    @Override
    public void pay() {
        System.out.println("InHouse payment process");
    }
}


/*
Razorpay is not compatible with our application
 */
class RazorPay{
    void make_payment(){
        System.out.println("RazorPay payment process");
    }
}


class RazorPayAdapter implements IPaymentProcessor{
    RazorPay razorPay;
    RazorPayAdapter(){
        razorPay = new RazorPay();
    }


    @Override
    public void pay() {
        razorPay.make_payment();
    }
}

class Application{
    IPaymentProcessor processor;
    Application(IPaymentProcessor processor){
        this.processor = processor;
    }

    void pay(){
        processor.pay();
    }
}
