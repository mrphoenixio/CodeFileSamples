package principal;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.JFileChooser;

public class InformeOCRDocGeo {

    public static void main(String[] args) {

	    String ruta = getDirectory();
	    File dir = new File(ruta); 
	    List<String> listFich = arrayToList(dir.list());		// Lista que almacenara los fciheros/carpetas
 
	    String rutaTMP = ruta;
    		File file_tmp = null;
	    	for (int i=0 ; i < listFich.size() ; i++) {
	    		
	    		file_tmp = new File(rutaTMP + "/" + listFich.get(i).toString());

	    		if(file_tmp.isDirectory()) {
	    			System.out.println(file_tmp.getName() + " --> Es Carpeta");
	    			String tmpArray[] = file_tmp.list();
	    			//rutaTMP = rutaTMP + "/" + listFich.get(i).toString();
	    			for (int j = 0; j < tmpArray.length; j++) {
					listFich.add(tmpArray[j]);
				}
	    			
	    		}else {
	    			System.out.println(file_tmp.getName());
	    		}
	    		
	    	}
	    
    }
    
    private static List<String> arrayToList(String array[]){
    		
    		List<String> lista = new ArrayList<String>();
    		
    		for (int i = 0; i < array.length; i++) {
    			lista.add(array[i]);
    		} 
    		
    		return lista;
    }
    
    // Lanza el panel de seleccion de directorio
    private static String getDirectory() {
    		 
    		String ruta = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Component comp = null;
		int seleccion = fileChooser.showOpenDialog(comp);
		
		if (seleccion == JFileChooser.APPROVE_OPTION)
		{
			File fichero = fileChooser.getSelectedFile();
			System.out.println(fichero.toString());
			ruta = fichero.toString();
			
		}
		
		return ruta;
		
    }
    
    
    
}
