import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConjuredItemTest {

    @Test
    public void testDegradesQualityTwiceAsFastThanNormal() throws Exception {
        Item item = new Item("Conjured Mana Cake", 4, 20);
        List<Item> items = new ArrayList<Item>();
        items.add(item);

        GildedRose.updateQuality(items);

        assertEquals(item.getQuality(), 18);
    }

}
