import javax.swing.text.html.FormView;

public class LargestTriangleArea {
  public double largestTriangleArea(int[][] points) {
    double max = 0;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        for (int k = j + 1; k < points.length; k++) {
          max = Math.max(max, calcTriangleArea(points[i], points[j], points[k]));
        }
      }
    }
    return max;
  }

  private double calcTriangleArea(int[] pa, int[] pb, int [] pc) {
    return ((double)Math.abs(pa[0] * pb[1] + pb[0] * pc[1] + pc[0] * pa[1] - pa[0] * pc[1] - pc[0] * pb[1] - pb[0] * pa[1])) / 2.0;
  }
}
