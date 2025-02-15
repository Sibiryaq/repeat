package praktikum.Core2.collections.Compare;

public class Item {
    public final String name;
    public final int price;
    public final int popularity;

    public Item(String name, int price, int popularity) {
        this.name = name;
        this.price = price;
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", popularity=" + popularity +
                '}';
    }
}
