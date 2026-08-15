package LLD.DesignPattern.StateDesignPattern;


/*
    Goal
        Order behavior should change based on its state.
    States
        Placed
        Preparing
        OutForDelivery
        Delivered
    Behavior
        Each state controls:
            next transition
            allowed actions
    Tasks
        Create OrderState interface
    Implement:
        PlacedState
        PreparingState
        OutForDeliveryState
        DeliveredState
        Order holds current state
    Example
        Placed → Preparing → OutForDelivery → Delivered
    Bonus
        Prevent invalid transitions
 */

public class OrderLifeCycle {

    public static void main(String[] args) {
        Order order = new Order();

        order.getCurrentState();

        order.next();
        order.getCurrentState();

        order.next();
        order.getCurrentState();

        order.cancel();

        order.next();
        order.getCurrentState();

        order.next();
    }
}


interface OrderState{
   void next(Order order);
   void cancel(Order order);
   String getStateName();
}


class PlacedState implements OrderState{

    @Override
    public void next(Order order) {
        order.setState(new PreparingState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order cancelled successfully.");
    }

    @Override
    public String getStateName() {
        return "Currently in placed order state";
    }
}


class PreparingState implements OrderState{

    @Override
    public void next(Order order) {
        order.setState(new OutForDeliveryState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Can't cancel, as order is being prepared");
    }

    @Override
    public String getStateName() {
        return "Preparing state";
    }
}


class OutForDeliveryState implements OrderState{


    @Override
    public void next(Order order) {
        order.setState(new DeliveredState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Can't cancel, Order is out for delivery.");
    }

    @Override
    public String getStateName() {
        return "Out of delivery state";
    }
}

class DeliveredState implements OrderState{

    @Override
    public void next(Order order) {
        System.out.println("Order delivered");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Can't cancel as Order is already delivered successfully.");
    }

    @Override
    public String getStateName() {
        return "Delivered state";
    }
}


class Order {
    OrderState currentState;

    public Order() {
        this.currentState = new PlacedState();
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }


    public void next(){
        currentState.next(this);
    }


    public void cancel(){
        currentState.cancel(this);
    }

    public void getCurrentState(){
        System.out.println(currentState.getStateName());
    }
}



