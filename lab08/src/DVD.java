/**
 * Created by Liu Dayu on 2016/2/27.
 */
public class DVD implements Sellable {
    String productName;
    VideoType type;
    double price;
    public DVD (String productName, VideoType type, double price) {
        this.productName = productName;
        this.type = type;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }


    public double getPrice() {
        return price;
    }

    public VideoType getType(){
        return type;
    }
}
