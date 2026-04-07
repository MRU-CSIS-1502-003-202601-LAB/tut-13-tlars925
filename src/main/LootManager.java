package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

/**
 * Manages the inventory of RPG Loot.
 */
public class LootManager {
    private ArrayList<Loot> inventory;

    private LootManager() {
        this.inventory = new ArrayList<>();
    }

    public static LootManager load(String filePath) throws FileNotFoundException {
        LootManager looty = new LootManager();

        Scanner scanner = new Scanner(new File(filePath));

        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String[] lootParts = scanner.nextLine().split(",");

            Loot loot = LootFactory.create(lootParts);
            looty.add(loot);
        }

        scanner.close();

        return looty;
    }

    public void save(String filePath) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(filePath));

        writer.println("TYPE,NAME,RARITY,SPECIAL_1");

        for (Loot currLoot : inventory) {
            writer.println(currLoot.asCsvRecord());
        }

        writer.close();
    }

    public void add(Loot loot) {
        if (loot != null) {
            inventory.add(loot);
        }
    }

    /**
     * Polymorphically displays all items in the inventory.
     */
    public void displayInventory() {
        System.out.println();
        System.out.println("--- Current Inventory ---");
        for (Loot item : inventory) {
            System.out.println(item.getName() + " [" + item.getRarity() + "] - " +
                    item.getEffectDescription());
        }
        System.out.println("-------------------------");
        System.out.println();
    }
}