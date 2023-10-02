package chapter2.agent_AB;

import java.util.Random;

import chapter2.agent_AB.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		Random rd = new Random();
		int x=rd.nextInt(2);
		if (p.getLocationState().equals(LocationState.DIRTY)) {
			return Environment.SUCK_DIRT;
		} else if (p.getAgentLocation() == Environment.LOCATION_A) {
			return x==0?Environment.MOVE_RIGHT:Environment.MOVE_DOWN;
		} else if (p.getAgentLocation() == Environment.LOCATION_B) {
			return x==0?Environment.MOVE_LEFT:Environment.MOVE_DOWN;
		}else if (p.getAgentLocation() == Environment.LOCATION_C) {
			return x==0?Environment.MOVE_LEFT:Environment.MOVE_UP;
		}else 
//			if (p.getAgentLocation() == Environment.LOCATION_D) 
			{
			return x==0?Environment.MOVE_RIGHT:Environment.MOVE_UP;
		}
	}
}