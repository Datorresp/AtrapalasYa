package thread;

import ui.VentanaController;

public class ChoqueDevueta extends Thread{

	VentanaController vc;

	public ChoqueDevueta(VentanaController vc) {
		this.vc = vc;
	}
	
	@Override
	public void run() {
//		while (true) {
//			try {
//				v.Colision();
//				sleep(50);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
}