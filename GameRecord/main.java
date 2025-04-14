package GameRecord;

public class main {
    public static void main(String[] args) {
        GameRecordTracker gt = new GameRecordTracker();

        
        gt.addNewRecord(2, 3, 4);
        gt.addNewRecord(10 ,3, 14);
        gt.addNewRecord(2 ,10, 1);
        System.out.println(gt);
        System.out.println(gt.getLastestGamePlayed());
        System.out.println(gt.getOldestGamePlayed());
    }
}
