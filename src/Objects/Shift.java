package Objects;

import java.util.ArrayList;

public class Shift {
	public int worktime;
	public int workersneeded;
	public Worker[] workersonshift;
	

	public boolean workersneeded(){
		if(workersonshift[workersneeded-1] == null){
	
			return true;
			
		}
		
		return false;
	}
	public void addworker(Worker worker){
		for(int i = 0; i<workersneeded;i++){
			if(workersonshift[i] == null){
				workersonshift[i] = worker;
				break;
				
			}
			
		}
		
	}

}
