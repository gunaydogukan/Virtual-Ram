package _21010310032_Dogukan_Gunay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _21010310032_Dogukan_Gunay_dosyaOkuma {

	public static String[][] data;
	public ArrayList<String[]> temp = new ArrayList<>();
	public String dosya_adi="girdi.txt";
	
	public _21010310032_Dogukan_Gunay_dosyaOkuma() throws FileNotFoundException {
		System.out.println(dosya_adi+" dosyası okundu.");
		okuma();
	}

	public void okuma() throws FileNotFoundException {
		
		Scanner dosya = new Scanner(new File(dosya_adi));
		
		
		while (dosya.hasNext()) {
			String satir = dosya.nextLine();
			String[] veriler = satir.split(" ");
			temp.add(veriler);
		}

		data = new String[temp.size()][7];

		for (int index = 0; index < temp.size(); index++) {
			data[index] = temp.get(index);
		}
	}

}
