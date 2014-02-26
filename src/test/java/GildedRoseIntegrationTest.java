import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GildedRoseIntegrationTest {

    @Test
    public void testMeetsRequirements() throws Exception {
        GildedRose.main(new String[]{});

        List<Item> items = GildedRose.getItems();

        assertGildedRoseListIsValid(items);
    }

    private void assertGildedRoseListIsValid(List<Item> items) {
        assertDexterityVestIsValid(items.get(0));
        assertAgedBrieIsValid(items.get(1));
        assertElixirOfMongooseIsValid(items.get(2));
        assertSulfurasIsValid(items.get(3));
        assertBackstagePassesIsValid(items.get(4));
        assertConjuredIsValid(items.get(5));
    }

    private void assertConjuredIsValid(Item item) {
        assertSellInIs(2, item);
        assertQualityIs(4, item);
    }

    private void assertBackstagePassesIsValid(Item item) {
        assertSellInIs(14, item);
        assertQualityIs(21, item);
    }

    private void assertSulfurasIsValid(Item item) {
        assertSellInIs(0, item);
        assertQualityIs(80, item);
    }

    private void assertElixirOfMongooseIsValid(Item item) {
        assertSellInIs(4, item);
        assertQualityIs(6, item);
    }

    private void assertAgedBrieIsValid(Item item) {
        assertSellInIs(1, item);
        assertQualityIs(1, item);
    }

    private void assertDexterityVestIsValid(Item item) {
        assertSellInIs(9, item);
        assertQualityIs(19, item);
    }

    private void assertSellInIs(int expected, Item item) {
        assertEquals(expected, item.getSellIn());
    }

    private void assertQualityIs(int expected, Item item) {
        assertEquals(expected, item.getQuality());
    }
}
