import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class GildedRoseTest {

    @Test
    public void testTheTruth() {
        assertTrue(true);
    }

    @Test
    public void testDecreaseQualityDaily() throws Exception {
        Item item = new Item("Test Item", 10, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(item.getQuality(), 0x13);
    }

    @Test
    public void testDecreaseSellInDaily() throws Exception {
        Item item = new Item("Test Item", 10, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(9, item.getSellIn());
    }

    @Test
    public void testQualityDegradesTwiceWhenSellInPassed() throws Exception {
        Item item = new Item("Test Item", 0, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(18, item.getQuality());
    }

    @Test
    public void testQualityIsNeverNegative() throws Exception {
        Item item = new Item("Test Item", 10, 0);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(0, item.getQuality());
    }

    @Test
    public void testAgedBrieQualityIncreasesWithAge() throws Exception {
        Item item = new Item("Aged Brie", 10, 0);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(1, item.getQuality());
    }

    @Test
    public void testQualityNeverMoreThanFifty() throws Exception {
        Item item = new Item("Aged Brie", 10, 50);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(50, item.getQuality());
    }

    @Test
    public void testLegendaryItemNeverDecreasesInQuality() throws Exception {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 50);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(50, item.getQuality());
    }

    @Test
    public void testLegendaryItemNeverAltersQuality() throws Exception {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(80, item.getQuality());
    }

}
