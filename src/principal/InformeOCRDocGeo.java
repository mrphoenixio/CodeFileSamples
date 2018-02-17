package principal;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

public class InformeOCRDocGeo {

    public static void main(String[] args) {

	    String ruta = getDirectory();
	    listDirectoryRec(ruta);
	    searchFileOrDirectory(ruta,"CursoPython");
	    
    }
    
    // Search a file or directory in a directory
    public static boolean searchFileOrDirectory ( String path, String searched ) {
    		
    		File[] list = new File( path ).listFiles();
    		
    		if ( list != null ) {

    			for ( File file_tmp : list ) {
    				
    				if( searched.equals(file_tmp.getName())) 
    					return true;
    				
    				if ( file_tmp.isDirectory() ) 
    					listDirectoryRec( file_tmp.getAbsolutePath() );							

    			}

    		}
    		
    		return false;
    }
    
    // List a directory recursively
    public static void listDirectoryRec( String path ) {

        File[] list = new File( path ).listFiles();
        
        if ( list != null ) {
        		
        		for ( File file_tmp : list ) {
        			
                if ( file_tmp.isDirectory() ) {
                		listDirectoryRec( file_tmp.getAbsolutePath() );
                		System.out.println( "Dir: " + file_tmp.getAbsoluteFile() );
                }
                else {
                    	System.out.println( "File: " + file_tmp.getAbsoluteFile() );
                }
                
            }
        		
        }
        
    }
    
    // Show JFileChooser to select a directory
    private static String getDirectory() {
    		 
    		String ruta = "";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Component comp = null;
		int seleccion = fileChooser.showOpenDialog(comp);
		
		switch( seleccion ) {
		
			case JFileChooser.APPROVE_OPTION:
				
				ruta = fileChooser.getSelectedFile().toString();
			
			break;
			
			case JFileChooser.CANCEL_OPTION:
				
				ruta = "No file selected";
				
			break;

		}

		return ruta;
		
    }
    
    
    
}
