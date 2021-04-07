package GUI;

import java.util.ArrayList;


public class boat  {

// stores data
	String boatName;
	String boatType;
	int boatNumber;
	int boatCapacity;
	public String getBoatName() {
		return boatName;
	}
	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}
	public String getBoatType() {
		return boatType;
	}
	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}
	public int getBoatNumber() {
		return boatNumber;
	}
	public void setBoatNumber(int boatNumber) {
		this.boatNumber = boatNumber;
	}
	public int getBoatCapacity() {
		return boatCapacity;
	}
	public void setBoatCapacity(int boatCapacity) {
		this.boatCapacity = boatCapacity;
	}
	public boat(String boatName, String boatType, int boatNumber, int boatCapacity) {
		super();
		this.boatName = boatName;
		this.boatType = boatType;
		this.boatNumber = boatNumber;
		this.boatCapacity = boatCapacity;
	}
	
	

}