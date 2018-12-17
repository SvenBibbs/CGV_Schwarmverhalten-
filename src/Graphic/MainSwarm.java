package Graphic;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.Display;
import Algebra.Vektor2D;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;

public class MainSwarm extends BasisFenster {
	private ObjektManager objektManager;
	private int Anzahl = 750;				// Anzahl der Kreise
	
	public MainSwarm() {
		super("CGV2-Beleg Schwarmverhalten", 1280, 720);
		objektManager = ObjektManager.getExemplar();
		erzeugeobjektManager(Anzahl);
	}
	
	public void erzeugeobjektManager(int anz) {
		Random rand = ThreadLocalRandom.current();
		for (int i = 0; i < anz; i++) {
			Kreis kreis = new Kreis(new Vektor2D(rand.nextInt(1280), rand.nextInt(720)), new Vektor2D(0, rand.nextFloat()+1), 3, 0, 1, 1);
			kreis.setVerhalten(new KreisVerhalten(kreis));
			kreis.setObjektManager(objektManager);
			objektManager.registriereKreis(kreis);
		}
		Ziel neuesZiel = new Ziel(new Vektor2D(590,310),new Vektor2D(), 100, 0,0,0);
		neuesZiel.setVerhalten(new MausVerhalten(neuesZiel));
		neuesZiel.setObjektManager(objektManager);
		objektManager.registriereZiel(neuesZiel);
	}
	
	@Override
	public void renderLoop(){
		while (!Display.isCloseRequested()) {
			glClearColor(1, 1, 1, 1);					// Fensterfarbe
			glClear(GL_COLOR_BUFFER_BIT);
	        glMatrixMode (GL_PROJECTION);
	        glLoadIdentity ();
	        glOrtho (0, 1280, 720, 0, 0, 1);
	        glMatrixMode (GL_MODELVIEW);
	        glDisable(GL_DEPTH_TEST);

	        objektManager.getZielMap().forEach(new BiConsumer<Integer, Ziel>() {
				@Override
				public void accept(Integer id, Ziel ziel) {
					ziel.render();
					ziel.update();
				}
			});
	        
	        for (int i = 0; i < objektManager.getKreisSize(); i++) {
	        	Kreis thisKreis = objektManager.getKreis(i);
	        	thisKreis.render();
	        	thisKreis.update();
	        }
	        Display.update();
	        Display.sync(30);		// fps
		}
	}
	
	
	public static void main (String[] args) {
		new MainSwarm().start();
	}
	
	
}
