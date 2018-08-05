import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CirclePointsTest
{
    @Test(expected = IllegalArgumentException.class)
    public void circleWithIllegalSmalRadius()
    {
    	new CirclePoints(0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void circleWithIllegalLargeRadius()
    {
    	new CirclePoints(10_001);
    }
    
    @Test
    public void circleWithMinimumRadius()
    {
    	CirclePoints cp = new CirclePoints(1);
        assertEquals(5, cp.getPointsCount());
        assertEquals(5, cp.getPointsCount_2());
    }
    
    @Test
    public void circleWithRadius2()
    {
    	CirclePoints cp = new CirclePoints(2);
        assertEquals(13, cp.getPointsCount());
        assertEquals(13, cp.getPointsCount_2());
    }    
    
    @Test
    public void circleWithRadius10()
    {
    	CirclePoints cp = new CirclePoints(10);
        assertEquals(317, cp.getPointsCount());
        assertEquals(317, cp.getPointsCount_2());
    }      
    
    @Test
    public void circleWithMaximumRadius()
    {
    	CirclePoints cp = new CirclePoints(10_000);
        assertEquals(314_159_053, cp.getPointsCount());
        assertEquals(314_159_053, cp.getPointsCount_2());
    }    
}
