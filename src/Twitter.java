import java.util.*;

/**
 * Created by Bruno on 6/11/2016.
 */
public class Twitter
{

    public static void main(String[] args){
        Twitter t = new Twitter();
        t.postTweet(1,5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1,2);
        t.postTweet(2,6);
        System.out.println(t.getNewsFeed(1));
        t.unfollow(1,2);
        System.out.println(t.getNewsFeed(1));
    }

    private class User{

        LinkedList<Tweet> tweets = new LinkedList<Tweet>();

        public void addTweet(int tweetId, int count){
            tweets.addFirst(new Tweet(tweetId, count));
            if(tweets.size() > 10){
                tweets.removeLast();
            }
        }

        public IteratorCurrent<Tweet> getIterator(){
            return new IteratorCurrent(tweets.iterator());
        }
    }

    private class IteratorCurrent<T> implements Iterator<T>{

        Iterator<T> it;
        T current = null;

        public IteratorCurrent(Iterator<T> it) {
            this.it = it;
            this.current = next();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!it.hasNext()){
                this.current = null;
            } else {
                this.current = it.next();
            }
            return current();
        }

        public T current(){
            return this.current;
        }

        @Override
        public void remove() {

        }
    }

    private class Tweet{

        int id;
        int inc;

        public Tweet(int id, int inc) {
            this.id = id;
            this.inc = inc;
        }

    }

    int count = 0;
    HashMap<Integer, User> mapUser = new HashMap<Integer, User>();
    HashMap<User, HashSet<User>> mapFollow = new HashMap<User, HashSet<User>>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        CheckAndAddUser(userId);
        User user = mapUser.get(userId);
        user.addTweet(tweetId, count++);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<Integer>();
        if(!mapUser.containsKey(userId))        return newsFeed;
        User user = mapUser.get(userId);
        if(!mapFollow.containsKey(user))         return newsFeed;
        HashSet<User> setFollower = mapFollow.get(user);
        setFollower.add(user);
        PriorityQueue<IteratorCurrent<Tweet>> pq = new PriorityQueue<IteratorCurrent<Tweet>>(new Comparator<IteratorCurrent<Tweet>>() {
            @Override
            public int compare(IteratorCurrent<Tweet> o1, IteratorCurrent<Tweet> o2) {
                return -o1.current.inc + o2.current.inc;
            }
        });
        for (User userFollower: setFollower) {
            IteratorCurrent<Tweet> it = userFollower.getIterator();
            if(!it.hasNext())   continue;
            pq.add(it);
        }
        for(int i = 0; i < 10 && !pq.isEmpty(); i++){
            IteratorCurrent<Tweet> it = pq.poll();
            Tweet tweet = it.current;
            newsFeed.add(tweet.id);
            it.next();
            if(!it.hasNext())   continue;
            pq.add(it);
        }
        return newsFeed;
    }

    private void CheckAndAddUser(int id){
        if(!mapUser.containsKey(id)){
            User user = new User();
            mapUser.put(id, user);
            HashSet<User> userSet = new HashSet<User>();
            userSet.add(user);
            mapFollow.put(user, userSet);
        }

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        CheckAndAddUser(followerId);
        CheckAndAddUser(followeeId);
        User followerUser = mapUser.get(followerId);
        User followeeUser = mapUser.get(followeeId);
        if(!mapFollow.containsKey(followerUser))
            mapFollow.put(followerUser, new HashSet<User>());
        HashSet<User> followeeSet = mapFollow.get(followerUser);
        followeeSet.add(followeeUser);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!mapUser.containsKey(followeeId) || !mapUser.containsKey(followerId))    return;
        User followerUser = mapUser.get(followerId);
        User followeeUser = mapUser.get(followeeId);
        if(!mapFollow.containsKey(followerUser))    return;
        HashSet<User> followeeSet = mapFollow.get(followerUser);
        followeeSet.remove(followeeUser);
    }
}
