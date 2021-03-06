package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * My Regex Tester. Test is String a long or double
 * 
 * @author HE Junyang
 *
 */
public class Regex {


    public static final String DIGITS = "(\\p{Digit}+)";
    public static final String HEX_DIGITS = "(\\p{XDigit}+)";

    // an exponent is 'e' or 'E' followed by an optionally
    // signed decimal integer.
    public static final String EXP = "[eE][+-]?" + DIGITS;
	
	/**
	 * test is a String a double.
	 * 
	 * @param str
	 *            String for test
	 * @return true if is a double, false if not
	 */
	public static boolean isDouble(String str) {
		String regEx = 
				//"[\\x00-\\x20]*" +  // Optional leading "whitespace"
	            "[+-]?(" + // Optional sign character
	            "NaN|" +           // "NaN" string
	            "Infinity|" +      // "Infinity" string

	            // A decimal floating-point string representing a finite positive
	            // number without a leading sign has at most five basic pieces:
	            // Digits . Digits ExponentPart FloatTypeSuffix
	            //
	            // Since this method allows integer-only strings as input
	            // in addition to strings of floating-point literals, the
	            // two sub-patterns below are simplifications of the grammar
	            // productions from section 3.10.2 of
	            // The Java™ Language Specification.

	            // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
	            "(((" + DIGITS + "(\\.)?(" + DIGITS + "?)(" + EXP + ")?)|" +

	            // . Digits ExponentPart_opt FloatTypeSuffix_opt
	            "(\\.(" + DIGITS + ")(" + EXP + ")?)|" +

	            // Hexadecimal strings
	            "((" +
	            // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
	            "(0[xX]" + HEX_DIGITS + "(\\.)?)|" +

	            // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
	            "(0[xX]" + HEX_DIGITS + "?(\\.)" + HEX_DIGITS + ")" +

	            ")[pP][+-]?" + DIGITS + "))" +
	            "[fFdD]?))";
	            //+
	            //"[\\x00-\\x20]*"; // Optional trailing "whitespace"
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(str);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * test is a String a long.
	 * 
	 * @param str
	 *            String for test
	 * @return true if is a long, false if not
	 */
	public static boolean isLong(String str) {
		String regEx = "^-?[0-9]+$";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(str);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * test is a String an integer.
	 * 
	 * @param str
	 *            String for test
	 * @return true if is an integer, false if not
	 */
	public static boolean isInteger(String str) {
			String regEx = "^[1-9]\\d{0,8}$";
			Pattern pat = Pattern.compile(regEx);
			Matcher mat = pat.matcher(str);
			if (mat.matches()) {
				return true;
			} else {
				return false;
			}
	}
	
	public static boolean isName (String str) {
		String regEx = "^[\\p{L} .'-]+$";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(str);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * main method, for testing.
	 * 
	 * @param args
	 *            for main
	 */
	public static void main(String[] args) {
//		System.out.println("Is double : ");
//		System.out.println(isDouble("3.1231"));
//		System.out.println(isDouble("3"));
//		System.out.println(isDouble(".1231"));
//		System.out.println(isDouble("-3.1231"));
//		System.out.println(isDouble("434531234537513"));
//		System.out.println(isDouble("00123"));
//		System.out.println(isDouble("00"));
//		System.out.println(isDouble("0"));
//		System.out.println(isDouble("10"));
//		System.out.println(isDouble("10 "));
//		System.out.println(isDouble("1.020 "));
//		System.out.println(isDouble(" 1.020"));
//		System.out.println(isDouble("&2)"));
//		System.out.println(isDouble("2é"));
//		System.out.println(isDouble("2e"));
//
//		System.out.println("Is long : ");
//		System.out.println(isLong("3.1231"));
//		System.out.println(isLong("3"));
//		System.out.println(isLong(".1231"));
//		System.out.println(isLong("-3.1231"));
//		System.out.println(isLong("434531234537513123123"));
//		System.out.println(isLong("-434531234537513123123"));
//		System.out.println(isDouble("00123"));
//		System.out.println(isDouble("00"));
//		System.out.println(isDouble("0"));
//		System.out.println(isDouble("10"));

//		System.out.println("Is integer : ");
//		System.out.println(isInteger("3.1231"));
//		System.out.println(isInteger("3"));
//		System.out.println(isInteger(".1231"));
//		System.out.println(isInteger("-3.1231"));
//		System.out.println(isInteger("434531234537513123123"));
//		System.out.println(isInteger("-434531234537513123123"));
//		System.out.println(isInteger("00123"));
//		System.out.println(isInteger("0"));
//		System.out.println(isInteger("-10"));
//		System.out.println(isInteger("0123456789"));
//		System.out.println(isInteger("123456789"));
//		System.out.println(isInteger("1234567890"));

		System.out.println("isName : ");
		System.out.println(isName("&qsdqsd"));
		System.out.println(isName("azqsdqsdqar"));
		System.out.println(isName("sdqsd&"));
		System.out.println(isName("1234"));
		System.out.println(isName("nathen Kun"));
	}

}
