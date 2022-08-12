import java.util.*;

import javax.swing.JEditorPane;

public class Main {

	public static <Replace> void main(String[] args) {	
		String a;
		int posun;
		
		

		
		//zadanie stringu
		System.out.println("Prehodit znaky v slove na ASCII: ");
		Scanner scanner = new Scanner(System.in);
		a = scanner.next();
		
		//zadanie posunu
		System.out.println("zadaj posun: ");
		posun = scanner.nextInt();
		
		scanner.close();
		
		//vytvorenie pola o velkosti slova ktore sa koduje
		char [] slovo = new char[a.length()];
		//System.out.println("slovo "+Arrays.toString(slovo));
		
		//vypisanie a posunutie znaku v slove
		for(int i = 0; i < a.length(); i++) {
			char znak_posun;
			
			int znak = a.charAt(i);
			
			//System.out.println("hodnota znaku: "+znak);
			
			//sifra sa pohybuje v rozmedzi pre male pismena a-z od 97 po 122, pre velke pismena je to od A-Z od 65 po 95
			//ak male/velke pismeno prekroci maximalnu hodnotu ako je 122 alebo 95 vrati sa naspat na hodnutu pre pociatok (97 alebo 65)
			//zistenie ci znak sa nachadza na rozhrani 97-122 pre male pismena, 65-95 pre velke pismena, specialne znaky, medzery, tabulator, cisla, posun o riadok nepreklada
			if(((znak >= 97)&&(znak <= 122))||((znak >= 65)&&(znak <= 90))) {
				//System.out.println("posunuta hodnota ascii znaku je : " + znak);
				
				//zistenie ci sa jedna o znaky malej abecedy (hodnoty od 65 - A; 90 - Z):
					if((znak >= 65)&&(znak <= 90)) {
						znak = (a.charAt(i))+posun;
						//zistenie ci je znak vacsi ako posledny znak Z(90)
						if(znak>90) {
							//zoberie hodnotu znaku, odcita od nej maximalnu hodnotu co moze dosiahnut, a prirata k tomu 64 aby sa dostal na hodnotu A a zvysok sa prirata aby sa dalej posunul
							znak = (znak-90)+64;
						}
					//konverzia ciselnej hodnoty znaku z ascii na char
					znak_posun = (char) znak;
					//System.out.println("posunuty znak je: "+znak_posun);
					
					//ulozenie znaku do pola a vytvorenie tak 
					slovo[i] = znak_posun;
					}
				
				//pre male pismena, sa najprv urci ci sa jedna o znak v danom rozmedzi (a - 97; z - 122):
					if((znak >= 97)&&(znak <= 122)) {
						//vytvorenie posunu
						znak = (a.charAt(i))+posun;
						//zistenie ci znak pretiekol alebo nie
						if(znak > 122) {
							//ak znak pretiekol tak sa potom urci spravny znak podobne ako v predchadzajucom pripade
							znak = (znak-122)+96;
						}
						
					//konverzia ciselnej hodnoty znaku z ascii na char
					znak_posun = (char) znak;
					//System.out.println("posunuty znak je: "+znak_posun);
					
					//ulozenie znaku do pola a vytvorenie tak 
					slovo[i] = znak_posun;
					}
				
			}else {
				//pre pripad ze dany znak nie je pismo
				znak_posun = (char) znak;
				slovo[i] = znak_posun;
			}

			
		}
		//vypisanie slova
		System.out.println("Zakodovane slovo je: ");
		for(char sloString : slovo) {
			System.out.print(sloString);
		}
	}
}







