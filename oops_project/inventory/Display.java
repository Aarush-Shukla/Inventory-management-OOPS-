package inventory;

import inventory.CustomException.FileIOException;

public class Display extends Thread {

    public void display(InventoryManagementSys inventory) {

        Thread mythread1 = new Thread(() -> {
            try {
                inventory.displayInventory();
            } catch (FileIOException e) {

                e.printStackTrace();
            }
        });
        Thread mythread2 = new Thread(() -> {
            try {
                inventory.displayEmployees();
            } catch (FileIOException e) {

                e.printStackTrace();
            }
        });
        mythread1.start();
        mythread2.start();

    }
}
