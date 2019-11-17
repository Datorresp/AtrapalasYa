package thread;

import ui.VentanaController;

public class ShowFiguresThread extends Thread{

	VentanaController vc;
	

    public ShowFiguresThread(VentanaController vc) {
        this.vc = vc;
    }
	
	@Override
	public void run() {
//		while (true) {
//			try {
//				vc.openPacman();
//				sleep(400);
//				vc.closePacman();
//				sleep(400);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
	}
	
}