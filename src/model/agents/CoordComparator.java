package model.agents;
import java.util.Comparator; 

public class CoordComparator implements Comparator<Agent>{
	
	@Override 
	public int compare(Agent a, Agent b) 
    { 
		int ret = 1;
		if((a.getCoord().getX()) < b.getCoord().getX()) {
			ret = -1;
		}
		else if((a.getCoord().getX()) == b.getCoord().getX()) {
			if((a.getCoord().getY()) < b.getCoord().getY()) {
				ret = -1;
			}
		ret = 1;
		} 
		
		return ret;
    }
}
