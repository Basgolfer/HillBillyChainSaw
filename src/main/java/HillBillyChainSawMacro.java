import MouseClicker.MouseClicker;
import MouseListener.GlobalMouseListener;

import java.util.Timer;
import java.util.TimerTask;

public class HillBillyChainSawMacro {
    private MouseClicker mouseClicker;
    private Timer timer;
    private Mouse2Task mouse2Task;
    private GlobalMouseListener globalMouseListener;

    private HillBillyChainSawMacro() {
        mouseClicker = new MouseClicker();
        timer = new Timer();
        mouse2Task = new Mouse2Task();
        globalMouseListener = new GlobalMouseListener();
    }

    private void ninetyNinePercentChainsaw() {
        mouseClicker.pressRightMouseFor(2375);
        timer.scheduleAtFixedRate(mouse2Task, 0, 1);
    }

    private boolean leftMouseButtonIsLastClicked() {
        return globalMouseListener.getLastButtonPressed() == GlobalMouseListener.leftMouseButton;
    }

    class Mouse2Task extends TimerTask {

        public void run() {
            mouseClicker.pressRightMouseFor(32);
            mouseClicker.releaseRightMouseFor(41);
            if (leftMouseButtonIsLastClicked()) {
                System.out.println("Exiting Program");
                timer.cancel();
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        HillBillyChainSawMacro macroThread = new HillBillyChainSawMacro();
        macroThread.ninetyNinePercentChainsaw();
    }
}


