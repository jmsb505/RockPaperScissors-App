package com.example.ppot;
import android.widget.ListView;

import java.util.*;

public class MatchTracker {
    private static MatchTracker instancia=new MatchTracker();
    private ArrayList<String> roundList=new ArrayList<>();
    private Map<String,Integer> winMap;
    private Integer pcWins;
    private Integer playerWins;
    private Integer roundCounter;

    public static MatchTracker getInstance()
    {
        return instancia;
    }
    private MatchTracker()
    {
        roundList=new ArrayList<String>();
        winMap=new LinkedHashMap<String,Integer>();
        winMap.put("Jugador",0);
        winMap.put("PC",0);
        pcWins=0;
        playerWins=0;
        roundCounter=0;
    }
    public void reset()
    {
        roundList.clear();
        winMap.clear();
        winMap.put("Jugador",0);
        winMap.put("PC",0);
        roundCounter=0;
        pcWins=0;
        playerWins=0;
    }
    public void setRound(Integer player, Integer pc)
    {
        roundCounter++;
        if(player==0 && pc==0 )
        {
            roundList.add("Jugador empato Ronda: "+roundCounter+" usando ambos piedra.");
        }
        else if(player==0 && pc==1)
        {
            roundList.add("Jugador perdio Ronda: "+roundCounter+" usando piedra. PC uso papel.");
            pcWins++;
            winMap.put("PC",pcWins);
        }
        else if(player==0 && pc==2 )
        {
            roundList.add("Jugador gano Ronda: "+roundCounter+" usando piedra. PC uso tijera.");
            playerWins++;
            winMap.put("Jugador",playerWins);
        }
        else if(player==1 && pc==0 )
        {
            roundList.add("Jugador gano Ronda: "+roundCounter+" usando papel. PC uso piedra.");
            playerWins++;
            winMap.put("Jugador",playerWins);
        }
        else if(player==1 && pc==1 )
        {
            roundList.add("Jugador empato Ronda: "+roundCounter+" usando ambos papel.");
        }
        else if(player==1 && pc==2 )
        {
            roundList.add("Jugador perdio Ronda: "+roundCounter+" usando papel. PC uso tijera.");
            pcWins++;
            winMap.put("PC",pcWins);
        }
        else if(player==2 && pc==0 )
        {
            roundList.add("Jugador perdio Ronda: "+roundCounter+" usando tijera. PC uso piedra.");
            pcWins++;
            winMap.put("PC",pcWins);
        }
        else if(player==2 && pc==1 )
        {
            roundList.add("Jugador gano Ronda: "+roundCounter+" usando tijera. PC uso papel.");
            playerWins++;
            winMap.put("Jugador",playerWins);
        }
        else if(player==2 && pc==2 )
        {
            roundList.add("Jugador empato Ronda: "+roundCounter+" usando ambos tijera.");
        }
    }
    public ArrayList<String>getHist(){
    return roundList;
    }

    public Integer getPcWins() {
        return pcWins;
    }

    public Integer getPlayerWins() {
        return playerWins;
    }
}
