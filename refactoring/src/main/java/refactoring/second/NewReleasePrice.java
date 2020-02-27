package refactoring.second;

class NewReleasePrice extends Price {
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}
}
