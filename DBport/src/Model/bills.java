package Model;

public class bills {
int time,bid ;
String process;
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public int getbid() {
	return bid;
}
public void setbid(int amt) {
	this.bid = amt;
}
public String getProcess() {
	return process;
}
public void setProcess(String process) {
	this.process = process;
}
public bills(int time, int bid, String process) {
	super();
	this.time = time;
	this.bid = bid;
	this.process = process;
}
public bills(int i, int j, int k, String string) {
	// TODO Auto-generated constructor stub
}



}
