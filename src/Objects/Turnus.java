package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Turnus {

	public int startweek;
	public int endweek;
	public ArrayList<Worker> workerbase = new ArrayList<>();
	public Week[] week = new Week[12];

	public Turnus(int start) {
		startweek = start;
		endweek = start + 12;
		for (int i = 0; i < 12; i++) {
			week[i] = new Week(i, workerbase);

		}

	}

	public day getday(int daynumber) {
		return week[daynumber / 7].day[daynumber % 7];

	}

	public void addworker(Worker newworker) {
		workerbase.add(newworker);
	}

	public void loadworkers(String folderpath) throws FileNotFoundException {
		ReadWriter reader = new ReadWriter();
		File folder = new File(folderpath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println(folderpath + "/" + listOfFiles[i].getName());
				workerbase.add(reader.readworker(folderpath + "/"
						+ listOfFiles[i].getName()));
			}
		}

	}

	public boolean ifcanwork(Worker worker, day day) {
		if ((day.daynumber + 1) % 7 == 0 && worker.sundaysworked >= 6) {

			return false;

		}

		if (worker.hoursleft > 7) {
			if (worker.canworkday == true
					&& worker.isaviable(day.daynumber)
					&& day.day.workersonshift[day.day.workersneeded - 1] == null
					&& worker.daysworkedthisweek(week[(day.daynumber / 7)]) < 6) {

				return true;

			} else if (worker.canworkafternoon == true
					&& worker.isaviable(day.daynumber)
					&& worker.hoursleft > 8
					&& day.afternoon.workersonshift[day.afternoon.workersneeded - 1] == null
					&& worker.daysworkedthisweek(week[(day.daynumber / 7)]) < 6) {
				return true;

			} else if (worker.canworknight == true
					&& worker.isaviable(day.daynumber)
					&& worker.hoursleft > 10
					&& day.night.workersonshift[day.night.workersneeded - 1] == null
					&& worker.daysworkedthisweek(week[(day.daynumber / 7)]) < 6) {
				return true;

			}

		}
		return false;
	}

	public ArrayList<Worker> findaviableworkers(int day) {
		ArrayList<Worker> workersfound = new ArrayList<>();
		for (int i = 0; i < workerbase.size(); i++) {
			if (ifcanwork(workerbase.get(i), getday(day))) {
				workersfound.add(workerbase.get(i));
			}
		}
		return workersfound;
	}

	public void maketurnus() {
		for (int i = 0; i < ((endweek - startweek) * 7); i++) {
			week[i / 7].day[i % 7].setaviableworkers(findaviableworkers(i));
			week[i / 7].day[i % 7].fillday();
		}

	}

	public void printworkerstats() {
		for (int i = 0; i < workerbase.size(); i++) {
			System.out.println("Name " + workerbase.get(i).name);
			System.out.println("Hours left " + workerbase.get(i).hoursleft);
			System.out.println("Sundays worked "
					+ workerbase.get(i).sundaysworked + "\n");

		}
	}

	public Worker findworker(String name) {

		for (int i = 0; i < workerbase.size(); i++) {
			if (workerbase.get(i).name.equals(name)) {

				return workerbase.get(i);
			}

		}

		return null;

	}

	public void printplan(String name) {

		int daysworked = 0;
		int hoursworked = 0;

		for (int i = 0; i < week.length; i++) {
			for (int x = 0; x < week[i].day.length; x++) {
				for (int y = 0; y < week[i].day[x].day.workersonshift.length; y++) {
					if (week[i].day[x].day.workersonshift[y] != null
							&& week[i].day[x].day.workersonshift[y].name
									.equals(name)) {
						daysworked++;
						hoursworked = hoursworked + week[i].day[x].day.worktime;
						System.out.println("Date " + week[i].day[x].daynumber
								+ "\n     Dayshift \n ---------------");

					}

				}
				for (int y = 0; y < week[i].day[x].afternoon.workersonshift.length; y++) {
					if (week[i].day[x].afternoon.workersonshift[y] != null
							&& week[i].day[x].afternoon.workersonshift[y].name
									.equals(name)) {
						daysworked++;
						hoursworked = hoursworked
								+ week[i].day[x].afternoon.worktime;
						System.out.println("Date " + week[i].day[x].daynumber
								+ "\n     Afternoonshift \n ---------------");

					}
				}
				for (int y = 0; y < week[i].day[x].night.workersonshift.length; y++) {
					if (week[i].day[x].night.workersonshift[y] != null
							&& week[i].day[x].night.workersonshift[y].name
									.equals(name)) {
						daysworked++;
						hoursworked = hoursworked
								+ week[i].day[x].night.worktime;
						System.out.println("Date " + week[i].day[x].daynumber
								+ "\n     Nightshift \n ---------------");

					}
				}

			}

		}
		System.out.println("Days worked :" + daysworked + "\nHours worked : "
				+ hoursworked + "\nSundays worked : "
				+ findworker(name).sundaysworked);

	}

	public void printworkstats(String name) {
		int daysworked = 0;
		int hoursworked = 0;

		for (int i = 0; i < week.length; i++) {
			for (int x = 0; x < week[i].day.length; x++) {
				for (int y = 0; y < week[i].day[x].day.workersonshift.length; y++) {
					if (week[i].day[x].day.workersonshift[y] != null
							&& week[i].day[x].day.workersonshift[y].name
									.equals(name)) {
						daysworked++;
						hoursworked = hoursworked + week[i].day[x].day.worktime;

					}

				}
				for (int y = 0; y < week[i].day[x].afternoon.workersonshift.length; y++) {
					if (week[i].day[x].afternoon.workersonshift[y] != null
							&& week[i].day[x].afternoon.workersonshift[y].name
									.equals(name)) {
						daysworked++;
						hoursworked = hoursworked
								+ week[i].day[x].afternoon.worktime;

					}
				}
				for (int y = 0; y < week[i].day[x].night.workersonshift.length; y++) {
					if (week[i].day[x].night.workersonshift[y] != null
							&& week[i].day[x].night.workersonshift[y].name
									.equals(name)) {
						daysworked++;
						hoursworked = hoursworked
								+ week[i].day[x].night.worktime;

					}
				}

			}

		}
		System.out.println(name + "\nDays worked :" + daysworked
				+ "\nHours worked : " + hoursworked + "\nSundays worked : "
				+ findworker(name).sundaysworked);

	}

	public static String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}

	public void printday(int daynumber) {
		day tmp = getday(daynumber);
		System.out.println("**************************"
				+ padRight("   Day " + Integer.toString(tmp.daynumber), 10)
				+ "*************************");
		System.out.print(padRight("|       DAY", 20));
		System.out.print(padRight("|      AFTERNOON", 20));
		System.out.print(padRight("|       NIGHT", 20));
		System.out.print("|\n");

		for (int i = 0; i < 8; i++) {
			if (tmp.day.workersonshift.length > i) {
				if (tmp.day.workersonshift[i] != null) {
					System.out.print(padRight("|"
							+ tmp.day.workersonshift[i].name, 20));
				} else {
					System.out.print("|Vikar              ");
				}

			}
			if (tmp.afternoon.workersonshift.length > i) {
				if (tmp.afternoon.workersonshift[i] != null) {
					if (i > 5) {
						System.out.print(padRight("                    |"
								+ tmp.afternoon.workersonshift[i].name, 20));
					} else {
						System.out.print(padRight("|"
								+ tmp.afternoon.workersonshift[i].name, 20));
					}
				} else {
					if (i > 5) {
						System.out
								.print("                    |Vikar              ");
					} else {
						System.out.print("|Vikar              ");
					}

				}

			}
			if (tmp.night.workersonshift.length > i) {
				if (tmp.night.workersonshift[i] != null) {
					System.out.print(padRight("|"
							+ tmp.night.workersonshift[i].name, 20));
					System.out.print("|");
				} else {
					System.out.print("|Vikar              ");
				}

			}

			System.out.println();
		}
		System.out
				.println("*************************************************************");
	}

	public void printturnus() {
		for (int i = 0; i < 7 * 12; i++) {
			printday(i);

		}
	}

	public void printdaytofile(int daynumber, String filename, String dir)
			throws FileNotFoundException {

		File folder = new File(dir);

		if (!folder.exists()) {
			new File(dir).mkdir();
		}
		File output = new File(dir + "/" + filename + ".txt");
		PrintWriter printer = new PrintWriter(output);

		day tmp = getday(daynumber);
		printer.println("**************************"
				+ padRight("   Day " + Integer.toString(tmp.daynumber), 10)
				+ "*************************");
		printer.print(padRight("|       DAY", 20));
		printer.print(padRight("|      AFTERNOON", 20));
		printer.print(padRight("|       NIGHT", 20));
		printer.println("|\n");

		for (int i = 0; i < 8; i++) {
			if (tmp.day.workersonshift.length > i) {
				if (tmp.day.workersonshift[i] != null) {
					printer.print(padRight(
							"|" + tmp.day.workersonshift[i].name, 20));
				} else {
					printer.print("|Vikar              ");
				}

			}
			if (tmp.afternoon.workersonshift.length > i) {
				if (tmp.afternoon.workersonshift[i] != null) {
					if (i > 5) {
						printer.print(padRight("                    |"
								+ tmp.afternoon.workersonshift[i].name, 20));
					} else {
						printer.print(padRight("|"
								+ tmp.afternoon.workersonshift[i].name, 20));
					}
				} else {
					if (i > 5) {
						printer.print("                    |Vikar              ");
					} else {
						printer.print("|Vikar              ");
					}

				}

			}
			if (tmp.night.workersonshift.length > i) {
				if (tmp.night.workersonshift[i] != null) {
					printer.print(padRight("|"
							+ tmp.night.workersonshift[i].name, 20));
					printer.print("|");
				} else {
					printer.print("|Vikar              ");
				}

			}

			printer.println("\n");
		}
		printer.println("*************************************************************");
		printer.close();
	}

	public void printturnustofile(String dir) throws FileNotFoundException {
		for (int i = 0; i < 12; i++) {
			for (int x = 0; x < 7; x++) {
				printdaytofile(week[i].day[x].daynumber,
						Integer.toString(week[i].day[x].daynumber), dir);

			}

		}
	}

	public void printturnustofile(String filename, String dir)
			throws FileNotFoundException {

		File folder = new File(dir);

		if (!folder.exists()) {
			new File(dir).mkdir();
		}
		File output = new File(dir + "/" + filename + ".txt");
		PrintWriter printer = new PrintWriter(output);

		day tmp = week[0].day[0];
		

		for (int x = 0; x < week.length; x++) {

			for (int y = 0; y < 7; y++) {
				tmp = week[x].day[y];
				printer.println("**************************"
						+ padRight("   Day " + Integer.toString(tmp.daynumber), 10)
						+ "*************************");
				printer.print(padRight("|       DAY", 20));
				printer.print(padRight("|      AFTERNOON", 20));
				printer.print(padRight("|       NIGHT", 20));
				printer.println("|\n");
				for (int i = 0; i < 8; i++) {
					if (tmp.day.workersonshift.length > i) {
						if (tmp.day.workersonshift[i] != null) {
							printer.print(padRight("|"
									+ tmp.day.workersonshift[i].name, 20));
						} else {
							printer.print("|Vikar              ");
						}

					}
					if (tmp.afternoon.workersonshift.length > i) {
						if (tmp.afternoon.workersonshift[i] != null) {
							if (i > 5) {
								printer.print(padRight("                    |"
										+ tmp.afternoon.workersonshift[i].name,
										20));
							} else {
								printer.print(padRight("|"
										+ tmp.afternoon.workersonshift[i].name,
										20));
							}
						} else {
							if (i > 5) {
								printer.print("                    |Vikar              ");
							} else {
								printer.print("|Vikar              ");
							}

						}

					}
					if (tmp.night.workersonshift.length > i) {
						if (tmp.night.workersonshift[i] != null) {
							printer.print(padRight("|"
									+ tmp.night.workersonshift[i].name, 20));
							printer.print("|");
						} else {
							printer.print("|Vikar              ");
						}

					}

					printer.println("\n");
				}printer.println("*************************************************************");
			}
		}
		
		printer.close();
	}

}
