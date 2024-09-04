package _21010310032_Dogukan_Gunay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class _21010310032_Dogukan_Gunay_PCB {
	static String[][] pcbList = new String[_21010310032_Dogukan_Gunay_dosyaOkuma.data.length][4];

	public _21010310032_Dogukan_Gunay_PCB() {
		PcbOlustur();
	}
	
	public void PcbOlustur() {
		Arrays.sort(_21010310032_Dogukan_Gunay_dosyaOkuma.data, (a, b) -> Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])));
		int pid=1000;
        for (int i = 0; i < _21010310032_Dogukan_Gunay_dosyaOkuma.data.length; i++) {
            int sum = 0;
            for (int j = 3; j < _21010310032_Dogukan_Gunay_dosyaOkuma.data[i].length; j++) { 
                sum += Integer.parseInt(_21010310032_Dogukan_Gunay_dosyaOkuma.data[i][j]);
            }
            pcbList[i][0] = _21010310032_Dogukan_Gunay_dosyaOkuma.data[i][0]; 
            pcbList[i][1]=String.valueOf(pid);   
            pcbList[i][2]=_21010310032_Dogukan_Gunay_dosyaOkuma.data[i][1]; 
            pcbList[i][3] = String.valueOf(sum); 
            pid++;
        }
	}

	
	
}
