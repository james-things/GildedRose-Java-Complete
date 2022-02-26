package com.gildedrose;

import java.util.Scanner;

public class ManagementApp {

    public static void main(String[] args) {
        String loopString = "Y";
        GildedRose gildedRose = new GildedRose();
        Scanner in = new Scanner(System.in);

        gildedRose.setDemoItemData();

        System.out.println("Welcome to the Gilded Rose Management Application");

        while (loopString.equalsIgnoreCase("y")) {
            System.out.println("\n1. View Item List");
            System.out.println("2. Advance One Day");
            System.out.println("3. Add Item");

            System.out.print("\nEnter a selection: ");
            int selection = Integer.parseInt(in.nextLine());

            switch (selection) {
                case 1:
                    System.out.printf("\n%-50s %-10s %-10s %-10s\n", "Item Name", "Quality", "Sell In", "Type");
                    System.out.println(gildedRose.getItemsAsString());
                    break;
                case 2:
                    gildedRose.updateQuality();
                    System.out.println("Day advanced by 1 - quality has been updated.");
                    System.out.printf("\n%-50s %-10s %-10s %-10s\n", "Item Name", "Quality", "Sell In", "Type");
                    System.out.println(gildedRose.getItemsAsString());
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String name = in.nextLine();

                    System.out.print("Enter quality: ");
                    int quality = Integer.parseInt(in.nextLine());

                    System.out.println("Enter sell-in days: ");
                    int sellIn = Integer.parseInt(in.nextLine());

                    gildedRose.addItem(new Item(name, sellIn, quality));
                    System.out.println("\nItem added.");
                    break;
                default:
                    break;
            }
        }
    }
}
