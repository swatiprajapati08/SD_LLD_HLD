package LLD.DesignPattern.StateDesignPattern;

/*
Vending Machine ⭐⭐⭐⭐

States
    Idle
    HasMoney
    ProductSelected
    Dispensing
    OutOfStock

Operations
    insertMoney()
    selectProduct()
    dispense()
    refund()

Bonus
    Cancel order
    Multiple products
    Change return

    1. List of product along with <Name, price>
    2. User select the product and add the money
    3. If match with price of product dispense the product
    4. Else refund the money




import java.util.HashMap;
import java.util.Map;

class Product{
    String name;
    int price;
    int quantity;
    Product(String name,int price,int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class VendingMachine {

    VendingMachineState curr;
    Map<String, Product> products = new HashMap<>();
    Product selectedProduct;

    void addProduct(Product product){
        products.put(product.name,product);
    }

    void addMoney(int amount){
        curr.insertMoney(amount);
    }

    void selectProduct(String name){
        if(products.containsKey(name) && products.get(name).quantity > 0) {
            selectedProduct = products.get(name);
            curr.selectProduct(selectedProduct);
        }
    }

    void updateProduct(Product product){
        Product curr = products.get(product.name);
        curr.quantity -= 1;
        products.put(curr.name, product);
    }

    void dispense(){

        curr.dispense();
    }

    void refund(){
        curr.refund();
    }

    void setState(VendingMachineState state){
        curr = state;
    }
}



interface VendingMachineState{
    void insertMoney(int amount);
    void selectProduct(Product product);
    void dispense();
    void refund();
}


class IdleState implements VendingMachineState{
    VendingMachine machine;

    IdleState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertMoney(int amount) {
        machine.addMoney(amount);
    }

    @Override
    public void selectProduct(Product product) {


    }

    @Override
    public void dispense() {

    }

    @Override
    public void refund() {

    }
}

class HasMoneyState implements VendingMachineState{
    VendingMachine machine;

    HasMoneyState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Select the product first!!");
    }

    @Override
    public void selectProduct(Product product) {
        machine.setState(new ProductSelectedState());
    }

    @Override
    public void dispense() {
        System.out.println("Select the product first!!");
    }

    @Override
    public void refund() {
        System.out.println("Select the product first!!");
    }
}

class ProductSelectedState implements VendingMachineState{
    VendingMachine machine;

    ProductSelectedState(){
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Select the product first!!");
    }

    @Override
    public void selectProduct(Product product) {
        // decrease the quantity
        machine.setState(new DispensingState(machine));
    }

    @Override
    public void dispense() {
        System.out.println("Select the product first!!");
    }

    @Override
    public void refund() {
        System.out.println("Select the product first!!");
    }
}

class DispensingState implements VendingMachineState{
    VendingMachine machine;

    DispensingState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Dispensing the order!!");
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Dispensing the order!!");
    }

    @Override
    public void dispense() {
//        machine.updateProduct( );
    }

    @Override
    public void refund() {

    }
}

class OutOfStockState implements VendingMachineState{
    VendingMachine machine;

    OutOfStockState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertMoney(int amount) {
        machine.addMoney(amount);
    }

    @Override
    public void selectProduct(Product product) {


    }

    @Override
    public void dispense() {

    }

    @Override
    public void refund() {

    }
}







 */
