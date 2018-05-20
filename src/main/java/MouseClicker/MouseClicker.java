package MouseClicker;

import MouseClicker.MouseClickerExceptions.MouseButtonNotFoundException;

import java.awt.*;
import java.awt.event.InputEvent;

public class MouseClicker {
    private Robot robot;
    public static final Integer leftMouseButton = 1;
    public static final Integer middleMouseButton = 2;
    public static final Integer rightMouseButton = 3;

    public MouseClicker() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void leftMousePress() {
        press(leftMouseButton);
    }

    private void middleMousePress() {
        press(middleMouseButton);
    }

    private void rightMousePress() {
        press(rightMouseButton);
    }

    private void leftMouseRelease() {
        release(leftMouseButton);
    }

    private void middleMouseRelease() {
        release(middleMouseButton);
    }

    private void rightMouseRelease() {
        release(rightMouseButton);
    }

    public void leftMouseClick() {
        leftMousePress();
        leftMouseRelease();
    }

    public void middleMouseClick() {
        middleMousePress();
        middleMouseRelease();
    }

    public void rightMouseClick() {
        rightMousePress();
        rightMouseRelease();
    }

    private int getMouseInputEvent(int mouseButton) throws MouseButtonNotFoundException {
        switch (mouseButton) {
            case 1:
                return InputEvent.getMaskForButton(leftMouseButton);
            case 2:
                return InputEvent.getMaskForButton(middleMouseButton);
            case 3:
                return InputEvent.getMaskForButton(rightMouseButton);
            default:
                throw new MouseButtonNotFoundException();
        }
    }

    private void press(int mouseButton) {
        try {
            robot.mousePress(getMouseInputEvent(mouseButton));
        } catch (MouseButtonNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void release(int mouseButton) {
        try {
            robot.mouseRelease(getMouseInputEvent(mouseButton));
        } catch (MouseButtonNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void pressRightMouseFor(int milliseconds) {
        rightMousePress();
        robot.delay(milliseconds);
        rightMouseRelease();
    }

    public void releaseRightMouseFor(int milliseconds) {
        robot.delay(milliseconds);
    }
}
