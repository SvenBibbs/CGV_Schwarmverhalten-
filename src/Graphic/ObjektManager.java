package Graphic;
import java.util.HashMap;

public class ObjektManager {
	private HashMap<Integer, Kreis> bewegen;
	private HashMap<Integer, Ziel> ziehen;
	private static ObjektManager exemplar = new ObjektManager();
	
	private ObjektManager() {
		bewegen = new HashMap<>();
		ziehen = new HashMap<>();
	}
	
	public static ObjektManager getExemplar(){
		return exemplar;
	}
	
	public void registriereKreis(Kreis obj) {
		bewegen.put(obj.id, obj);
	}
	
	public void registriereZiel(Ziel obj) {
		ziehen.put(obj.id, obj);
	}
	
	public Kreis getKreis(int objID) {		// bestimmter Partikel
		return bewegen.get(objID);
	}
	
	public Ziel getZiel(int objID) {		// das Ziel
		return ziehen.get(objID);
	}
	
	public HashMap<Integer, Ziel> getZielMap(){
		return ziehen;
	}
	
	public int getKreisSize() {				// Schwarmgröße?
		return bewegen.size();
	}
	
	public int getZielSize() {				// Wie viel Ziele?
		return ziehen.size();
	}
}
