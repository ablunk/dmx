package desmoj.extensions.space3D;
import desmoj.extensions.dimensions.Length;

/**
 * This is an extension of the desmoj.extensions.dimensions.Unit class.
 * It overrides the isValidValue method so the negative Values can be accepted.
 * (For avoiding the handling with the unit codes 
 * more specific setting and getting methods are added.)
 * 
 * @author Fred Sun
 */

public class ExtendedLength extends Length {

	public ExtendedLength() {
		super();
	}

	public ExtendedLength(double value, int unit) {
		super(value, unit);
	}
	
/*	public lengthUnit(double value, String unit){
		//a invalid unit code for the case that no unit string is matched
		int unitcode=-1;
		if((unit=="mm")||(unit=="millimeter")||(unit=="Mm")||(unit=="Millimeter")){
			unitcode = 4;
		}else if((unit=="cm")||(unit=="centimeter")||(unit=="Cm")||(unit=="Centimeter")){
			unitcode = 5;
		}else if((unit=="m")||(unit=="meter")||(unit=="M")||(unit=="Meter")){
			unitcode = 6;
		}else if((unit=="km")||(unit=="kilometer")||(unit=="Km")||(unit=="Kilometer")){
			unitcode = 7;
		}else{
			System.out.println("Warning: the unit ment to be created doesn't match the " +
					"units from the desmoj.core.simulatior.Units class or it's not spelled" +
					"corrctly. A instance with zero value will be created.");
		}		
	}*/
	

	/**
	 * overrides the original isValidValue method from the 
	 * desmoj.extensions.dimensions.Unit class.
	 * Now it always returns true, so the negative values
	 * can be accepted.
	 */
	public boolean isValidValue(double value){
		return true;		
	}
}
