package refactoring.second;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;
	
	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}
	
	public int getPriceCode() {
		return _priceCode;
	}
	
	public void getPriceCode(int priceCode) {
		this._priceCode = priceCode;
	}
	public String getTitle() {
		return _title;
	}
	
	public double getCharge(int daysRented) {
		double result = 0;
		// 비디오 종류별 대여료 계산
		switch (getPriceCode()) {
			case Movie.REGULAR:
				result += 2;
				if (daysRented > 2) {
					result += (daysRented -2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				result += daysRented * 3;
				break;
			case Movie.CHILDRENS:
				result += 1.5;
				if (daysRented > 3) {
					result += (daysRented -3) * 1.5;
				}
				break;
		}
		return result;
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		// 최신물이면서 2일이상 대여시 2포인트, 그외는 1포인트 적립.
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}
