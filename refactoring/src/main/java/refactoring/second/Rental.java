package refactoring.second;


public class Rental {
	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	public int getDaysRented() {
		return _daysRented;
	}
	public Movie getMovie() {
		return _movie;
	}
	
	public double getCharge() {
		return _movie.getCharge(getDaysRented());
	}
	
	public int getFrequentRenterPoints() {
		// 최신물이면서 2일이상 대여시 2포인트, 그외는 1포인트 적립.
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}
