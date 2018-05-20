package MouseListener;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GlobalMouseListener implements NativeMouseInputListener {

    private int lastButtonPressed;
    private int lastButtonReleased;
    public static final Integer leftMouseButton = 1;
    public static final Integer middleMouseButton = 3;
    public static final Integer rightMouseButton = 2;

    public int getLastButtonPressed() {
        return lastButtonPressed;
    }

    public int getLastButtonReleased() {
        return lastButtonReleased;
    }

    public GlobalMouseListener() {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        // Get the logger for "org.jnativehook" and set the level to off.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        // Change the level for all handlers attached to the default logger.
        Handler[] handlers = Logger.getLogger("").getHandlers();
        for (Handler handler : handlers) {
            handler.setLevel(Level.OFF);
        }
        // Add the appropriate listeners.
        GlobalScreen.addNativeMouseListener(this);
        GlobalScreen.addNativeMouseMotionListener(this);
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        lastButtonPressed = e.getButton();
        System.out.println("Mouse Pressed: " + determineLastButtonPressed());
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        lastButtonReleased = e.getButton();
        System.out.println("Mouse Released: " + determineLastButtonReleased());
    }

    private String determineLastButtonPressed() {
        return determineButton(lastButtonPressed);
    }

    private String determineLastButtonReleased() {
        return determineButton(lastButtonReleased);
    }

    private String determineButton(int button) {
        switch (button) {
            case 1:
                return "Left Click";
            case 2:
                return "Right Click";
            case 3:
                return "Middle Mouse Click";
            default:
                return "Not a known mouse button";
        }
    }

    public void nativeMouseClicked(NativeMouseEvent e) {
        //System.out.println("Mouse Clicked: " + e.getClickCount());
    }

    public void nativeMouseMoved(NativeMouseEvent e) {
        //System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
        //System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
    }
}
