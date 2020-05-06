/**
 * Created by Liu Dayu on 2016/2/27.
 */
public class CD implements Sellable {
    String productName;
    int totalSongs;
    double price;
    public CD (String productName, int totalSongs, double price) {
        this.productName = productName;
        this.totalSongs = totalSongs;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }


    public double getPrice() {
        return price;
    }

    public int getTotalSongs(){
        return totalSongs;
    }
}
