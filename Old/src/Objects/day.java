package Objects;

import java.util.ArrayList;
import java.util.Date;

public class day {
	public DayShift day = new DayShift();
	public AfternoonShift afternoon = new AfternoonShift();
	public NightShift night = new NightShift();
	public Date date;
	public int daynumber;
	public ArrayList<Worker> aviableworkers;

	public ArrayList<Worker> workers1 = new ArrayList<>();
	public ArrayList<Worker> workers2 = new ArrayList<>();
	public ArrayList<Worker> workers3 = new ArrayList<>();

	public day(int daynumber, ArrayList<Worker> aviableworkers, Date date) {
		this.daynumber = daynumber;
		this.date = date;

	}

	public void sortworkers() {
		for (int i = 0; i < aviableworkers.size(); i++) {

			if (aviableworkers.get(i).aviabletimes == 1) {
				workers1.add(aviableworkers.get(i));

			}

			if (aviableworkers.get(i).aviabletimes == 2) {
				workers2.add(aviableworkers.get(i));

			}
			if (aviableworkers.get(i).aviabletimes == 3) {

				workers3.add(aviableworkers.get(i));

			}

		}
	}

	public void setaviableworkers(ArrayList<Worker> workers) {
		
		
		aviableworkers = workers;

	}

	public void fillday() {
		sortworkers();

		for (int i = 0; i < workers1.size(); i++) {

			for (int x = 0; x < workers1.size(); x++) {
				if (workers1.get(x).canworkday
						&& !findifallreadyworking(workers1.get(x))
						&& day.workersneeded()) {
					workers1.get(x).hoursleft = workers1.get(x).hoursleft
							- day.worktime;
					day.addworker(workers1.get(x));
					if (daynumber % 7 == 0) {
						workers1.get(x).sundaysworked++;

					}

				}

				if (workers1.get(x).canworkafternoon
						&& !findifallreadyworking(workers1.get(x))
						&& afternoon.workersneeded()) {
					workers1.get(x).hoursleft = workers1.get(x).hoursleft
							- afternoon.worktime;
					afternoon.addworker(workers1.get(x));
					if (daynumber % 7 == 0) {
						workers1.get(x).sundaysworked++;

					}

				}

				if (workers1.get(x).canworknight
						&& !findifallreadyworking(workers1.get(x))
						&& night.workersneeded()) {

					workers1.get(x).hoursleft = workers1.get(x).hoursleft
							- night.worktime;
					night.addworker(workers1.get(x));
					if ((daynumber + 1) % 7 == 0) {
						workers1.get(x).sundaysworked++;

					}

				}

			}

		}

		for (int i = 0; i < workers2.size(); i++) {
			

			for (int x = 0; x < workers2.size(); x++) {
				if (workers2.get(x).canworkday
						&& !findifallreadyworking(workers2.get(x))
						&& day.workersneeded()) {
					workers2.get(x).hoursleft = workers2.get(x).hoursleft
							- day.worktime;
					day.addworker(workers2.get(x));
					if ((daynumber + 1) % 7 == 0) {
						workers2.get(x).sundaysworked++;

					}

				}

				if (workers2.get(x).canworkafternoon
						&& !findifallreadyworking(workers2.get(x))
						&& afternoon.workersneeded()) {
					workers2.get(x).hoursleft = workers2.get(x).hoursleft
							- afternoon.worktime;
					afternoon.addworker(workers2.get(x));
					if ((daynumber + 1) % 7 == 0) {
						workers2.get(x).sundaysworked++;

					}

				}
				if (workers2.get(x).canworknight
						&& !findifallreadyworking(workers2.get(x))
						&& night.workersneeded()) {
					workers2.get(x).hoursleft = workers2.get(x).hoursleft
							- night.worktime;
					night.addworker(workers2.get(x));
					if ((daynumber + 1) % 7 == 0) {
						workers2.get(x).sundaysworked++;

					}

				}

			}

		}
		for (int i = 0; i < workers3.size(); i++) {
			

			for (int x = 0; x < workers3.size(); x++) {

				if (workers3.get(x).canworkday
						&& !findifallreadyworking(workers3.get(x))
						&& day.workersneeded()) {
					workers3.get(x).hoursleft = workers3.get(x).hoursleft
							- day.worktime;
					day.addworker(workers3.get(x));
					if ((daynumber + 1) % 7 == 0) {
						workers3.get(x).sundaysworked++;

					}

				}

				if (workers3.get(x).canworkafternoon
						&& !findifallreadyworking(workers3.get(x))
						&& afternoon.workersneeded()) {
					workers3.get(x).hoursleft = workers3.get(x).hoursleft
							- afternoon.worktime;
					afternoon.addworker(workers3.get(x));
					if ((daynumber + 1) % 7 == 0) {
						workers3.get(x).sundaysworked++;

					}

				}
				if (workers3.get(x).canworknight
						&& !findifallreadyworking(workers3.get(x))
						&& night.workersneeded()) {
					workers3.get(x).hoursleft = workers3.get(x).hoursleft
							- night.worktime;
					night.addworker(workers3.get(x));
					if ((daynumber + 1) % 7 == 0) {
						workers3.get(x).sundaysworked++;

					}

				}

			}

		}
		//printday();
	}

	public void printday() {

		if ((daynumber + 1) % 7 == 0) {
			System.out
					.println("///////////////////////////////////////////////SUNDAY");

		}
		System.out.println("\nPlan for day " + daynumber);
		System.out.println("Day shift");
		for (int i = 0; i < day.workersneeded; i++) {
			if (day.workersonshift[i] != null) {
				System.out.println(day.workersonshift[i].name + "| hours left " + day.workersonshift[i].hoursleft);
			} else {
				System.out.println("vikar");
			}

		}
		System.out.println("\n");
		System.out.println("Afternoon shift");
		for (int i = 0; i < afternoon.workersneeded; i++) {
			if (afternoon.workersonshift[i] != null) {
				System.out.println(afternoon.workersonshift[i].name + "| hours left " + afternoon.workersonshift[i].hoursleft);
			} else {
				System.out.println("vikar");
			}

		}
		System.out.println("\n");
		System.out.println("Night shift" );

		for (int i = 0; i < night.workersneeded; i++) {
			if (night.workersonshift[i] != null) {
				System.out.println(night.workersonshift[i].name + "| hours left " + night.workersonshift[i].hoursleft);
			} else {
				System.out.println("vikar");
			}

		}
	}

	public boolean findifallreadyworking(Worker worker) {
		
		
		for (int i = 0; i < day.workersneeded; i++) {
			if (day.workersonshift[i] != null
					&& day.workersonshift[i].name == worker.name) {
				return true;
			}

		}
		for (int i = 0; i < afternoon.workersneeded; i++) {
			if (afternoon.workersonshift[i] != null
					&& afternoon.workersonshift[i].name == worker.name) {
				return true;
			}

		}
		for (int i = 0; i < night.workersneeded; i++) {
			if (night.workersonshift[i] != null
					&& night.workersonshift[i].name == worker.name) {
				return true;
			}

		}
		return false;
	}
}
