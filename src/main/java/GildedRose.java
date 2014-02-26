import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
    static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    static final String AGED_BRIE = "Aged Brie";
    static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    private static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item(DEXTERITY_VEST, 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7));
        items.add(new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 15, 20));
        items.add(new Item(CONJURED_MANA_CAKE, 3, 6));

        updateQuality();
    }

    public static List<Item> getItems() {
        return items;
    }

    public static void updateQuality() {
       updateQuality(items);
    }

    public static void updateQuality(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Item currentItem = items.get(i);
            String currentItemName = currentItem.getName();


            if (CONJURED_MANA_CAKE.equals(currentItemName)) {
                currentItem.setQuality(currentItem.getQuality() - 1);
            }

            if ((!AGED_BRIE.equals(currentItemName)) && !BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(currentItemName)) {
                if (currentItem.getQuality() > 0) {
                    if (!SULFURAS_HAND_OF_RAGNAROS.equals(currentItemName)) {
                        currentItem.setQuality(currentItem.getQuality() - 1);
                    }
                }
            } else {
                if (currentItem.getQuality() < 50) {
                    currentItem.setQuality(currentItem.getQuality() + 1);

                    if (BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(currentItemName)) {
                        if (currentItem.getSellIn() < 11) {
                            if (currentItem.getQuality() < 50) {
                                currentItem.setQuality(currentItem.getQuality() + 1);
                            }
                        }

                        if (currentItem.getSellIn() < 6) {
                            if (currentItem.getQuality() < 50) {
                                currentItem.setQuality(currentItem.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!SULFURAS_HAND_OF_RAGNAROS.equals(currentItemName)) {
                currentItem.setSellIn(currentItem.getSellIn() - 1);
            }

            if (currentItem.getSellIn() < 0) {
                if (!AGED_BRIE.equals(currentItemName)) {
                    if (!BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(currentItemName)) {
                        if (currentItem.getQuality() > 0) {
                            if (!SULFURAS_HAND_OF_RAGNAROS.equals(currentItemName)) {
                                currentItem.setQuality(currentItem.getQuality() - 1);
                            }
                        }
                    } else {
                        currentItem.setQuality(currentItem.getQuality() - currentItem.getQuality());
                    }
                } else {
                    if (currentItem.getQuality() < 50) {
                        currentItem.setQuality(currentItem.getQuality() + 1);
                    }
                }
            }
        }
    }

}