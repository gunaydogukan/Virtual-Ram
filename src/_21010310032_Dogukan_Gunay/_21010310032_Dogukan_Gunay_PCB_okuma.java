package _21010310032_Dogukan_Gunay;

public class _21010310032_Dogukan_Gunay_PCB_okuma {
	static String tut = "";
	
	public void okuma() {
		_21010310032_Dogukan_Gunay_PCB _21010310032_Dogukan_Gunay_PCB = new _21010310032_Dogukan_Gunay_PCB();
		String write = "PCB’si bulunan Prosesler: ";
		
		if(_21010310032_Dogukan_Gunay_PCB.pcbList.length==0) {
			System.out.println("PCB’si bulunan Proses bulunamadı.");
			return;
		}
		
		for (int sutun = 0; sutun < _21010310032_Dogukan_Gunay_Ram.ram.size(); sutun++) {
			String proses = _21010310032_Dogukan_Gunay_Ram.ram.get(sutun);
			write = write + getir(proses)+" ";
		}
		System.out.println(write);
	}
	
	private String getir(String proses) {
		
		for (int i = 0; i < _21010310032_Dogukan_Gunay_PCB.pcbList.length; i++) {
			String isim = _21010310032_Dogukan_Gunay_PCB.pcbList[i][0];
			if(isim.equals(proses)) {
				return isim;
			}
		}
		return "";	
	}
	
	public String istenilenProses(String proses) {
		
		for (int i = 0; i < _21010310032_Dogukan_Gunay_PCB.pcbList.length; i++) {
			for (int j = 0; j < _21010310032_Dogukan_Gunay_PCB.pcbList.length; j++) {
				String isim = _21010310032_Dogukan_Gunay_PCB.pcbList[i][0];
				if(isim.equals(proses)) {
					String numara = _21010310032_Dogukan_Gunay_PCB.pcbList[i][1];
					String zaman = _21010310032_Dogukan_Gunay_PCB.pcbList[i][2];
					String boyut = _21010310032_Dogukan_Gunay_PCB.pcbList[i][3];
					String write = "Proses numarası: "+numara+"\n"
							+ "Prosesin yaratılma zamanı: "+zaman+". Saniye\n"
							+ "Prosesin toplam büyüklüğü: "+boyut+" KB";
							return write;
				}
			}	
		}
		return "İstenilen proses bulunamadı.";
	}
	
}
