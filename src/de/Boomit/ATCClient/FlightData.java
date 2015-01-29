/**
 * 
 */
package de.Boomit.ATCClient;

/**
 * @author Johannes Hoppenstedt
 * (c) 2015 All rights reserved.
 *
 */
public class FlightData {

	public String[] airlines;
	public int[] startheights;
	public int[] startspeeds;
	public String flightnumber;
	
	/**
	 * 
	 */
	public FlightData() {
		// TODO Auto-generated constructor stub
		airlines = new String[] {"DLH", "BA", "AB", "GW", "RY"};
		startheights = new int[] {150, 140, 80, 120, 160};
		startspeeds = new int[] {29, 28, 44, 35, 42, 37, 48};
	}

	/**
	 * 
	 * @return
	 */
	public String newFlightName() {
		flightnumber = String.valueOf((int) (Math.random() * 8 +1))
				+ String.valueOf((int) (Math.random() * 8 + 1))
				+ String.valueOf((int) (Math.random() * 8 + 1));
		return airlines[(int) (Math.random() * airlines.length)] + flightnumber;
	}
	
	/**
	 * 
	 * @return
	 */
	public int newStartHeight(){
		return startheights[(int) (Math.random() * startheights.length)];
	}
	
	/**
	 * 
	 * @return
	 */
	public int newStartSpeed() {
		return startspeeds[(int) (Math.random() * startspeeds.length)];
	}

	/**
	 * 
	 * @return
	 * Not implemented
	 */
	public double newStartHeading() {
		return 135;
	}

	/**
	 * 
	 * @return
	 * Not implemented
	 */
	public int newEntryX() {
		return 400;
	}

	/**
	 * 
	 * @return
	 * Not implemented
	 */
	public int newEntryY() {
		return 300;
	}
	
}
