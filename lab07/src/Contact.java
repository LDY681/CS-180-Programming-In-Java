/**
 * CS180 - LAB 07 - Contact
 * Contact & Numbers
 *
 * @author Liu Dayu
 * @version 1 2/21/2016
 */
public class Contact {
    private String name;
    private long number;
    private String address;

    /**
     * Constructor
     * @param name name
     */
    public Contact(String name) {
        this.name = name;
        this.number = 0;
        this.address = null;
    }

    /**
     * Constructor
     * @param name name
     * @param number number
     */
    public Contact(String name, long number) {
        this.name = name;
        this.number = number;
        this.address = null;
    }

    /**
     * Constructor
     * @param name name
     * @param number number
     * @param address address
     */
    public Contact(String name, long number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }

    /**
     * Getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter
     * @param number
     */
    public void setNumber(long number) {
        this.number = number;
    }

    /**
     * Getter
     * @return number
     */
    public long getNumber() {
        return number;
    }

    /**
     * Setter
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter
     * @return address
     */
    public String getAddress() {
        return address;
    }

    public boolean equals(Contact a){
        if (name.equals(a.getName())){
            return true;
        }
        return false;
    }

}
