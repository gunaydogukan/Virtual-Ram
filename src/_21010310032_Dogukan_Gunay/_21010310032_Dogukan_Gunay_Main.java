package _21010310032_Dogukan_Gunay;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class _21010310032_Dogukan_Gunay_Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		_21010310032_Dogukan_Gunay_Ram _21010310032_Dogukan_Gunay_Ram = new _21010310032_Dogukan_Gunay_Ram();
		_21010310032_Dogukan_Gunay_PCB oku = new _21010310032_Dogukan_Gunay_PCB();
		_21010310032_Dogukan_Gunay_PCB_okuma yazdir = new _21010310032_Dogukan_Gunay_PCB_okuma();

		System.out.println("Lütfen RAM’in durumunu görmek istediğiniz saniyeyi giriniz.");

		String saniye = sc.nextLine();
		
		_21010310032_Dogukan_Gunay_Ram.firstFit(saniye);
		_21010310032_Dogukan_Gunay_Ram.ram_boyut_hesabi();
		yazdir.okuma();
		
		System.out.println(saniye + ". saniyedeki PCB’sini görüntülemek istediğiniz proses ismini giriniz:");
		String proses = sc.nextLine();
	
		System.out.println(yazdir.istenilenProses(proses));

	}

}
