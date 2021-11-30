public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /** 
   * get the count of an integer value in an array
   * @param theInt the integer to count
   */
  public int getCount(int theInt){
      int count = 0;
      for (int[] arr: matrix){
          for (int i: arr){
              if (i == theInt){
                  count++;
              }
          }
      }
      return count;
  }
  /** 
   * get the largest integer value
   * @return the largest value in the array
   */
  public int getLargest(){
      int large = matrix[0][0];
      for (int[] arr: matrix){
          for (int i: arr){
              if (i > large){
                  large = i;
              }
          }
      }
      return large;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total += item;
      }
    }
    return total;
  }
  
  /**
   * method to get the sum of values in a specified column
   * @param colNum the index of the column
   * @return the sum of the values of the specified column
   */
  public int getColTotal(int colNum){
      int total = 0;
      for (int[] arr : matrix){
          total += arr[colNum];
      }
      return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
 
}