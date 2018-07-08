public class MirrorReflection {
  public int mirrorReflection(int p, int q) {
    int mdc = mdc(p, q);
    int horizontal = (p / mdc) % 2 == 1 ? 1 : 0;
    int vertical = (q / mdc) % 2 == 1 ? 1 : 0;
    if(horizontal == 1 && vertical == 1)  return 1;
    if(horizontal == 1 && vertical == 0)  return 0;
    if(horizontal == 0 && vertical == 1)  return 2;
    return -1;
  }

  private int mdc(int p, int q) {
    if(q > p) return mdc(q, p);
    if(q == 0)  return p;
    return mdc(q, p % q);
  }
}
