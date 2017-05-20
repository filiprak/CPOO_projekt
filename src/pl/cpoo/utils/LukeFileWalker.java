package pl.cpoo.utils;
import java.io.File;
import java.util.Vector;

/**
 * Obiekt tej klasy przechowuje wektor nazw plik�w z rozszerzeniami okre�lonymi sta�� znajduj�ce si� w katalogu programu
 * 
 * @author Kot
 *
 */

public class LukeFileWalker{
	/**
	 * Sta�a trzymaj�ca obs�ugiwane typy plik�w 
	 */
	protected static  final String[] EXTENSIONS = new String[]{
	        ".gif", ".png", ".bmp", ".jpg", ".JPG" // and other formats you need
	    };
	/**
	 * Wektor odczytanych nazw plik�w
	 */
	protected Vector <String> listOfImages;
	
	/**
	 * konstruktor wyszukuje pliki o zgodnym rozszerzeniu
	 */
	public LukeFileWalker (String SourcesFolderName)
	{
		
		listOfImages = new Vector<String>();
		try{
			File sourceFolder = new File(System.getProperty("user.dir") + File.separator + SourcesFolderName);
			File[] listOfFiles = sourceFolder.listFiles();
			
			    for (int i = 0; i < listOfFiles.length; i++) 
			    {
			    	if (listOfFiles[i].isFile()) 
			    	{
			    		for (final String ext : EXTENSIONS) 
			    			if (listOfFiles[i].getName().endsWith(ext))
			    			{ 
			    				//System.out.println("File " + listOfFiles[i].getName());  
			    				listOfImages.addElement(listOfFiles[i].getName());
			    			}
			    	}
			    }
			}
			catch(Exception e)
			{
				System.out.println("Wyj�tek podczas inicjalizacji:  LukeFileWraper " + e.toString());
			}
	}
	
	/**
	 * 
	 * @return Wektor nazw znalezionych plik�w.
	 */
	public Vector<String> get() {return listOfImages;}
	
}