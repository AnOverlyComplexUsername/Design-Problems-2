package GameRecord;

import java.util.ArrayList;
import java.util.List;


public class GameRecordTracker
{
    private final List<GameStats> gameRecords = new ArrayList<>();

    public GameRecordTracker() {}

    public void addNewRecord(int kills, int deaths, int assists)
    {
        gameRecords.add(new GameStats(kills, deaths, assists));
    }

    /// returns full list of game records
    public List<GameStats> getRecordList()
    {
        return gameRecords;
    }

    
    /// returns singular game record given an index
    public GameStats getRecordIndex(int i)
    {
        return gameRecords.get(i);
    }



    /// returns latest recorded game played
    public GameStats getLastestGamePlayed()
    {
        return gameRecords.getLast();
    }

    /// returns oldest recorded game played 
    public GameStats getOldestGamePlayed()
    {
        return gameRecords.getFirst();
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        for(GameStats g : gameRecords)
        {
            str.append(g);
            str.append(System.getProperty("line.separator"));
        }
        return str.toString();
    }
    
}