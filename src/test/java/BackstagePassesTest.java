import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BackstagePassesTest {

    @Test
    public void testItemIncreasesQualityTheOlderItGets() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertTrue(item.getQuality() > 20);
    }

    @Test
    public void testItemIncreasesByTwoWhenTenDaysLeft() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(item.getQuality(), 22);
    }

    @Test
    public void testItemIncreasesByTwoWhenLessThanTenDaysLeft() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(item.getQuality(), 22);
    }

    @Test
    public void testItemIncreasesByThreeWhenFiveDaysLeft() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(23, item.getQuality());
    }

    @Test
    public void testItemIncreasesByThreeWhenLessThanFiveDaysLeft() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(23, item.getQuality());
    }

    @Test
    public void testItemQualityDropsToZeroDayOfBackstagePass() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(0, item.getQuality());
    }
}
