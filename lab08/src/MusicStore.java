/**
 * Created by Liu Dayu on 2016/2/27.
 */

/**
 * The MusicStore class models a Music Store where you can add, remove, or get products and sort them
 * by price in ascending or descending order.
 */
public class MusicStore {


    private int totalProducts;
    private int maxProducts;
    private Sellable[] storeProducts;

    /**
     * Constructor. Initializes this MusicStore with 0 products, a max capacity of 10 products, and
     * an empty array of Sellable products of size 10.
     */
    public MusicStore() {
        totalProducts = 0;
        maxProducts = 10;
        storeProducts = new Sellable[10];
    }

    /**
     * Adds the specified Sellable product to this MusicStore. If the product already exists, then
     * the method returns false and no changes are made. If the product does not already exist, a check
     * is made if the totalProducts is equal to the maxProducts and the array capacity is double if
     * needed before the new product is added.
     *
     * @param product The Sellable product to add to this MusicStore
     * @return true if the product was added, false otherwise
     */
    public boolean addProduct(Sellable product) {

        //If product already exists
        for (int i = 0; i < totalProducts; i++) {
            if (contains(product)||contains(product.getProductName())) {
                return false;
            }
        }

        //If the array is full
        if (totalProducts == maxProducts) {
            Sellable[] a = new Sellable[maxProducts * 2];
            for (int i = 0; i < totalProducts; i++) {
                a[i] = storeProducts[i];
            }
            storeProducts = a;
            storeProducts[totalProducts] = product;
            totalProducts++;
            return true;
        }

        //General Condition
        storeProducts[totalProducts] = product;
        totalProducts++;
        return true;
    }

    /**
     * Removes the product given by the name argument from this MusicStore and moves all products that
     * follow it in the storeProducts array to the left so that there are no empty entries between
     * products. For example:
     * <p>
     * before -> {S1, S2, S3, S4, S5, S6, S7, S8, S9, null}
     * remove S6
     * after -> {S1, S2, S3, S4, S5, S7, S8, S9, null, null}
     *
     * @param name The name of the product to remove from this MusicStore
     * @return true if the product was removed, false otherwise
     */
    public boolean removeProductByName(String name) {
        //int mv = 0;
        boolean exist = false;
        for (int i = 0; i < totalProducts; i++) {
            if (storeProducts[i].getProductName().equals(name)) {
               // mv = i;
                exist = true;
                for (int j = i; j < totalProducts; j++) {
                    //if (j < mv) {
                        storeProducts[j] = storeProducts[j+1];
          //          }
                    //if (i > mv) {
               //         storeProducts[i - 1] = storeProducts[i];
            //        }
                }
                storeProducts [totalProducts - 1] = null;
                totalProducts --;
                return true;
            }
        }
        //if (!exist){
            return false;
        //}


    }

    /**
     * Gets the product from the list of Sellable products of this MusicStore by the given name.
     *
     * @param product The name of the product to get
     * @return The product with the given name, or null if the product is not found
     */
    public Sellable getProductByName(String product) {
        for (int i = 0; i < totalProducts; i++) {
            if (storeProducts[i].equals(product)) {
                return storeProducts[i];
                // TODO: Ask whether removing the product after getting it
            }
        }
        return null;
    }

    /**
     * Sorts all the Sellable products in this MusicStore by price. The ascending argument
     * specifies if the the products should be sorted in ascending or descending order. You
     * are free to use whichever sorting algorithm you choose from any outside resources
     * as long as the storeProducts array is sorted correctly as specified by the argument.
     *
     * @param ascending True to sort ascending by price, false to sort descending by price
     */

    public void sortAllProductsByPrice(boolean ascending) {
        Sellable[] a = new Sellable[totalProducts];

        //True Condition

            if (ascending == true) {
                boolean check = false;
                while (!check){
                    check = true;
                    for (int i = 0; i < totalProducts - 1; i++) {
                        if (storeProducts[i + 1].getPrice() < storeProducts[i].getPrice()) {
                            Sellable b = storeProducts[i];
                            storeProducts[i] = storeProducts[i + 1];
                            storeProducts[i + 1] = b;
                            check = false;
                }
                    }
                }
            }

            //False Condition
            if (ascending == false) {
                boolean check = false;
                while (!check) {
                    check = true;
                    for (int i = 0; i < totalProducts - 1; i++) {
                        if (storeProducts[i + 1].getPrice() > storeProducts[i].getPrice()) {
                            Sellable b = storeProducts[i];
                            storeProducts[i] = storeProducts[i + 1];
                            storeProducts[i + 1] = b;
                            check = false;
                        }
                    }
                }
            }
        }



    /**
     * Checks if a given Sellable product is already in this MusicStore.
     *
     * @param product The product to find
     * @return true if the product is found, false otherwise
     */
    private boolean contains(Sellable product) {
        for (int i = 0; i < totalProducts; i++) {
            boolean mp4 = product instanceof MP4;
            boolean mp3 = product instanceof MP3;
            boolean DVD = product instanceof DVD;
            boolean CD = product instanceof CD;

            //TODO:Ask about the comparision
            if (mp4 && storeProducts [i] instanceof MP4 ) {
                if (storeProducts[i].getProductName().equals(product.getProductName())
                        && ((MP4) storeProducts[i]).getType().equals(((MP4) product).getType())) {
                    return true;
                }
            }


            if (mp3 && storeProducts [i] instanceof MP3) {
                if (storeProducts[i].getProductName().equals(product.getProductName())) {
                    return true;
                }
            }

            if (CD && storeProducts [i] instanceof CD) {
                if (storeProducts[i].getProductName().equals(product.getProductName()) &&
                        ((CD) storeProducts[i]).getTotalSongs() == ((CD) product).getTotalSongs()
                        && (storeProducts[i]).getPrice() == (product).getPrice()) {
                    return true;
                }
            }

            if (DVD && storeProducts [i] instanceof DVD) {
                if ((storeProducts[i].getProductName().equals(product.getProductName()))
                        && (((DVD) storeProducts[i]).getType() == ((DVD) product).getType()
                        && (storeProducts[i]).getPrice() == (product).getPrice())
                        ) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Checks if a Sellable product with the given name is already in this MusicStore.
     *
     * @param name The name of the product to find
     * @return true if the product is found, false otherwise
     */

    private boolean contains(String name) {
        for (int i = 0; i < totalProducts; i++) {
            if (storeProducts[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints all the products in this MusicStore. This method is complete and should not be modified.
     */
    public void printProducts() {
        for (int i = 0; i < this.totalProducts; i++) {
            Sellable temp = this.storeProducts[i];
            if (temp instanceof CD) {
                System.out.printf("CD Name:\t%s%n", temp.getProductName());
                System.out.printf("Total Songs:\t%d%n", ((CD) temp).getTotalSongs());
                System.out.printf("Price:\t\t%.2f%n", temp.getPrice());
            } else if (temp instanceof DVD) {
                System.out.printf("DVD Name:\t%s%n", temp.getProductName());
                System.out.printf("Type:\t\t%s%n", ((DVD) temp).getType());
                System.out.printf("Price:\t\t%.2f%n", temp.getPrice());
            } else if (temp instanceof MP3) {
                System.out.printf("MP3 Name:\t%s%n", temp.getProductName());
                System.out.printf("Price:\t\t%.2f%n", temp.getPrice());
            } else {
                System.out.printf("MP4 Name:\t%s%n", temp.getProductName());
                System.out.printf("Type:\t\t%s%n", ((MP4) temp).getType());
                System.out.printf("Price:\t\t%.2f%n", temp.getPrice());
            }
            System.out.println();
        }
    }


}
