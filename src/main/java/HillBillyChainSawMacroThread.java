import MouseClicker.MouseClicker;
import MouseListener.GlobalMouseListener;

import java.util.Timer;
import java.util.TimerTask;

public class HillBillyChainSawMacroThread {
    private MouseClicker mouseClicker;
    private Timer timer;
    private Mouse2Task mouse2Task;
    private GlobalMouseListener globalMouseListener;

    private HillBillyChainSawMacroThread() {
        mouseClicker = new MouseClicker();
        timer = new Timer();
        mouse2Task = new Mouse2Task();
        globalMouseListener = new GlobalMouseListener();
    }

    private void ninetyNinePercentChainsaw() {
        mouseClicker.pressRightMouseFor(2000);
        timer.scheduleAtFixedRate(mouse2Task, 0, 1);
    }

    private boolean leftMouseButtonIsLastClicked() {
        return globalMouseListener.getLastButtonPressed() == GlobalMouseListener.leftMouseButton;
    }

    class Mouse2Task extends TimerTask {

        public void run() {
            mouseClicker.pressRightMouseFor(100);
            mouseClicker.releaseRightMouseFor(150);
            if (leftMouseButtonIsLastClicked()) {
                System.out.println("Exiting Program");
                timer.cancel();
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        HillBillyChainSawMacroThread macroThread = new HillBillyChainSawMacroThread();
        macroThread.ninetyNinePercentChainsaw();
    }
}


