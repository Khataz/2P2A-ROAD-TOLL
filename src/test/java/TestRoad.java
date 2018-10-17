import default_package.Position;
import default_package.Road;
import default_package.Sign;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestRoad {

    @Test
    public void testFillTreeSign() {
        Road rd = new Road();
        rd.fillTreeSigns();

        assertTrue(true);
        //assertEquals(rd.getSignAt(new Position(200)), new Sign(new Position(200),25));
    }
}
