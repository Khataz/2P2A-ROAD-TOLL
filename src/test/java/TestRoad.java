import body.Position;
import body.Road;
import body.Sign;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestRoad {

    @Test
    public void testFillTreeSign() {
        Road rd = new Road();
        rd.fillTreeSigns();
        assertEquals(rd.getSignAt(new Position(250)).getXPosition(), new Sign(new Position(250), 25).getXPosition());
        assertEquals(rd.getSignAt(new Position(250)).getSpeedLimit(), new Sign(new Position(250), 25).getSpeedLimit());
    }
}
