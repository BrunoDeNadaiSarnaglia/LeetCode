import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bruno on 7/18/2016.
 */
public class CacheTest {

    @Test
    public void getNonExistentKey(){
        Cache cache = new Cache(3);
        Assert.assertNull(cache.get(0));
    }

    @Test
    public void getExistentKey(){
        Cache cache = new Cache(3);
        cache.put(0, 0);
        Assert.assertNotNull(cache.get(0));
        Assert.assertEquals(cache.toString(), "[Node{obj=0}]");
    }


    @Test
    public void putMoreThanCapacity(){
        Cache cache = new Cache(3);
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        Assert.assertNull(cache.get(0));
        Assert.assertEquals(cache.toString(), "[Node{obj=3}Node{obj=2}Node{obj=1}]");
    }


    @Test
    public void updateElement(){
        Cache cache = new Cache(3);
        cache.put(1, 1);
        cache.put(1, -1);
        Assert.assertEquals(cache.toString(), "[Node{obj=-1}]");
    }

    @Test
    public void putZeroCapacityCache(){
        Cache cache = new Cache(0);
        cache.put(0,0);
        Assert.assertEquals(cache.toString(), "[]");
        cache.put(0,0);
        Assert.assertEquals(cache.toString(), "[]");
    }

    @Test
    public void putNegativeCapacityCache(){
        Cache cache = new Cache(-1);
        cache.put(0,0);
        Assert.assertEquals(cache.toString(), "[]");
        cache.put(0,0);
        Assert.assertEquals(cache.toString(), "[]");
    }
}
