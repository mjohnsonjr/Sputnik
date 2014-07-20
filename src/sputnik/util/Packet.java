package sputnik.util;

import java.util.Vector;

import sputnik.server.util.Connection;

public class Packet {
	
	private Vector<Connection> connections;
	private Player thisPlayer;
	
	public Vector<Connection> getConnections() {
		return connections;
	}
	public Player getThisPlayer() {
		return thisPlayer;
	}
	public void setConnections(Vector<Connection> connections) {
		this.connections = connections;
	}
	public void setThisPlayer(Player thisPlayer) {
		this.thisPlayer = thisPlayer;
	}
}
