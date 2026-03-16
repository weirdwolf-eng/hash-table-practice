import java.util.*;

public class Problem2FlashSaleInventory {

    static HashMap<String, Integer> inventory = new HashMap<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    public static void addProduct(String productId, int stock) {
        inventory.put(productId, stock);
    }

    public static void checkStock(String productId) {
        System.out.println(productId + " stock: " + inventory.getOrDefault(productId, 0));
    }

    public static void purchaseItem(String productId, int userId) {

        int stock = inventory.getOrDefault(productId, 0);

        if (stock > 0) {
            inventory.put(productId, stock - 1);
            System.out.println("User " + userId + " purchased " + productId +
                    ". Remaining stock: " + (stock - 1));
        } else {
            waitingList.add(userId);
            System.out.println("Stock finished. User " + userId +
                    " added to waiting list. Position: " + waitingList.size());
        }
    }

    public static void main(String[] args) {

        addProduct("IPHONE15_256GB", 3);

        checkStock("IPHONE15_256GB");

        purchaseItem("IPHONE15_256GB", 101);
        purchaseItem("IPHONE15_256GB", 102);
        purchaseItem("IPHONE15_256GB", 103);
        purchaseItem("IPHONE15_256GB", 104);

    }
}