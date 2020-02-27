package refactoring.org;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	Rental rental1;
	Rental rental2;
	
	@BeforeEach
	public void setup() {
		Movie movie01 = new Movie("OnePiece", Movie.CHILDRENS);
		Movie movie02 = new Movie("Speed", Movie.REGULAR);
		Movie movie03 = new Movie("NamHan", Movie.NEW_RELEASE);
		Movie movie04 = new Movie("Metrix", Movie.REGULAR);
		Movie movie05 = new Movie("Metrix II", Movie.REGULAR);
		
		rental1 = new Rental(movie01, 5);
		rental2 = new Rental(movie02, 10);
	}

	@Test
	void statementTest() {
		String expect = "배성한 고객님의 대여 기록\n" + 
				"	OnePiece	4.5\n" + 
				"	Speed	14.0\n" + 
				"누적 대여료 : 18.5\n" + 
				"적립 포인트 : 2";
		Customer customer = new Customer("배성한");
		customer.addRental(rental1);
		customer.addRental(rental2);
		String statement = customer.statement();
		assertEquals(expect, statement);
	}

}
