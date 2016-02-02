/**
 * 
 */
package _1_enhancements;

/**
 * @author Andres
 *
 */
public class Literals {

	/**
	 * 
	 */
	public Literals() {
		// TODO Auto-generated constructor stub
	}
	
	public void metodo(){
		// An 8-bit 'byte' value:
		byte aByte = 0b00100001;

		// A 16-bit 'short' value:
		short aShort = 0b0010001010001010;

		// Some 32-bit 'int' values:
		int anInt1 = 0b10100001010001011010000101000101;
		int anInt2 = 0b101;
		int anInt3 = 0B101; // The B can be upper or lower case.

		// A 64-bit 'long' value. Note the "L" suffix:
		long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;

		// OK, implicit casting int to float or double variable
		float  f1 = 0b0001;
		double d1 = 0b0001;

		// COMPILATION FAILS! Binary literal can only be of integer type (byte, char, int, long),
		// while 'd' or 'f' suffixes explicitly say these are decimal point type literals
//		double d2 = 0b0001d;
//		float  f2 = 0b0001f;
//		Invalid (compilable, but logical error):

			int x1 = 52_1;              // This is an identifier, not a numeric literal
					
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long creditCardNumber = 1234_5678_9012_3456L;
		long socialSecurityNumber = 999_99_9999L;
		float pi = 3.14_15F;
		long hexBytes = 0xFF_EC_DE_5E;
		long hexWords = 0xCAFE_BABE;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		byte nybbles = 0b0010_0101;
		long bytes = 0b11010010_01101001_10010100_10010010;
		
		int numerito = 52_1;
		
		System.out.println(numerito);
	}

}
