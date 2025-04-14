package PhoneBook;

public class PhoneNumber implements Comparable<PhoneNumber>{
    private Integer num = 0;

    /// use a 10 digit int for phone number
    public PhoneNumber(int num) throws IllegalArgumentException
    {
        this.num = num;
        if (this.num.toString().length() != 10)
        {
            throw new IllegalArgumentException("ERROR: A non 10 digit phone number was used!!");
        }

    }

    // getter
    public Integer getPhoneNumber() {
        return num;
    }

    // setter
    public void setPhoneNumber(int num) {
        this.num = num;
    }

    @Override
    public String toString()
    {

        StringBuilder str = new StringBuilder(num.toString());
        str.insert(0, "(").insert(4, ")").insert(5, "-").insert(9, "-");
        
        return str.toString();

    }

    @Override
    public int compareTo(PhoneNumber o) {
        return num.compareTo(o.getPhoneNumber());
    }

}
