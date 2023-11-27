import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", 0, a);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", -2, a);
		
	}
	
	@Test
	public void testWrongStringLength() {
		String too_long = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931";
		String too_short = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
		String empty = "";
		int a = v.verify(too_long);
		assertEquals("too_long string", -1, a);
		a = v.verify(too_short);
		assertEquals("too_short string", -1, a);
		a = v.verify(empty);
		assertEquals("empty string", -1, a);
	}
	
	@Test
	public void testUnicodeChars() {
		String slash_first = "/17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String slash_last = "41736982563215894795872431682543716979158643234691275828964357157329168416487529/";
		
		int a = v.verify(slash_first);
		assertEquals("slash_first string", 1, a);
		a = v.verify(slash_last);
		assertEquals("slash_last string", 1, a);
		
		String colon_first = ":17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String colon_last = "41736982563215894795872431682543716979158643234691275828964357157329168416487529:";
		
		a = v.verify(colon_first);
		assertEquals("colon_first string", 1, a);
		a = v.verify(colon_last);
		assertEquals("colon_last string", 1, a);
		
		String math = "Ω≈ç√∫˜µ≤≥÷32158947958724316825437169791586432346912758289643571573291684164875293";
		String arabic = "ٵڊڼڋ69825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		
		a = v.verify(math);
		assertEquals("math string", 1, a);
		a = v.verify(arabic);
		assertEquals("arabic string", 1, a);
	}
	
	@Test
	public void testZero() {
		String zero_first = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String zero_last = "417369825632158947958724316825437169791586432346912758289643571573291684164875290";
		
		int a = v.verify(zero_first);
		assertEquals("zero_first string", -1, a);
		a = v.verify(zero_last);
		assertEquals("zero_last string", -1, a);
	}
	
	@Test
	public void testInvalidSubGrid() {
		String firstSubgridHasDiplicate = "417369825432158947958724316825437169791586432346912758289643571573291684164875293";
		String lastSubgridHasDiplicate = "417369825632158947958724316825437169791586432346912758289643571573291684164875233";
		
		int a = v.verify(firstSubgridHasDiplicate);
		assertEquals("firstSubgridHasDiplicate string", -2, a);
		a = v.verify(lastSubgridHasDiplicate);
		assertEquals("lastSubgridHasDiplicate string", -2, a);
	}
	
	@Test
	public void testInvalidRow() {
		String firstRowHasDiplicate = "617369825432158947958724316825437169791586432346912758289643571573291684164875293";
		String lastRowHasDiplicate = "417369825632158947958724316825437169791586432346912758289643571573291683164875294";
		
		int a = v.verify(firstRowHasDiplicate);
		assertEquals("firstRowHasDiplicate string", -3, a);
		a = v.verify(lastRowHasDiplicate);
		assertEquals("lastRowHasDiplicate string", -3, a);
	}
	
	@Test
	public void testInvalidColumn() {
		String firstColumnHasDiplicate = "147369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String lastColumnHasDiplicate = "417369825632158947958724316825437169791586432346912758289643571573291684164875239";
		
		int a = v.verify(firstColumnHasDiplicate);
		assertEquals("firstColumnHasDiplicate string", -4, a);
		a = v.verify(lastColumnHasDiplicate);
		assertEquals("lastColumnHasDiplicate string", -4, a);
	}
	
}
