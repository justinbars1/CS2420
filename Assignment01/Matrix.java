package assignment1;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		numRows = d.length; // d.length is the number of 1D arrays in the 2D array
		if(numRows == 0)
			numColumns = 0;
		else
			numColumns = d[0].length; // d[0] is the first 1D array
		data = new int[numRows][numColumns]; // create a new matrix to hold the data
		// copy the data over
		for(int i=0; i < numRows; i++) 
			for(int j=0; j < numColumns; j++)
				data[i][j] = d[i][j];
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		boolean isEqual = true; //create variable to keep track if anything is not equal
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		if (this.numRows != m.numRows || this.numColumns != m.numColumns)//if they are not the same size
			return false; //then they are not equal and return false
		for (int i = 0; i < numRows; i++)//iterate through the rows
			for (int j=0; j < numColumns; j++)//iterate through the columns
			{
				if (this.data[i][j] != m.data[i][j])//if the data from the two locations dont match
					isEqual = false;//change variable to false
			}
		
		return isEqual; // return isEqual variable, if everything was equal it returns true
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		int temp;//create variable to temporarily hold integer value
		String matrix = "";//create variable to represent the matrix set to empty string
		for (int i = 0; i < numRows; i++)//iterate through the rows
		{
				for (int j=0; j < numColumns; j++)//iterate through the columns
				{
					temp = this.data[i][j];//take integer out of matrix
					matrix = matrix + temp + " ";//add it to the string
				}
				matrix = matrix + '\n';//add new line with every row
		}
		return matrix; // return the matrix
	}
	
	public Matrix times(Matrix m)
	{
		int newRows, newColumns;//integers to hold value of rows and columns of new matrices
		Matrix left, right, temp;
		right = m;//set right matrix to input
		left = this;//set left matrix to this object
		
		if (this.numColumns != m.numRows || this.numColumns != m.numRows)//if they are not the same size
			return null; //then they are not equal and return null
		if(this.numRows <= m.numRows)
			newRows = this.numRows;
		else
			newRows = m.numRows;
		
		
			
		if(this.numColumns <= m.numColumns)//these if statements set the variables for the new matrices
			newColumns = this.numColumns;//it takes the smaller number of rows and columns from both
		else
			newColumns = m.numColumns;
		
		if(this.numRows >= this.numColumns)//if the matrix on the left is taller then it is wide then switch matrices 
		{
			temp = left;
			left = right;//switch around matrices
			right = temp;
			
		}
		int[][] result = new int[newRows][newColumns];//make a new 2d array for the results
		for (int i = 0; i < left.numRows; i++)//iterate through the rows of the left
			for(int j = 0; j < right.numColumns; j++)//while iterating through the columns of the right
				for (int x = 0; x < left.numColumns; x++)//variable to hold position of scaling
				{
					result[i][j] += left.data[i][x] * right.data[x][j];
				}
		
		Matrix d = new Matrix(result);
		return d; // return new matrix
	
	}
	
	public Matrix plus(Matrix m)
	{
		if (this.numRows != m.numRows || this.numColumns != m.numColumns)//if they are not the same size
			return null; //then they are not equal and return null
		int[][] result = new int[this.numRows][this.numColumns];
		for (int i = 0;i < this.numRows; i++)//iterate through the rows
			for (int j= 0; j < this.numColumns; j++)//iterate through the colums
			{
				result[i][j] = this.data[i][j] + m.data[i][j]; //add them together and put into matrix
			}
		Matrix d = new Matrix(result);//turn array into matrix
		return d; // return results
	}
}
