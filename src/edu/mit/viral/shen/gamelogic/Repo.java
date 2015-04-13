package edu.mit.viral.shen.gamelogic;

import java.util.Arrays;
import java.util.List;

public class Repo {
	static public final List<String> repo =  Arrays.asList("DK6/8/1p3r2/8/8/2b2b2/8/8 w KQkq - 1 1",
    "4D3/4p3/2r5/6b1/8/7b/5p2/7K w KQkq - 1 1",
    "8/2p1p3/8/2p4p/8/8/8/2pRp3 w KQkq - 1 1", 
    "8/3ppp2/2p2p2/2pR2p1/8/5p2/8/8 w KQkq - 1 1",
    "3p4/3p1p1p/8/2pp4/5R1p/8/2p1p3/8 w KQkq - 1 1",
    "6p1/3p4/5p1p/7N/6p1/6p1/5p2/7p w KQkq - 1 1",
    "8/3p3p/4p3/1B6/2p5/7p/p1p5/1p3p2 w KQkq - 1 1", 
    "2p3p1/2p3p1/p3Q3/8/3p4/3p4/8/3pp3 w KQkq - 1 1");

    public final String startFEN(int game_id){
    	return repo.get(game_id);
    }
}