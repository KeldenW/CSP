import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  private void colorIncreasedBy(Color color, float percent){
      float[] newColors = new float[3];
      for (float fColor: color.getComponents(new float[3])){
          if (fColor*percent > 255){
              fColor = 255;
          } else {
              fColor = fColor*percent;
          }
      }
  }
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  private int getMaxRed(){
    Pixel[][] pixels = this.getPixels2D();
    int big = 0;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          if (pixelObj.getRed() > big)
          big = pixelObj.getRed();
      }
    }
    return big;
  }
  
  private int getMaxGreen(){
    Pixel[][] pixels = this.getPixels2D();
    int big = 0;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          if (pixelObj.getGreen() > big)
          big = pixelObj.getGreen();
      }
    }
    return big;
  }
  
  private int getMaxBlue(){
    Pixel[][] pixels = this.getPixels2D();
    int big = 0;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          if (pixelObj.getBlue() > big)
          big = pixelObj.getBlue();
      }
    }
    return big;
  }
  
  private int getMinRed(){
    Pixel[][] pixels = this.getPixels2D();
    int smol = 255;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          if (pixelObj.getRed() < smol)
          smol = pixelObj.getRed();
      }
    }
    return smol;
  }
  
  private int getMinGreen(){
    Pixel[][] pixels = this.getPixels2D();
    int smol = 255;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          if (pixelObj.getGreen() < smol)
          smol = pixelObj.getGreen();
      }
    }
    return smol;
  }
  
  private int getMinBlue(){
    Pixel[][] pixels = this.getPixels2D();
    int smol = 255;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          if (pixelObj.getBlue() < smol)
          smol = pixelObj.getBlue();
      }
    }
    return smol;
  }
  
  private int maximiseRed(int value, int minRed, int maxRed){
      value -= minRed;
      value = value * (255/maxRed);
      return value / 1;
  }
  
  private int minimiseGreen(int value){
      return (int)(value*0.5);
  }
  
  private int minimiseBlue(int value){
      return (int)(value*0.5);
  }
  
  public void fixUnderwater(){
    Pixel[][] pixels = this.getPixels2D();
    
    int maxRed = getMaxRed();
    int minRed = getMinRed();
    
    int minGreen = getMinGreen();
    int maxGreen = getMaxGreen();
    
    int minBlue = getMinBlue();
    int maxBlue = getMaxBlue();
    
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          pixelObj.setRed(maximiseRed(pixelObj.getRed(), minRed, maxRed));
          pixelObj.setGreen(minimiseGreen(pixelObj.getGreen()));
          pixelObj.setBlue(minimiseBlue(pixelObj.getBlue()));
      }
    }
  }
  
   /** Method to set the blue to 0 */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  public void keepOnlyRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  
  public void grayscale(){
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] row: pixels){
          for (Pixel pix : row){
              float[] components = new float[4];
              components = pix.getColor().getComponents(components);
              float avg = (components[0] + components[1] + components[2])/3;
              pix.setColor(new Color(avg, avg, avg));
          }
      }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontalTopToBottom(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    int width = pixels[0].length;
    int height = pixels.length;
    for (int row = 0; row < pixels.length / 2; row++){
        for (int col = 0; col < width; col++){
            topPixel = pixels[row][col];
            bottomPixel = pixels[height-1-row][col];
            bottomPixel.setColor(topPixel.getColor());
        }
    }
  }
  
  public void mirrorHorizontalBotToTop(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    int width = pixels[0].length;
    int height = pixels.length;
    for (int row = height-1; row > pixels.length / 2; row--){
        for (int col = 0; col < width; col++){
            topPixel = pixels[row][col];
            bottomPixel = pixels[height-1-row][col];
            bottomPixel.setColor(topPixel.getColor());
        }
    }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorDiagonal(){
      Pixel[][] pixel = this.getPixels2D();
      int max;
      if (pixel.length > pixel[0].length)
      max = pixel[0].length;
      else
      max = pixel.length;
      
      Pixel topPixel = null;
      Pixel botPixel = null;
      
      for (int idx = 0; idx < max; idx++){
          for (int step = idx; step < max; step++){
              botPixel = pixel[step][idx];
              topPixel = pixel[idx][step];
              topPixel.setColor(botPixel.getColor());
          }
      }
  }
  
  
  /** copys the region between the first two points, and pastes it below and to the
   * right of the second point
   * (x1,y1) is upper left corner, (x2,y2) is lower right corner.
   */
  public void copyRegion(int x1, int y1, int x2, int y2, int x3, int y3){
      Pixel[][] pixel = this.getPixels2D();
      
      int height = pixel.length;
      int width = pixel[0].length;
      
      Pixel p1 = null;
      Pixel p2 = null;
      
      for (int y = 0; y < height; y++){
          for (int x = 0; x < width; x++){
              // if our pixel is the the designated region
              if ((x >= x1 && x <= x2) && (y >= y1 && y <= y2)){
                  // swap it with the corresponding pixel in the other region
                  p1 = pixel[y][x];
                  p2 = pixel[(y-y1)+y3][(x-x1)+x3];
                  p2.setColor(p1.getColor());
              }
          }
      }
  }
  /** Mirrors the region between the first two points, and pastes it below and to the
   * right of the third point
   * (x1,y1) is upper left corner, (x2,y2) is lower right corner.
   */
    public void mirrorRegion(int x1, int y1, int x2, int y2, int x3, int y3){
      Pixel[][] to = this.getPixels2D();
      Pixel[][] from = new Pixel[to.length][to[0].length];
      System.arraycopy(to, 0, from, 0, to.length);
      
      int height = to.length;
      int width = to[0].length;
      
      int w = x2 - x1;
      
      Pixel p1 = null;
      Pixel p2 = null;
      
      for (int y = 0; y < height; y++){
          for (int x = 0; x < width; x++){
              // if our pixel is the the designated region
              if ((x >= x1 && x <= x2) && (y >= y1 && y <= y2)){
                  // swap it with the corresponding pixel in the other region
                  to[(y-y1)+y3][x3+w-(x-x1)].setColor(from[y][x].getColor());
              }
          }
      }
  }
  
  /** Negate all the pixels in the picture */
  public void negate(){
      Pixel[][] pixel = this.getPixels2D();
      for (Pixel[] row: pixel){
          for (Pixel p: row){
              p.setRed(255-p.getRed());
              p.setGreen(255-p.getGreen());
              p.setBlue(255-p.getBlue());
          }
      }
  }
  
  public void mirrorArms(){
    int mirrorPoint = 206;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 158; row < 193; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 104; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorGull(){
    mirrorRegion(226, 232, 330, 349, 53, 230);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int fromStartRow, int fromStartCol, 
                 int fromEndRow, int fromEndCol, 
                 int toRow, int toCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    
    for (int fromRow = fromStartRow, row = 0; 
         fromRow < fromEndRow && toRow < fromEndRow; 
         fromRow++, row++)
    {
        
      for (int fromCol = fromStartCol, col = 0; 
           fromCol < fromEndCol && toCol < fromEndCol;  
           fromCol++, col++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow+row][toCol+col];
        toPixel.setColor(fromPixel.getColor());
      }
      
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    flower2.negate();
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage(){
    Picture wall = new Picture("wall.jpg");
    Picture lion = new Picture("femaleLionAndHall.jpg");
    Picture head = new Picture("blue-mark.jpg");
    
    wall.negate();
    head.zeroBlue();

    this.copy(wall, 81, 76, 412, 377, 0, 0);
    this.mirrorRegion(0, 0, 412-81, 377-76, 200, 0);
    this.copy(lion, 232, 318, 377, 470, 100, 100);
    this.copy(head, 172, 276, 301, 380, 245, 260);
    this.mirrorVertical();
    
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color botColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        botPixel = pixels[row+1][col];
        rightPixel = pixels[row][col+1];
        
        botColor = botPixel.getColor();
        if (leftPixel.colorDistance(botColor) < 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
        
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) < 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetection2(int dist){
    // all the directions
    Pixel left = null;
    Pixel right = null;
    Pixel up = null;
    Pixel down = null;
    Pixel center = null;
    
    // get the parent arrays
    Pixel[][] to = this.getPixels2D();
    
    Pixel[][] from = new Pixel[to.length][to[0].length];
    
    Picture p = new Picture(to.length, to[0].length);
    
    for (int i = 0; i < to.length; i++) {
        for (int j = 0; j < to[0].length; j++){
            from[i][j] = new Pixel(p, j, i);
            from[i][j].setColor(to[i][j].getColor());
        }
    }
    
    // detect!
    for (int row = 1; row < to.length-1; row++)
    {
      for (int col = 1; col < to[0].length-1; col++)
      {
        left = from[row][col-1];
        right = from[row][col+1];
        up = from[row-1][col];
        down = from[row+1][col];
        center = to[row][col];
        
        if (center.colorDistance(left.getColor()) > dist ||
            center.colorDistance(right.getColor()) > dist ||
            center.colorDistance(up.getColor()) > dist ||
            center.colorDistance(down.getColor()) > dist)
            center.setColor(Color.BLACK);
        else
            center.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
