package _21010310032_Dogukan_Gunay;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _21010310032_Dogukan_Gunay_Ram {
	_21010310032_Dogukan_Gunay_dosyaOkuma oku = new _21010310032_Dogukan_Gunay_dosyaOkuma();

	public int bitis_kontrol = 0;
	public int maxSize = 10240;
	
	public String OS = "1000";
	public String[][] bitis = new String[oku.temp.size()][2];
	public String[][] proses_size; 
	
	public Queue<String> bekleme = new LinkedList<>(); 
	public static ArrayList<String> ram = new ArrayList<>();
	public ArrayList<String> ram_alaniBoyut = new ArrayList<>();

	public _21010310032_Dogukan_Gunay_Ram() throws FileNotFoundException {
		ram.add(OS);
		ram_alaniBoyut.add(OS);
		boyutHesap();
		bas_kuyruk();
		bit_kuyruk();
	}

	public void firstFit(String saniye) throws FileNotFoundException {

		int bas_index = 0;
		int sayac = 0;
		int saniye_int = Integer.parseInt(saniye);
		int index_size;
		int index_bitis;
		int eklenen_proses_sayisi = 1;
		String proses_isim;
		String proses_boyut;
		String proese_bitis_suresi;

		for (int index = 0; index <=saniye_int; index++) {
			if (ram.size() == 1) {
				
				String[] temp = bekleme.peek().split(",");
				//System.out.println(temp[1]);
				if(index>=Integer.parseInt(temp[1].trim())) {
					
					ram.add(temp[0].trim());
					bekleme.remove();
					bas_index = Integer.parseInt(temp[1].trim()); 
					index = bas_index;
					;

					proses_isim = ram.get(eklenen_proses_sayisi);
					index_size = compare_size(proses_isim);
					proses_boyut = proses_size[index_size][1]; 
					
					ram_alaniBoyut.add(proses_boyut);
				}
				
			} else {

				if (!bekleme.isEmpty()) {

					String[] temp = bekleme.peek().split(","); 
					proses_isim = temp[0];

					bas_index = Integer.parseInt(temp[1].trim());
										
					if(saniye_int<bas_index) {
						bitisKontrol(saniye_int);
						continue;
					}else {
						index = bas_index;
					}	

					index_size = compare_size(proses_isim);
					proses_boyut = proses_size[index_size][1];

					if (bitisKontrol(bas_index)) {
						index--;
						
						continue; 
					}

					if (ram.contains(null)) {
						
						boolean eklendi = false;
						for (int i = 0; i < ram.size(); i++) {
							String s_null = ram.get(i);

							if (s_null == null) {
								int index_null = i;
								int boyut_kontrol = Integer.parseInt(ram_alaniBoyut.get(index_null));
								
								if (boyut_kontrol == Integer.parseInt(proses_boyut)) {
									
									ram.set(index_null, proses_isim.trim());

									bas_index = Integer.parseInt(temp[1].trim());
									index = bas_index;

									bekleme.remove();
									
									eklendi = true;
									break;

								} else if (boyut_kontrol > Integer.parseInt(proses_boyut)) {
								
									int yeni_alanBoyutu = boyut_kontrol - Integer.parseInt(proses_boyut);
									ram.add((index_null + 1), null);
									ram.set(index_null, proses_isim.trim());
									ram_alaniBoyut.set(index_null, proses_boyut.trim());
									ram_alaniBoyut.add((index_null + 1), String.valueOf(yeni_alanBoyutu).trim());

									bas_index = Integer.parseInt(temp[1].trim());
									index = bas_index;
									

									bekleme.remove();
									eklendi = true;
									break;

								} else {
									
								}
							}
						}
						if (!eklendi) { 

							ram.add(proses_isim.trim());
							ram_alaniBoyut.add(proses_boyut.trim());

							bas_index = Integer.parseInt(temp[1].trim());
							index = bas_index;
							
							bekleme.remove();
						}

					} else {

						int toplam = 0;
						for (int i = 0; i < ram_alaniBoyut.size(); i++) {
							toplam = toplam + Integer.parseInt(ram_alaniBoyut.get(i).trim());
						}
						if (maxSize > (toplam + Integer.parseInt(proses_boyut))) {
							bekleme.remove(); 
							ram.add(proses_isim.trim());
							ram_alaniBoyut.add(proses_boyut.trim()); 

							bas_index = Integer.parseInt(temp[1].trim());
							index = bas_index;
							
						} else {
							break; 
						}
					}

				} else {
					if(index<=saniye_int) { 
						bitisKontrol(index);
						continue;
					}else {
						break;
					}
					
				}
				
			}
		}

	}


	public void ram_boyut_hesabi() {
		System.out.println("0. Ve 1023999. Adresler arasında işletim sistemi bulunmaktadır.");

		String isim;
		int toplam = 1024000;
		int boyut;
		int eksi = -1;
		boolean kontrol = false;
		if(ram.size()!=1) {
			boyut = Integer.parseInt(ram_alaniBoyut.get(1));
		}else {
			return;
		}
		

		for (int i = 1; i < ram.size(); i++) {
			isim = ram.get(i);
			if (!(ram.get(i) == null)) {
				boyut = boyut * 1024;

				if (!kontrol) {
					System.out.print(toplam + ". ve ");
					toplam = toplam + eksi + boyut;

					kontrol = true;
				}
				if (kontrol) {

					System.out.println(toplam + ". Adresler arasında " + isim + " programı bulunmaktadır.");
					kontrol = false;
					if (i == (ram.size() - 1)) {
						break;
					} else {
						boyut = Integer.parseInt(ram_alaniBoyut.get(i + 1));
					}
					toplam++;
				}

			} else {
				toplam = toplam + (boyut * 1024);
				if((i+1)>=ram.size()) {
					break;
				}else {
					boyut = Integer.parseInt(ram_alaniBoyut.get(i + 1));
				}
			}
		}

	}
	
	public boolean bitisKontrol(int current_saniye) {
		int kuyruk_sirasi_suresi=0;
		if(bitis_kontrol>=bitis.length) {
			return false;
		}else {
			kuyruk_sirasi_suresi = Integer.parseInt(bitis[bitis_kontrol][1].trim());
		}
		

		if (current_saniye >= kuyruk_sirasi_suresi) {
			String proses_isim = bitis[bitis_kontrol][0];
			int index_size = index_size = compare_size(proses_isim);
			proses_bitis(bitis_kontrol, index_size);
			bitis_kontrol++;
			return true;
		} else {
			return false;
		}

	}
	
	public void proses_bitis(int bitis_kontrol, int index_size) {
		if (ram.contains(bitis[bitis_kontrol][0])) {
			int index = ram.indexOf(bitis[bitis_kontrol][0].trim()); 
			ram.set(index, null);
			String isim = bitis[bitis_kontrol][0].trim();
			for (int i = 0; i < oku.data.length; i++) {
				//System.out.println(oku.data[i][0].trim());
				if(oku.data[i][0].trim().equals(isim)) {
					isim=oku.data[i][1].trim();
				}
			}
		}
	}
	
	public int compare_bitis(String isim) {
		int index = 0;
		for (int i = 0; i < bitis.length; i++) {
			if (isim.trim().equals(bitis[i][1].trim())) {
				index = i;
				break;
			}
		}

		return index;
	}
	
	public int compare_size(String isim) {
		int index = 0;
		for (int i = 0; i < proses_size.length; i++) {
			if (isim.trim().equals(proses_size[i][0].trim())) {
				index = i;
				break;
			}
		}

		return index;

	}
	
	public void boyutHesap() {

		proses_size = new String[oku.temp.size()][2];
		int toplam = 0;
		String kb = "";
		for (int sutun = 0; sutun < oku.data.length; sutun++) {
			for (int satir = 3; satir < oku.data[sutun].length; satir++) {
				kb = oku.data[sutun][satir];
				toplam = toplam + Integer.parseInt(kb.trim());

			}
			kb = oku.data[sutun][0];
			proses_size[sutun][0] = kb;
			kb = String.valueOf(toplam);
			proses_size[sutun][1] = kb;
			toplam = 0;
		}

	}
	
	public void bas_kuyruk() {
		String temp[] = new String[oku.data.length];
		for (int i = 0; i < oku.data.length; i++) {
			temp[i] = oku.data[i][0] + " , " + oku.data[i][1]; 
		}
		temp = sort(temp);
		for (int i = 0; i < temp.length; i++) {
			bekleme.add(temp[i]); 
		}
	}
	
	public void bit_kuyruk() {

		String temp[] = new String[oku.data.length];
		for (int i = 0; i < oku.data.length; i++) {
			temp[i] = oku.data[i][0] + " , " + oku.data[i][2]; 
		}
		temp = sort(temp);

		for (int i = 0; i < temp.length; i++) {
			String[] bol = temp[i].split(",");
			bitis[i][0] = bol[0].trim(); 
			bitis[i][1] = bol[1].trim();
		}
	}
	
	public String[] sort(String[] dizi) {
		int size = dizi.length;
		int sayi1;
		int sayi2;
		int min_index;

		for (int i = 0; i < dizi.length - 1; i++) {
			min_index = i;
			for (int j = i + 1; j < dizi.length; j++) {
				String[] bol_1 = dizi[min_index].split(",");
				String[] bol_2 = dizi[j].split(",");

				sayi1 = Integer.parseInt(bol_1[1].trim());
				sayi2 = Integer.parseInt(bol_2[1].trim());

				if (sayi1 > sayi2) {
					min_index = j;
				}
			}
			if (min_index != i) {
				String temp = dizi[i];
				dizi[i] = dizi[min_index];
				dizi[min_index] = temp;
			}
		}
		return dizi;
	}

}
