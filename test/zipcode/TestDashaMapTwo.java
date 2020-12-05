package zipcode;


import org.junit.Assert;
import org.junit.Test;

public class TestDashaMapTwo {
    @Test
    public void set() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        Integer expected = 1;
        Integer actual = dm.bucketSize("a");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void set2() {
        DashaMapTwo dm = new DashaMapTwo();

        Integer expected = 0;
        Integer actual = dm.bucketSize("a");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        String expected = "5";
        String actual = dm.get("aaa");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void get2() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        dm.set("aba", "3");
        dm.set("aac", "1");
        String expected = "5";
        String actual = dm.get("aaa");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty() {
        DashaMapTwo dm = new DashaMapTwo();

        Boolean expected = false;

        dm.set("aaa", "5");

        Boolean actual = dm.isEmpty();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty2() {
        DashaMapTwo dm = new DashaMapTwo();

        Boolean expected = true;
        Boolean actual = dm.isEmpty();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        dm.set("ab", "5");
        Long expected = 2L;
        Long actual = dm.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bucketSize() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        dm.set("aab", "5");
        Integer expected = 2;
        Integer actual = dm.bucketSize("a");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bucketSize2() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("xxa", "5");
        dm.set("xx", "5");
        Integer expected = 2;
        Integer actual = dm.bucketSize("x");
        Assert.assertEquals(expected, actual);
    }
}
