/**
 * 
 */
package de.Boomit.ATCClient;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Johannes Hoppenstedt
 * (c) 2015 All rights reserved.
 *
 */
public class FlightData {

	public int flheight, flspeed;
	public double posx, posy, flheading;
	public String flname;
	public int newheight = 0, newspeed = 0, newheading = 0;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param height
	 * @param speed
	 * @param heading
	 * @param name
	 */
	public FlightData(int x, int y, int height, int speed, double heading, String name) {
		// TODO Auto-generated constructor stub
		flheight = height;
		flspeed = speed;
		flname = name;
		flheading = heading;
		posx = x;
		posy = y;
		System.out.println(flname);
		System.out.println(flheight + " " + flspeed);
	}

	/**
	 * 
	 * @param client
	 */
	public void update(Client client){
		posx = posx + Math.round(Math.sin(flheading * Math.PI / 180)) * 0.0025 * flspeed;
		posy = posy - Math.round(Math.cos(flheading * Math.PI / 180)) * 0.0025 * flspeed;
		flheading = newheading;
		if(flspeed != newspeed && newspeed != 0){
			System.out.println(newspeed);
			System.out.println(flspeed);
			if(flspeed > newspeed)
			{
				flspeed -= 1;
			}
			else if (flspeed < newspeed){
				flspeed += 1;
			}
		}
	}
	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g){
		g.setColor(Color.green);
		g.drawRect((int) posx, (int) posy, 4, 4);
		g.drawString(flname, (int) posx + g.getFont().getSize(), (int) posy
				+ g.getFont().getSize());
		g.drawString(flheight + " " + flspeed, (int) posx
				+ g.getFont().getSize(), (int) posy + 2 * g.getFont().getSize());
		if (newheight != 0 || newspeed != 0) {
			if (newheight != 0 && newspeed == 0) {
				g.drawString(String.valueOf(newheight), (int) posx
						+ g.getFont().getSize(), (int) posy + 3
						* g.getFont().getSize());
			} else if (newheight == 0 && newspeed != 0) {
				g.drawString("        " + newspeed, (int) posx
						+ g.getFont().getSize(), (int) posy + 3
						* g.getFont().getSize());
			} else {
				g.drawString(newheight + " " + newspeed, (int) posx
						+ g.getFont().getSize(), (int) posy + 3
						* g.getFont().getSize());
			}
		}
	}
}
