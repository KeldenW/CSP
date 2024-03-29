/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms()
  {
    Picture snow = new Picture("snowman.jpg");
    snow.explore();
    snow.mirrorArms();
    snow.explore();
  }
  
  public static void testMirrorGull()
  {
    Picture gull = new Picture("seagull.jpg");
    gull.explore();
    gull.mirrorGull();
    gull.explore();
  }
  
  /** Method to test the collage method */
  public static void testMyCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection2(200);
    swan.explore();
  }
  
  /** Method to test negation */
  public static void testNegate(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.negate();
      beach.explore();
  }
  
  /** Method to test grayscale */
  public static void testGrayscale(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.grayscale();
      beach.explore();
  }
  
  public static void testFixUnderwater(){
      Picture under = new Picture("water.jpg");
      under.explore();
      under.fixUnderwater();
      under.explore();
  }
  
  public static void testKeepOnlyRed(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.keepOnlyRed();
      beach.explore();
  }
  
  public static void testKeepOnlyGreen(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.keepOnlyGreen();
      beach.explore();
  }
  
  public static void testMirrorHorizontalTopToBottom(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.mirrorHorizontalTopToBottom();
      beach.explore();
  }
  
  public static void testMirrorHorizontalBotToTop(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.mirrorHorizontalBotToTop();
      beach.explore();
  }
  
  public static void testMirrorDiagonal(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.mirrorDiagonal();
      beach.explore();
  }
  
  public static void testCopyRegion(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.copyRegion(304, 158, 410, 239, 513, 259);
      beach.explore();
  }
  
  public static void testMirrorRegion(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.mirrorRegion(304, 158, 410, 239, 513, 259);
      beach.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    // testZeroBlue();
    // testKeepOnlyBlue();
    // testKeepOnlyRed();
    // testKeepOnlyGreen();
    // testNegate();
    // testGrayscale();
    // testFixUnderwater();
    // testMirrorVertical();
    // testMirrorHorizontalTopToBottom();
    // testMirrorHorizontalBotToTop();
    // testMirrorTemple();
    // testMirrorRegion();
    // testCopyRegion();
    // testMirrorArms();
    // testMirrorGull();
    // testMirrorDiagonal();
    // testMyCollage();
    // testCopyRegion();
    testEdgeDetection();
    // testEdgeDetection2();
    // testChromakey();
    // testEncodeAndDecode();
    // testGetCountRedOverValue(250);
    // testSetRedToHalfValueInTopHalf();
    // testClearBlueOverValue(200);
    // testGetAverageForColumn(0);
  }
}