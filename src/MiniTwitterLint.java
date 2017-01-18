import java.util.*;

/**
 * Created by Sarnaglia on 1/17/17.
 */



public class MiniTwitterLint {


    private class Node {
        Tweet tweet;
        int timestamp;
        Node previous;

        public Node(Tweet tweet, int timestamp, Node previous) {
            this.tweet = tweet;
            this.timestamp = timestamp;
            this.previous = previous;
        }
    }

    private class User{

        HashSet<User> friends = new HashSet<>();
        Node node;

    }


    private static int timestamp = 0;
    HashMap<Integer, User> mapIdToUser = new HashMap<>();


    private User getUser(int user_id){
        if(this.mapIdToUser.containsKey(user_id))   return this.mapIdToUser.get(user_id);
        User user = new User();
        this.mapIdToUser.put(user_id, user);
        return user;
    }

    public MiniTwitterLint() {
        // initialize your data structure here.
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        User user = getUser(user_id);
        Tweet tweet = Tweet.create(user_id, tweet_text);
        user.node = new Node(tweet, timestamp++, user.node);;
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        List<Tweet> list = new ArrayList<Tweet>();
        PriorityQueue<Node> pq = new PriorityQueue<>(10, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.timestamp - o1.timestamp;
            }
        });
        User user = getUser(user_id);
        if(user.node != null) pq.add(user.node);
        for (User friend : user.friends) {
            if(friend.node != null) pq.add(friend.node);
        }
        for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
            Node node = pq.poll();
            list.add(node.tweet);
            if(node.previous != null)   pq.add(node.previous);
        }
        return list;
    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        User user = getUser(user_id);
        Node node = user.node;
        List<Tweet> list = new ArrayList<Tweet>();
        for (int i = 0; i < 10 && node != null; i++, node = node.previous) {
            list.add(node.tweet);
        }
        return list;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        User fromUser = getUser(from_user_id);
        User toUser = getUser(to_user_id);
        fromUser.friends.add(toUser);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        User fromUser = getUser(from_user_id);
        User toUser = getUser(to_user_id);
        if(fromUser.friends.contains(toUser)) fromUser.friends.remove(toUser);
    }

}
