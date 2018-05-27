class Solution {
  private int[] LAST_BIT = new int[]{0};
	private int[][] POSSIBLE_BITS = new int[][] {new int[]{1, 0}, LAST_BIT};

  public boolean isOneBitCharacter(int[] bits) {
    boolean[] dp = new boolean[bits.length];
    if(!match(bits, LAST_BIT, bits.length - 1)) return false;
    dp[bits.length - LAST_BIT.length] = true;
    for(int i = bits.length - LAST_BIT.length; j >= 0; j--) {
      if(dp[i] == true) {
        for(int[] ch : POSSIBLE_BITS) {
          if(match(bits, ch, i - 1) ){
            dp[i - ch.length] = true;
          }
        }
      }
    }
    return dp[0];
  }

	private boolean match(int[] bits, int[] character, int i) {
		if(character.length - 1 > i) {
			return false;
    }
    for(int j = 0; j < character.length; j++) {
      if(bits[i - j] != character[character.length - 1 - j]) return false;
    }
    return true;
  }
}
