package core;

import gui.controllers.CenterPaneController;
public class Halt implements Runnable {
    //	private static final Thread thread = new Thread(new Halt());
//	private Halt() {};
//	public static Thread getInstance() {
//		return thread;
//	}
    public static volatile boolean flag = true;

    public void run() {
        if (CPU.getInstance().getControler().singleStep) {
            CPU.getInstance().getControler().processSingleStep();
        } else {
            CPU.getInstance().getControler().processByInstruction();
        }

    }

    public static void halt() {
        flag = true;
        while (flag) {
            if (CenterPaneController.getOpen() == false) break;
        }
    }
}
