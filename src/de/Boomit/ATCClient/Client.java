/**
 * 
 */
package de.Boomit.ATCClient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;


/**
 * @author Johannes Hoppenstedt
 * (c) 2015 All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class Client extends JFrame{

	//Basic variables
	public static String version = "v. 0.1";
	public static String name = "ATC Simulator";
	
	public static Client client;
	public Radar radar = new Radar(this);
	public ArrayList<FlightData> flights = new ArrayList<FlightData>();
	
	private Image i;
	private Graphics doubleG;
	
	
	/**
	 * 
	 */
	public Client() {
		// TODO Auto-generated constructor stub
		
		super(name + " " + version);
		super.setSize(900, 700);
		super.setLocation(50, 50);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.getContentPane().setBackground(Color.BLACK);
		super.setResizable(false);
		super.setVisible(true);
				
		Thread radarthread = new Thread("radar"){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while(true){
					radar.update(client);
					repaint();
					
					try {
						Thread.sleep(27);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		radarthread.start();
		
		Thread flightthread = new Thread("flight"){
			
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				GenerateFlightData flightdatagenerator = new GenerateFlightData();
				while(true){
					flights.add(new FlightData(flightdatagenerator.newEntryX(), flightdatagenerator.newEntryY(), 
							flightdatagenerator.newStartHeight(), flightdatagenerator.newStartSpeed(), 
							flightdatagenerator.newStartHeading(), flightdatagenerator.newFlightName()));
					try {
						this.sleep(9000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		flightthread.start();
	}
	
	/**
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		radar.paint(g);
		for(FlightData fl : flights){
			fl.paint(g);
		}
	}
	
	/**
	 * @param g
	 */
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
		
		if(i == null){
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}
		
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		doubleG.setColor(getForeground());
		
		paint(doubleG);
		g.drawImage(i, 0, 0, this);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		client = new Client();
	}

}
