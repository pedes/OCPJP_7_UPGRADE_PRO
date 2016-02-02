package _5_localization;

import java.text.NumberFormat;
import java.util.Locale;

public class Advantages {

	public Advantages() {
		// TODO Auto-generated constructor stub
	}

	public void metodo() {
		int i = 14_092_011;
		System.out.println(NumberFormat.getInstance().format(i));
		Locale l3 = new Locale("en", "US");
		System.out.print(l3 + " uses ");
		System.out.println(NumberFormat.getInstance(l3).format(i));
	}

	public static void main(String[] args) {
		new Advantages().metodo();
	}
}
