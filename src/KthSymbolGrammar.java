public class KthSymbolGrammar {
  public int kthGrammar(int N, int K) {
    if(K == 1)  return 0;
    if(K % 2 == 1) return kthGrammar(N - 1, (K + 1) / 2);
    return inverse(kthGrammar(N - 1, K / 2));
  }

  private int inverse(int i) {
    return (i + 1 % 2);
  }
}
