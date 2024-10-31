package praktikum.Core2.collections.Compare;

import java.util.Comparator;

public class ItemPopularityComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o2.popularity - o1.popularity;
    }
}
