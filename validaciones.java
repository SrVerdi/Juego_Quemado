package Juego;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validaciones {
	public boolean esPalabra(String letra) {
		Pattern patronAbc = Pattern.compile("^[a-zA-Zñ]{1,23}$");
		Matcher matcher = patronAbc.matcher(letra);
		return matcher.matches();
		}

	
		
	}

