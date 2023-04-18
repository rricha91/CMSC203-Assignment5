import java.util.HashMap;
import java.util.Map;

class Singleton {
	//	Checks if singleton, and by extention the objects within it, have been initialized before.
    private static Singleton single_instance = null;
	
    // Objects to limit creation of.
    private static Map<Character, Character> mp;
    
    // Initializes the objects in a private constructor, restricting construction to this class.
	private Singleton() {
		mp = new HashMap<>(16);
    	mp.put('.', '.'); mp.put(',', '.');
	    mp.put('-', '-'); mp.put('–', '-'); mp.put('—', '-'); mp.put('~', '-');
	    mp.put('0', '0'); mp.put('1', '1'); mp.put('2', '2'); mp.put('3', '3'); mp.put('4', '4');
	    mp.put('5', '5'); mp.put('6', '6'); mp.put('7', '7'); mp.put('8', '8'); mp.put('9', '9');
	    }
	
    /**
     * Checks for instance of Singleton class and either creates, or references an instance accordingly.
     * Creates new Singleton instance if none exists. 
     * Returns reference to existing Singleton if one does.
     * @return Singleton - The one instance of this class allowed to exist.
     */
	public static Singleton getInstance() {
        if (single_instance == null) single_instance = new Singleton();
        return single_instance;
    }

    /**
     * Checks for instance of Singleton class and either creates, or references its hashmap accordingly.
     * Creates new Singleton instance if none exists. 
     * Returns reference to hashmap held by Singleton if it does.
     * @return mp - The one instance of this hashmap allowed to exist.
     */
	public static Map<Character, Character> getCharMap() {
        if (single_instance == null) single_instance = new Singleton();
        return mp;
	}
}
