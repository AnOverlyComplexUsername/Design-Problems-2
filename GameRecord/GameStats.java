package GameRecord;

import java.util.Date;

public class GameStats
{
    private int[] stats = new int[3]; // array that holds stat values in order of; kills, deaths, assists
    private Date date = null; // current date when record was made  
    public GameStats(int kills, int deaths, int assists)
    {
        date = new Date();
        stats[0] = kills;
        stats[1] = deaths;
        stats[2] = assists;
    }

    // GETTERS
    public int[] getStats() {
        return stats;
    }
    public int getKills()
    {
        return stats[0];
    }

    
    public int getDeaths()
    {
        return stats[1];
    }

    
    public int getAssists()
    {
        return stats[2];
    }

    // SETTERS
    public void setKills(int kills)
    {
        stats[0] = kills;
    }

    public void setDeaths(int deaths)
    {
        stats[1] = deaths;
    }

    public void setAssists(int assists)
    {
        stats[2] = assists;
    }

    public void setStats(int[] stats) {
            this.stats = stats;
    }
    
    @Override
    public String toString()
    {
        return String.format( date + " | Kills: %s, Deaths: %s, Assists: %s", stats[0], stats[1], stats[2]);
        
    }

    
}

