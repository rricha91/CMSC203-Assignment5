public class HolidayBonus {
	private static final double HIGH_BONUS = 5000;
	private static final double LOW_BONUS = 1000;
	private static final double OTHER_BONUS = 2000;


// pass in a two dimensional ragged array of doubles,
// uses the bonus value for highs, lows, and for others.
// and returns the an array of doubles which represents
// the holiday bonuses for each of the stores in the district.
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bns = new double[data.length];

    	for (int i = 0; i < data.length; i++){
    		int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
    		int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,i);
    		for (int j=0; j < data[i].length; j++)
    			if (j < data[i].length) {
    				if (i == highIndex) bns[i] += HIGH_BONUS;
    				else if (i == lowIndex) bns[i] += LOW_BONUS;
    				else bns[i] += OTHER_BONUS;
    			}
    	}
    	
    	return bns;
    }

 // pass in a two dimensional ragged array of doubles,
 // uses the bonus value for highs, lows, and for others.
 // returns a double which represents the total of all Holiday Bonuses for
 // the District.
    public static double calculateTotalHolidayBonus(double[][] data) {
    	double holidayTotal = 0.0;
    	for (int i = 0; i < data.length; i++){
    		int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
    		int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,i);
    		for (int j=0; j < data[i].length; j++)
    			if (j < data[i].length) {
    				if (i == highIndex) holidayTotal += HIGH_BONUS;
    				else if (i == lowIndex) holidayTotal += LOW_BONUS;
    				else holidayTotal += OTHER_BONUS;
    			}
    	}
    	
    	return holidayTotal;
    }
}