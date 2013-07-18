/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
*/
package assignment1;

public class MatrixTester {
	public static void main(String[] args)
	{			
		Matrix M1 = new Matrix(new int[][]
		                                 {{1, 2, 3},
										  {2, 5, 6}});
		
		Matrix M2 = new Matrix(new int[][]
		                                 {{4, 5},
										  {3, 2},
										  {1, 1}});
		Matrix M3 = new Matrix(new int[][]{{1,2}, // create two identical matrices to test equal method
											 {3,4}});
		Matrix M4 = new Matrix(new int[][]{{1,2},
				 							{3,4}});
		Matrix M5 = new Matrix(new int[][]{{1,2},
											{4,5}});
		Matrix M6 = new Matrix(new int[][]{{-1,-1},//negative matrix
											{-2,-2}});
		Matrix M7 = new Matrix(new int[30][30]);//large matrix of zeros
		
		// this is the known correct result of multiplying M1 by M2
		Matrix referenceMultiply = new Matrix(new int[][]
		                                                {{13, 12},
														 {29, 26}});
		
		
		
		System.out.println("Your to string method computes " + '\n' + M3.toString() + "it should be 1 2,3 4");
		//this test the toString method on a simple 2x2 matrix
		
		System.out.println("Your to string method computes " + '\n' + M2.toString() + "it should be 4 5,3 2,1 1");
		//this test the toString on a larger matrix
		
		System.out.println("Your to string method computes " + '\n' + M7.toString() + "it should be a 30x30 zeros");
		//this test the toString on a very larger matrix
		
		System.out.println("Your equals method returns " + M3.equals(M4) + " when it should return true");
		//this test the equals method when it should return true
		
		System.out.println("Your equals method returns " + M4.equals(M5) + " when it should return false");
		//this test the equals method when they contain unequal elements
		
		System.out.println("Your equals method returns " + M1.equals(M5) + " when it should return false");
		//this test the equals method when the matrices are not the same size
		
		// get the matrix computed by your times method
		Matrix computedMultiply = M1.times(M2);
		Matrix computedMultiply2 = M2.times(M1);//test the other way around too
		Matrix computedMultiply3 = M1.times(M4);//test matrices of different dimensions
		
		// exercises your toString method
		System.out.println("Computed result for M1 * M2:\n" + computedMultiply); 
		
		System.out.println("Computed result for M2 * M1:\n" + computedMultiply2);
		
		System.out.println("Computed result for M1 * M4:\n" + computedMultiply3 + " it should be null");
		
		// exercises your .equals method, and makes sure that your computed result is the same as the known correct result
		if(!referenceMultiply.equals(computedMultiply)) 
			System.out.println("Should be:\n" + referenceMultiply);
		if(!referenceMultiply.equals(computedMultiply2)) 
			System.out.println("Should be:\n" + referenceMultiply);//test both multiply matrices
		
		System.out.println("Your add method prints: " + '\n' + M3.plus(M4) + " and it should be 2 4, 6 8");
		//this test regular addition
		System.out.println("Your add method prints: " + '\n' + M3.plus(M6) + " and it should be 0 1, 1 2");
		//this test adding to negative
		System.out.println("Your add method prints: " + '\n' + M3.plus(M7) + " and it should be null");
		//this test adding two different sized arrays
		
	}
}
