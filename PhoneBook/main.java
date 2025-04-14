package PhoneBook;

public class main {
    
     public static void main(String[] args) {

        PhoneBook p1 = new PhoneBook();
        int[] pnn1 = {1232131231, 1232131221};

        p1.addAddress("yumi", 1239193292);
        p1.addAddress("yUmi", pnn1);
        p1.addAddress("neuro", 1232131221);
        p1.addAddress("eliv", 1232131221);
        
        System.out.println(p1);
        System.out.println(p1.getPersonsNumber("yumi"));
        System.out.println(p1.getNumbersName(new PhoneNumber(1232131221)));
        System.out.println(p1.getSortedNameList());
        System.out.println(p1.getSortedNumberList());



    }
}
