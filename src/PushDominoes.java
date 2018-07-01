import java.util.Arrays;

public class PushDominoes {
  public String pushDominoes(String dominoes) {
    int[] timeToGetHitByRight = new int[dominoes.length()];
    int[] timeToGetHitByLeft = new int[dominoes.length()];
    int pivot = -1;
    for (int i = 0; i < timeToGetHitByRight.length; i++) {
      if (dominoes.charAt(i) == 'R') {
        pivot = i;
      }
      if (dominoes.charAt(i) == 'L') {
        pivot = -1;
      }
      if (pivot != -1) {
        timeToGetHitByRight[i] = i - pivot;
      } else {
        timeToGetHitByLeft[i] = Integer.MAX_VALUE;
      }
    }
    pivot = -1;
    for (int i = timeToGetHitByLeft.length - 1; i >= 0; i--) {
      if (dominoes.charAt(i) == 'L') {
        pivot = i;
      }
      if (dominoes.charAt(i) == 'R') {
        pivot = -1;
      }
      if (pivot != -1) {
        timeToGetHitByLeft[i] = pivot - i;
      } else {
        timeToGetHitByLeft[i] = Integer.MAX_VALUE;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < dominoes.length(); i++) {
      if(dominoes.charAt(i) != '.') {
        sb.append(dominoes.charAt(i));
      } else if(timeToGetHitByLeft[i] == timeToGetHitByRight[i]) {
        sb.append('.');
      } else if(timeToGetHitByLeft[i] > timeToGetHitByRight[i]) {
        sb.append('R');
      } else {
        sb.append('L');
      }
    }
    System.out.println(Arrays.toString(timeToGetHitByLeft));
    System.out.println(Arrays.toString(timeToGetHitByRight));
    return sb.toString();
  }
}
