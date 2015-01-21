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
public class Radar {

	private int middleX, middleY, endX, endY;
	private double angle = 0;
	private double anglespeed = 1;
	private int radius = 256;
	
	/**
	 * 
	 */
	public Radar() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Sets the basic parameters of the radar scope
	 * @param client
	 */
	public Radar(Client client){
		endX = client.getWidth() / 2 + radius;
		endY = client.getHeight() / 2;
	}
	
	/**
	 * Calculates the coordinates of the radar scope's beginning/end
	 * @param client
	 */
	public void update(Client client){
		middleX = client.getWidth() / 2;
		middleY = client.getHeight() / 2;
		
		endX = (int) (client.getWidth() / 2 + Math.cos(angle * Math.PI / 180));
		endY = (int) (client.getHeight() / 2 + Math.sin(angle * Math.PI / 180));
		
		angle += anglespeed;
	}
	
	/**
	 * 
	 */
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.drawLine(middleX, middleY, endX, endY);
		g.drawOval(middleX - radius, middleY - radius, radius * 2, radius * 2);
	}

}
