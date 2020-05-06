import java.util.UUID;



public class MP4 implements Sellable, Downloadable {
    String productName;
    VideoType type;
    public MP4(String productName, VideoType type){
        this.productName = productName;
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        if (type == VideoType.MOVIE){
            return 4.99;
        }
        if (type == VideoType.TVSERIES){
            return 19.99;
        }
        return 0;
    }

    public String generateDownloadCode() {
        return UUID.randomUUID().toString();
    }

    public VideoType getType(){
        return type;
    }
}
