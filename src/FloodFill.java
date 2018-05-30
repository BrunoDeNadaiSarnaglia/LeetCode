public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    floodFill(image, sr, sc, newColor, image[i][j]);
    return image;
  }

  private void floodFill(int[][] image, int i, int j, int newColor, int oldColor) {
    if(i < 0 || i >= image.length || j < 0 || j >= image[0].length) return;
    if(image[i][j] != oldColor) return;
    image[i][j] = newColor;
    floodFill(image, i + 1, j, newColor, oldColor);
    floodFill(image, i - 1, j, newColor, oldColor);
    floodFill(image, i, j + 1, newColor, oldColor);
    floodFill(image, i, j - 1, newColor, oldColor);
  }
}