import java.io.*;
import java.lang.runtime.SwitchBootstraps;
import java.util.Map;

/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: A class to read and manage 2D arrays of doubles pulled from text files.
 * Due: 4/17/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan RIchards
 */
class TwoDimRaggedArrayUtility {
	private static Map<Character, Character> mp = Singleton.getCharMap();
	
// pass in a file and return a two dimensional ragged array of doubles
	public static double[][] readFile(File file) {
		double[][] raggedArr = new double[6][];
		String line;
		int i = 0;				
		char[] arr;
		StringBuilder bil = new StringBuilder();
		boolean negCheck = false;
		int decPoint = -1;
		Character c;
		
		
		try{
			// open the file
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// read the file
			while ((line = br.readLine()) != null) {
				
				String[] temp = line.split(" ");
				int size = temp.length;
				raggedArr[i] = new double[size];

				// covert into doubles
				for (int j = 0; j < size; j++) {
					if ((temp[j]=="")==false) {
						arr = temp[j].toCharArray();
						for (int k = 0; k < arr.length; k++) {
							c = mp.get(arr[k]);
							
							if ((c==null)==false) {
								switch(c) {
								case '.': 
									if (decPoint == -1) {
										bil.append(c);
										decPoint = 0;
									}
									if (negCheck == false) negCheck = true;
									break;
								case '-':
									if (negCheck == false) {
										bil.append(c);
										negCheck = true;
									}
									break;
								default: 
									if ((decPoint == -1) == false) {
										if (decPoint == 2) break;
										else decPoint++;
									}
									bil.append(c);
									if (negCheck == false) negCheck = true;
									break;	
								}
							}
							
						}
						temp[j] = bil.toString();
						if (((temp[j] == "") == false) && ((temp[j] == "-") == false)) raggedArr[i][j] = Double.parseDouble(temp[j]);
						bil.delete(0, bil.length());
					}
					
					negCheck = false;
					decPoint = -1;
				}
				
				i++;
			}
			
			br.close();
			
		} catch (Exception ep) {
			ep.printStackTrace();
		}
	
	return raggedArr;
	}

	public static void writeToFile(double[][] raggedArr, File file) {
		try {
			// open the file
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
		
			// read the array and print into file with spaces
			for (int i = 0; i < raggedArr.length; i++) {
				for (int j = 0; j < raggedArr[i].length; j++) {
					br.write(raggedArr[i][j] + " ");
					}
				br.newLine();
				}
			br.close();
			} catch (Exception ep) {
				ep.printStackTrace();
			}
		}

	public static double getTotal(double[][] raggedArr) {
		double total = 0;
		
		// find the sum of the values of the 2D array
		for (int i = 0; i < raggedArr.length; i++) {
			for (int j = 0; j < raggedArr[i].length; j++) {
				total += raggedArr[i][j];
				}
			}
		return total;
		}

	
	@SuppressWarnings("removal")
	public static double getAverage(double[][] raggedArr) {
		double total = 0;
		int numOfElements = 0;
		
		// find the sum of the values of the 2D array
		for (int i = 0; i < raggedArr.length; i++) {
			for (int j = 0; j < raggedArr[i].length; j++) {
				total += raggedArr[i][j];
				numOfElements += 1;
				}
			}
		
		// find and return the average
		return new Double(total / numOfElements);
	}

	public static double getRowTotal(double[][] raggedArr, int rowIndex){
		double total = 0;
		for (int j = 0; j <raggedArr[rowIndex].length; j++) {
			total += raggedArr[rowIndex][j];
			}
		return total;
	}


	public static double getColumnTotal(double[][] raggedArr, int colIndex) {
		double total = 0;
		for (int i = 0; i < raggedArr.length; i++) {
			if (colIndex <= raggedArr[i].length - 1) total += raggedArr[i][colIndex];
			}
		return total;
	}

	public static double getHighestInRow(double[][] raggedArr, int rowIndex) {
		double highest = raggedArr[rowIndex][0];
		for (int j = 0; j < raggedArr[rowIndex].length; j++) {
			if (raggedArr[rowIndex][j] > highest) highest = raggedArr[rowIndex][j];
			}
		return highest;
	}

	public static int getHighestInRowIndex(double[][] raggedArr, int row) {
		int index = 0;
		for (int i = 0; i < raggedArr[row].length; ++i) {
			if (raggedArr[row][i] > raggedArr[row][index]) {
				index = i;
				}
			}
		return index;
	}


	public static double getLowestInRow(double[][] raggedArr, int rowIndex) {
		double lowest = raggedArr[rowIndex][0];
		for (int j = 0; j < raggedArr[rowIndex].length; j++) {
			if (raggedArr[rowIndex][j] < lowest) lowest = raggedArr[rowIndex][j];
			}
		return lowest;
		}

	public static int getLowestInRowIndex(double[][] raggedArr, int row) {
		int index = 0;
		for (int i = 0; i < raggedArr[row].length; ++i) {
			if (raggedArr[row][i] < raggedArr[row][index]) index = i;
			}
		return index;
	}

	public static double getHighestInColumn(double[][] raggedArr, int colIndex) {
		double highest = raggedArr[0][colIndex];
		for (int i = 0; i < raggedArr.length; i++) {
			if (colIndex <= raggedArr[i].length - 1) 
				if (raggedArr[i][colIndex] > highest) highest = raggedArr[i][colIndex];

		}
		return highest;
	}


	public static int getHighestInColumnIndex(double[][] raggedArr, int col_index) {
		// Variables
		double highest = 0;
		int index = 0;

		// Loops (Row => Column[c]) {
		for (int r = 0; r < raggedArr.length; r++) {
			// Checks
			if (raggedArr[r].length <= col_index || col_index < 0) { continue; }
			if (raggedArr[r][col_index] > highest) {
				highest = raggedArr[r][col_index];
				index = r;
			}
		}

		// Return
		return index;
	}


	public static double getLowestInColumn(double[][] raggedArr, int colIndex) {
		double lowest = raggedArr[0][colIndex];
		for (int i = 0; i < raggedArr.length; i++) {
			if (colIndex <= raggedArr[i].length - 1)
				if (raggedArr[i][colIndex] < lowest) lowest = raggedArr[i][colIndex];
			}
		return lowest;
	}


	public static int getLowestInColumnIndex(double[][] raggedArr, int col_index) {
		double lowest = 0;
		int index = 0;

		for (int r = 0; r < raggedArr.length; r++) {
			if (raggedArr[r].length <= col_index || col_index < 0) { continue; }
			if (lowest == 0 || raggedArr[r][col_index] < lowest) {
				lowest = raggedArr[r][col_index];
				index = r;
			}
		}

		return index;
	}

	public static double getHighestInArray(double[][] raggedArr) {
		double highest = raggedArr[0][0];
		for (int i = 0; i < raggedArr.length; i++) {
			for (int j = 0; j < raggedArr[i].length; j++) {
				if (raggedArr[i][j] > highest) highest = raggedArr[i][j];
				}
			}
		return highest;
	}

	public static double getLowestInArray(double[][] raggedArr) {
		double lowest = raggedArr[0][0];
		for (int i = 0; i < raggedArr.length; i++) {
			for (int j = 0; j < raggedArr[i].length; j++) {
				if (raggedArr[i][j] < lowest) lowest = raggedArr[i][j];
				}
			}
		return lowest;
	}
}
