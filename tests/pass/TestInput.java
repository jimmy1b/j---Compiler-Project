/*
 * ignore this
 *
 */
package pass;

import java.lang.System;

public class TestInput {

	/*
	 * this too
	 */
	public static void test() {
		int j = 5 + 5 ;
		j = 5 - 5 ;
		
		j = 5 * 5 ;
		
		j = 5 / 5 ;
		
		j = 5 % 5 ;
		
		j = 5 * 5 ;
		
		j++;
		
		j--;
		
		if (3 != 2 ) {
			
		}
		if (j == j ) {
			
		}
		if (j > j ) {
			
		}
		if (j >= j ) {
			
		}
		if (j < j ) {
			
		}
		if (j <= j) {
			
		}
		j += 2 ;
		j /= 2 ;
		j *= 2 ;
		j -= 2 ;
		
		boolean t = true;
		t = false;
		t = !t;
		if (t || t) {
			
		}
		if (t && t) {
			
		}
		t = t && t;
		t = t || t;
		double d = 3.0 ;
		float f = 3.0f;
		
		//not recognized
//		long g = 4L;
		
		j = (2 > 1 ) ? 1 : 2;
		int saaaaa = (2 > 1 ) ? 1 : 2; 
		
		do {
			
		} until (t);
		

//		do {
//			
//		} while (t);
		
		try {
			throw new Exception();
			
		} catch (Exception e) {
			
		} finally {
			//hhhh
			t = t && t;
		}
		
		/*
		 * 4.2 test
		 * expected to fail
		 */
//		int thisdontwork;
//		thisdoesnotexist = 1;
//		if (thisdoesnotexist == 0) thisdontwork = 0;
//		if (thisdoesnotexist == 1) thisdontwork = 1;
		
//		System.out.println("yes, hello");
		for(int i = 0; i < 3; i++) {
		
		}
		
		return;
		
		
/*
 * not implemented yet

		switch (j) {
        	case 3:
        		break;
        	default:
        		break;
		}
 * 
 */
	}
	
	public static int doUntil(int j) {
		//5.6
		int r = 0;
		do {
			r++;
		} until (r == j);
		return r;
	}
	
	public static int doWhile(int j) {
		//5.6
		int r = 0;
		do {
			r++;
		} while (r < j);
		return r;
	}
	
	public static int forLoop(int j) {
		//5.7
		int r = 0;
		for(int i = 0; i < j; i++) {
			r++;
		}
		return r;
	}
	
	public static boolean conditional(boolean j) {
		//5.11
		boolean r = j ? true : false;
		return r;
	}
	
	public static boolean conditionalOr(boolean j, boolean r) {
		//5.12
		return j || r;
	}
	
	public static int longLiteral(int j) {
		//5.21
		return 1;
	}

}

/*
*4.1 test
*expected to fail
*/


//public class stungss {
//	public why() {
//		System.out.println("why?");
//	}
//}
