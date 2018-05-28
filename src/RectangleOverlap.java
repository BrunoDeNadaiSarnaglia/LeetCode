public class RectangleOverlap {
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    if(getBottom(rec1) >= getTop(rec2))  return false;
    if(getTop(rec1) <= getBottom(rec2))  return false;
    if(getRight(rec1) <= getLeft(rec2))  return false;
    if(getLeft(rec1) >= getRight(rec2))  return false;
    return true;
  }


  private int getTop(int[] rec) {
    return rec[3];
  }

  private int getBottom(int[] rec) {
    return rec[1];
  }

  private int getLeft(int[] rec) {
    return rec[0];
  }

  private int getRight(int[] rec) {
    return rec[2];
  }
}
