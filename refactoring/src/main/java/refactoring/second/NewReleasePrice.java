package refactoring.second;

class NewReleasePrice extends Price {
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}
	@Override
	int getFrequentRenterPoints(int daysRented) {
		// 최신물이면서 2일이상 대여시 2포인트, 그외는 1포인트 적립.
		if (daysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}
