package refactoring.first;

import java.util.Enumeration;
import java.util.Vector;

import refactoring.first.Rental;
import refactoring.first.Movie;

public class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	
	public Customer(String name) {
		_name = name;
	}
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	public String getName() {
		return _name;
	}
	public String statement() {
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = getName() + " 고객님의 대여 기록\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			// 이번에 대여하는 비디오 정보와 대여료를 출력
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
			
		}
		
		// footer 행 추가
		result += "누적 대여료 : " + String.valueOf(getTotalCharge()) + "\n";
		result += "적립 포인트 : " + String.valueOf(frequentRenterPoints);
		return result;
	}
	
	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			// 현재까지 누적된 총 대여료
			result += each.getCharge();
		}
		return result;
	}
	
}
