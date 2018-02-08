import java.awt.Component;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.JFileChooser;

public class InformeOCRDocGeo {

    public static void main(String[] args) {

	    String ruta = getDirectory();
	    
	    
	    
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
    
    // llamada al servicio OCRDocuemtal
    private static void consultaOCRDocumental() throws IOException {
    		
    		String URL = "http://...";
		URL obj = new URL(URL);
		HttpsURLConnection conex = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		conex.setRequestMethod("POST");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		conex.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(conex.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = conex.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + URL);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(conex.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
    	
    }
    
}
