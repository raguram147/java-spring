package Model;
//import Controller.BTControl;

public class Boat {
	
	// stores data
		String boatName;
		int boatNumber;
		int boatCapacity;
		public String getBoatName() {
			return boatName;
		}
		public void setBoatName(String boatName) {
			this.boatName = boatName;
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
		public Boat(int boatNumber, String boatName, int boatCapacity) {
			super();
			this.boatName = boatName;
			this.boatNumber = boatNumber;
			this.boatCapacity = boatCapacity;
		}
		
		

	}

