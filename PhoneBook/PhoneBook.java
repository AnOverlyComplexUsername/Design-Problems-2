package PhoneBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PhoneBook
{
    private final HashMap<String, LinkedList<PhoneNumber>> addresses = new HashMap<>(); // contains all numbers that have multiple users
    private final List<PhoneNumber> numberListSorted = new ArrayList<>(); // numerically sorted phone number list
    private final List<String> nameListSorted = new ArrayList<>(); // alphabetically sorted name list

    public PhoneBook(){}

    // GETTERS

    /// returns a list of associated phone numbers given a name
    public LinkedList<PhoneNumber> getPersonsNumber(String name)
    {
        return addresses.get(name.toLowerCase());
    }

    /// returns a name given an associated phone number
    public String getNumbersName(PhoneNumber num)
    {
        String str = "Name(s) associated with number: ";
        // loop through map; check if value == num then add corresponding name to return statement
        for(String name : addresses.keySet())
        {
            LinkedList<PhoneNumber> numList = addresses.get(name);
            for(PhoneNumber n: numList)
            {
                if(n.equals(num));
                str += name + " ";
                break;
            }
        }

        return str;
    }

    public String getNumbersName(int num)
    {
        PhoneNumber tempN = new PhoneNumber(num);
        String str = "Name(s) associated with number: ";
        // loop through map; check if value == num then add corresponding name to return statement
        for(String name : addresses.keySet())
        {
            LinkedList<PhoneNumber> numList = addresses.get(name);
            for(PhoneNumber n: numList)
            {
                if(n.equals(tempN));
                str += name + " ";
                break;
            }
        }

        return str;
    }

    /// returns list of all names in phone book; ordered alphabetically A -> Z
    public List<String> getSortedNameList()
    {
        return nameListSorted;
    } 

    public List<PhoneNumber> getSortedNumberList()
    {
        return numberListSorted;
    } 
    // ADD

    /// adds one address that correlates one name to one number
    public void addAddress(String name, int num) 
    {
        addresses.putIfAbsent(name.toLowerCase(), new LinkedList<>());
        addresses.get(name.toLowerCase()).add(new PhoneNumber(num));
        
        addSortNames(name.toLowerCase());
        addSortNumbers(new PhoneNumber(num));
        
    }

    /// adds one address where one name correlates with multiple numbers 
    public void addAddress(String name, Collection<Integer> nums) 
    {
        addresses.putIfAbsent(name.toLowerCase(), new LinkedList<>());
        for (int num : nums) {
            addresses.get(name.toLowerCase()).add(new PhoneNumber(num));
            addSortNumbers(new PhoneNumber(num));
        }
        addSortNames(name.toLowerCase());
    }

    /// adds one address where one name correlates with multiple numbers 
    public void addAddress(String name, int[] nums) 
    {
        addresses.putIfAbsent(name.toLowerCase(), new LinkedList<>());
        for (int num : nums) {
            addresses.get(name.toLowerCase()).add(new PhoneNumber(num));
            addSortNumbers(new PhoneNumber(num));
        }

        addSortNames(name.toLowerCase());
        
    }

    /// adds new name and then sorts name list
    private void addSortNames(String name)
    {
        if (!nameListSorted.contains(name))
        {
        nameListSorted.add(name);
        Collections.sort(nameListSorted);
        }
    }

    /// adds new number and then sorts number list
    private void addSortNumbers(PhoneNumber number)
    {
        boolean contains = false;
        if (!numberListSorted.isEmpty())
        {
            for (PhoneNumber nums : numberListSorted) {
                if (nums.getPhoneNumber().equals(number.getPhoneNumber()))
                {
                    contains = true;
                    break;
                }
            }
            if (!contains)
            {
                numberListSorted.add(number);
                Collections.sort(numberListSorted); 
            }
        }
        else  
        {
            numberListSorted.add(number);
        Collections.sort(numberListSorted); 
        }
        
    }
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        addresses.forEach((k,v) -> {str.append("Name: ").append(k).append(" | Number(s): ").append(v.toString()).append(System.getProperty("line.separator"));});
        return str.toString();
    }

}