package Objects;

import java.util.ArrayList;
import java.util.Date;

public class Week {
public 	int weeknumber;
public day[] day = new day[7];
	public Week(int weeknumber, ArrayList<Worker> workers){
		this.weeknumber = weeknumber;
		for(int i = 0; i<day.length;i++){
			day[i] = new day((weeknumber*7) + i ,workers,new Date());
			
		}
	}

}
