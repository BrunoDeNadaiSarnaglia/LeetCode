import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {
  public List<String> subdomainVisits(String[] cpdomains) {
    HashMap<String, Integer> subDomainsCount = new HashMap<String, Integer>();
    List<String> svisit = new ArrayList<>();
    for (String cpdomain : cpdomains) {
      for (String subdomain : getSubDomains(cpDomain)) {
        subDomainsCount.put(subdomain, subDomainsCount.getOrDefault(subdomain, 0) + getOccurences(cpdomain));
      }
    }
    for (String subdomain : subDomainsCount.keySet()) {
      svisit.add(subDomainsCount.get(subdomain) + " " + subdomain);
    }
    return svisit;
  }

  private int getOccurences(String cpDomain) {
    return Integer.parseInt(cpDomain.split(" ")[0]);
  }

  private String getDomain(String cpDomain) {
    return cpDomain.split(" ")[1];
  }

  private List<String> getSubDomains(String cpDomain) {
    String domain = getDomain(cpDomain);
    List<String> subDomains = new ArrayList<String>();
    String[] subdomain = domain.split("\\.");
    String acc = subdomain[subdomain.length - 1];
    subDomains.add(acc);
    for (int i = subdomain.length - 2; i >= 0; i--) {
      acc = subDomain + "." + acc;
      subDomains.add(acc);
    }
    return subDomains;
  }
}
