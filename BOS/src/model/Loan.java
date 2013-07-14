package model;

import java.util.Date;

public class Loan {

	Date begin;
	Date end;
	Date received;
	double penalty;
	
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Date getReceived() {
		return received;
	}
	public void setReceived(Date received) {
		this.received = received;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	
	
	
}
