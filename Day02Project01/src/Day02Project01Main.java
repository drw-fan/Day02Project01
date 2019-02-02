/******* Advent of Code Day 02 Project 01   *************/

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Day02Project01Main {
	public static void main(String[] args) {
		String boxID;
		int twoTimes=0, threeTimes=0;
		
		try {
			File myFile = new File("boxIDs.txt");
			Scanner inputFile = new Scanner(myFile);

			while (inputFile.hasNext()) {
				boxID = inputFile.nextLine();
				threeTimes += findThreeTimes(boxID);
				twoTimes += findTwoTimes(boxID);
			}

			inputFile.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("File IO error!");
		}
	
		System.out.println("twoTimes = " + twoTimes);
		System.out.println("threeTimes = " + threeTimes);
		System.out.println("checksum = " + (twoTimes*threeTimes));

	}
	
	static int findTwoTimes(String pboxID) {
		int numTimes=0;
		boolean inTwoTimes=false;
		
		for (int i=0; i<pboxID.length(); i++) {
			for (int j=0; j<pboxID.length(); j++) {
				if (pboxID.charAt(i) == pboxID.charAt(j)) {
					numTimes++;
				}
			}
			if (numTimes == 2) {
				inTwoTimes = true;
				break;
			}
			else numTimes = 0;
		}
		
		if (inTwoTimes)
			return 1;
		else
			return 0;
	}

	static int findThreeTimes(String pboxID) {
		int numTimes=0;
		boolean inThreeTimes=false;
		
		for (int i=0; i<pboxID.length(); i++) {
			for (int j=0; j<pboxID.length(); j++) {
				if (pboxID.charAt(i) == pboxID.charAt(j))
					numTimes++;
			}
			
			if (numTimes == 3) {
				inThreeTimes = true;
				break;
			}
			else numTimes = 0;
		}
		
		if (inThreeTimes)
			return 1;
		else
			return 0;
	}

}
