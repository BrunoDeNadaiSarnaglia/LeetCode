import java.util.List;
import java.util.stream.IntStream;

public class ShoppingOffer {
  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    List<Integer> zerosList = IntStream.of(0).limit(needs.size()).collect(Collectors.toList());
  }
}
