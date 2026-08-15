package LLD.Problems;

import java.util.*;

public class VendingMachine_Demo {
    public static void main(String[] args) {
        VendingMachineV1 machine = new VendingMachineV1();
        Inventory inventory = new Inventory();

        machine.start();
        machine.addCoin();
        machine.selectProduct();
        machine.dispensingProduct();

    }
}


class VendingMachineV1 {

    private VendingMachineState state;
    private UserRequest userRequest;

    public VendingMachineV1() {
        this.state = new StartVM();
        this.userRequest = new UserRequest();
    }

    public void setState(VendingMachineState state, UserRequest userRequest) {
        this.state = state; // changing the state
        this.userRequest = userRequest;
    }

    void start() {
        state.startMachine(this, userRequest);
    }

    void addCoin() {
        state.addCoin(this, userRequest);
    }

    void selectProduct() {
        state.selectProduct(this, userRequest);
    }

    void dispensingProduct() {
        state.dispensingProduct(this, userRequest);
    }

    void cancel() {
        state.cancel(this, userRequest);
    }
}


class UserRequest {
    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    private String ProductCode;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    private Integer price;

}


class Product {
    private String productName;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    private Integer price;
    private String code;
    private Integer stock;

    public Product() {
    }

    public Product(String productName, Integer price, String code, Integer stock) {
        this.productName = productName;
        this.price = price;
        this.code = code;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

class Inventory {
    static Map<String, Product> productMap;

    Inventory() {
        productMap = new HashMap<>();
        initializeProducts();
    }

    void initializeProducts() {
        productMap.put("101", new Product("Red Bull", 120, "101", 1));
        productMap.put("102", new Product("Diet Coke", 40, "102", 5));
        productMap.put("103", new Product("Lays", 20, "103", 5));
        productMap.put("104", new Product("Toffee", 2, "104", 5));
        productMap.put("201", new Product("Coffee", 20, "201", 5));
        productMap.put("202", new Product("Chips Tomato", 20, "202", 5));
        productMap.put("203", new Product("Chocolates", 15, "203", 5));
        productMap.put("204", new Product("kurkure", 20, "204", 5));
    }

    static boolean canDispense(Product product) {
        if (productMap.containsKey(product.getCode())) {
            Product productInventory = productMap.get(product.getCode());
            if (productInventory.getStock() > 0 && product.getPrice() >= productInventory.getPrice()) {
                productInventory.setStock(productInventory.getStock() - 1);
                return true;
            }
            ;
        }
        return false;
    }

}

abstract class VendingMachineState {
    void startMachine(VendingMachineV1 vendingMachine, UserRequest request) {
        System.out.println("Invalid operation");
    }

    void addCoin(VendingMachineV1 vendingMachine, UserRequest request) {
        System.out.println("Invalid operation");
    }

    void selectProduct(VendingMachineV1 vendingMachine, UserRequest request) {
        System.out.println("Invalid operation");
    }

    void dispensingProduct(VendingMachineV1 vendingMachine, UserRequest request) {
        System.out.println("Invalid operation");
    }

    void cancel(VendingMachineV1 vendingMachine, UserRequest request) {
        System.out.println("Invalid operation");
    }
}


class StartVM extends VendingMachineState {

    @Override
    void startMachine(VendingMachineV1 vendingMachine, UserRequest request) {
        System.out.println(" Started the vending machine, Please insert the coin");
        vendingMachine.setState(new InsertCoinVM(), request);
    }
}


class InsertCoinVM extends VendingMachineState {

    @Override
    void addCoin(VendingMachineV1 vendingMachine, UserRequest request) {
        Scanner sc = new Scanner(System.in);
        int coin = sc.nextInt();
        request.setPrice(coin);
        System.out.println("Coin inserted, Thanks");
        vendingMachine.setState(new ProductVM(), request);
    }
}


class ProductVM extends VendingMachineState {

    @Override
    void selectProduct(VendingMachineV1 vendingMachine, UserRequest request) {
        System.out.println("Please select the product");
        Scanner sc = new Scanner(System.in);
        String productCode = sc.next();
        // TODO create a proper Product based on inventory
        request.setProductCode(productCode);
        vendingMachine.setState(new DispensingProductVM(), request);
    }
}


class DispensingProductVM extends VendingMachineState {

    @Override
    void dispensingProduct(VendingMachineV1 vendingMachine, UserRequest request) {
        System.out.println("Please wait dispensing the product");
        if (validateRequest(request)) {
            System.out.println("Dispensing product... " + request.getProductCode());
            vendingMachine.setState(new StartVM(), new UserRequest());
        } else {
            vendingMachine.setState(new CancelVM(), request);
        }
    }

    boolean validateRequest(UserRequest request) {
        Product product = new Product();
        product.setCode(request.getProductCode());
        product.setPrice(request.getPrice());
        return Inventory.canDispense(product);
    }
}

class CancelVM extends VendingMachineState {
    @Override
    void cancel(VendingMachineV1 vendingMachine, UserRequest request) {
        System.out.println("Canceling the transaction, Please try again");
        vendingMachine.setState(new StartVM(), new UserRequest());
    }
}
