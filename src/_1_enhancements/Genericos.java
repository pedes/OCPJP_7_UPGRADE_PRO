package _1_enhancements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Genericos {

	public Genericos() {
		// TODO Auto-generated constructor stub
	}
	
	public void metodo (){
		// la mejora es que el lado de la declaracion no necesita definir el tipo, se infiere
		// <> es llamado el operador diamond
		Map<String, List<String>> myMap = new HashMap<>();
		
		
		Map<String, List<String>> otherMap = new HashMap(); // unchecked conversion warning

	}

}
