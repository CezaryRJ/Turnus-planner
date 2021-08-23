package Objects;

import java.util.ArrayList;

public class Worker {

	public String name;

	public double standardhours = 426;
	public boolean canworkday;
	public boolean canworkafternoon;
	public boolean canworknight;
	public int aviabletimes = 0;

	public int freedaysperweek = 1;
	public int shiftsperday = 1;
	public double empproc;
	public int hoursleft;
	public int sundaysworked = 0;
	ArrayList<Integer> unaviableonday = new ArrayList<>();

	public Worker(String name, boolean day, boolean afternoon, boolean night,
			double empproc) {
		canworkday = day;
		canworkafternoon = afternoon;
		canworknight = night;
		this.empproc = empproc;
		hoursleft = (int) (standardhours * empproc);
		this.name = name;
		if (canworkday) {
			aviabletimes++;

		}
		if (canworkafternoon) {
			aviabletimes++;

		}
		if (canworknight) {
			aviabletimes++;

		}
	}

	public boolean isaviable(int day) {

		for (int i = 0; i < unaviableonday.size(); i++) {
			if (unaviableonday.get(i) == day) {
				return false;
			}
		}
		return true;

	}

	public void cannotworkonday(int daynumber) {
		unaviableonday.add(daynumber);
	}

	public void cannotwork(int from, int too) {

		for (int i = from; i < too + 1; i++) {
			cannotworkonday(i);
		}

	}

	public int daysworkedthisweek(Week week) {
		int daysworked = 0;

		for (int i = 0; i < week.day.length; i++) {
			for (int x = 0; x < week.day[i].day.workersneeded; x++) {
				if (week.day[i].day.workersonshift[x] != null
						&& week.day[i].day.workersonshift[x].name == name) {
					daysworked++;

				}

			}
			for (int x = 0; x < week.day[i].afternoon.workersneeded; x++) {
				if (week.day[i].afternoon.workersonshift[x] != null
						&& week.day[i].afternoon.workersonshift[x].name == name) {
					daysworked++;

				}

			}
			for (int x = 0; x < week.day[i].night.workersneeded; x++) {
				if (week.day[i].night.workersonshift[x] != null
						&& week.day[i].night.workersonshift[x].name == name) {
					daysworked++;

				}

			}

		}

		return daysworked;

	}
	public void printworker(){
		System.out.println(name);
		System.out.println(canworkday);
		System.out.println(canworkafternoon);
		System.out.println(canworknight);
		System.out.println(empproc*100 + " %");
		for(int i = 0 ; i<unaviableonday.size();i++){
			System.out.println(unaviableonday.get(i));
			
		}
	}
}
