package Main;

import java.io.FileNotFoundException;
import java.util.Date;

import Objects.ReadWriter;
import Objects.Turnus;
import Objects.Week;
import Objects.Worker;
import Objects.day;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

	/*
		Worker per = new Worker("Per", true, true, true, 1);
		Worker arne = new Worker("Arne", true, true, true, 1);
		Worker anon = new Worker("Anon", true, true, true, 1);
		Worker  artorias = new Worker("Arotrias", true, true, true, 1);
		Worker solaire = new Worker("Solaire", true, true, true, 1);
		Worker karl = new Worker("Karl", true, true, true, 1);
		Worker trevor = new Worker("Trevor", true, true, true, 1);
		Worker snake = new Worker("Snake", true, true, true, 1);
		Worker lucian = new Worker("Lucian", true, true, true, 1);
		Worker anna = new Worker("Anna", true, true, true, 1);
		Worker thomas = new Worker("Thomas", true, true, true, 1);
		Worker nils = new Worker("Nils", true, true, true, 1);
		Worker andreas = new Worker("Andreas", true, true, true, 1);
		Worker jorgen = new Worker("Jorgen", true, true, true, 1);
	
		Worker jakob = new Worker("Jakob", true, true, true, 1);
		
		Worker fillip = new Worker("Fillip", true, true, true, 1);
		
		Worker ida = new Worker("Ida", true, true, true, 1);
		
		Turnus ting = new Turnus(0);

		ting.workerbase.add(per);
		ting.workerbase.add(arne);
		ting.workerbase.add(anon);
		ting.workerbase.add(artorias);
		ting.workerbase.add(solaire);
		ting.workerbase.add(karl);
		ting.workerbase.add(trevor);
		ting.workerbase.add(snake);
		ting.workerbase.add(lucian);
		ting.workerbase.add(anna);
		ting.workerbase.add(thomas);
		ting.workerbase.add(nils);
		ting.workerbase.add(andreas);
		ting.workerbase.add(jorgen);
		ting.workerbase.add(fillip);
		ting.workerbase.add(jakob);
		
		
		ting.workerbase.add(ida);
		
		per.cannotwork(0, 3);
		
		ting.maketurnus();

		ting.printworkerstats();
		ting.printplan("Per");
	
		*/
	
		Turnus ting = new Turnus(0);

		ting.loadworkers("src/workerbase");

		ting.maketurnus();
	
		ting.printturnus();	
		
		ting.printworkstats("Per");

ting.printturnustofile("src/test1");
ting.printturnustofile("test", "src/test2");
	}
}