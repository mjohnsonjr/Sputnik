package sputnik.util.pkt;

import java.io.Serializable;
import java.util.Vector;

import sputnik.server.util.Connection;
import sputnik.util.Location;
import sputnik.util.Player;

public class UDPPacket implements Serializable {
	
	private static final long serialVersionUID = -4456279889398099120L;
	
	private Vector<Connection> connections;
	private Player thisPlayer;
	private Location location;
	
	public Vector<Connection> getConnections() {
		return connections;
	}
	public Player getThisPlayer() {
		return thisPlayer;
	}
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setConnections(Vector<Connection> connections) {
		this.connections = connections;
	}
	public void setThisPlayer(Player thisPlayer) {
		this.thisPlayer = thisPlayer;
	}
}
