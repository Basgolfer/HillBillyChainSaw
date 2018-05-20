import MouseClicker.MouseClicker;
import MouseListener.GlobalMouseListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class GlobalMouseListenerTest {

    private GlobalMouseListener globalMouseListener;
    private MouseClicker mouseClicker;

    @Before
    public void setUp() throws AWTException {
        globalMouseListener = new GlobalMouseListener();
        mouseClicker = new MouseClicker();
    }

    @After
    public void tearDown() {
        globalMouseListener = null;
        mouseClicker = null;
    }

    @Test
    public void nativeMousePressedLeftClickTestSimulatedWithRobot() {
        mouseClicker.leftMouseClick();
    }

    @Test
    public void nativeMousePressedRightClickTestSimulatedWithRobot() {
        mouseClicker.middleMouseClick();
    }

    @Test
    public void nativeMousePressedScrollWheelClickTestSimulatedWithRobot() {
        mouseClicker.rightMouseClick();
    }
}