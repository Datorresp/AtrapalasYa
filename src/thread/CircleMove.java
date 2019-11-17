package thread;

import ui.VentanaController;

public class CircleMove extends Thread {

	VentanaController vc;

	public CircleMove(VentanaController vc) {
		this.vc = vc;
	}

//	@Override
//	public void run() {
//		int i = 0;
//		while (gc.getStop() != true) {
//			if (i < gc.getPacmans().size()) {
//				try {
//					gc.movePacman(i);
//					if (gc.getLevel() == 0)
//						sleep(10);
//					if (gc.getLevel() == 1)
//						sleep(15);
//					if (gc.getLevel() == 2)
//						sleep(5);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				i++;
//			} else {
//				i = 0;
//			}
//		}
//	}

}