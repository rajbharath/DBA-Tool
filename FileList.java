import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class FileList {
	private File Location;
	
	private static ArrayList<File> FullList = new ArrayList<File>();
	public ArrayList<File> listAllFiles(String Path) throws IOException
	{
		Location = new File(Path);
		File[] list = Location.listFiles();
		if(list != null)
		for(File f:list)
		{
			if(f.isDirectory()) listAllFiles(f.getAbsolutePath());
			FullList.add(f);
		}
		return FullList;
	}

}
