import java.io.File;


public class FileNameParser {
	private File f;
public FileNameParser(File f) {
	// TODO Auto-generated constructor stub
	this.f = f;
}

public String[] getParsed()
{
	String[] parseName;
	String fileName = f.getName().replaceAll(".sql", "");
	parseName =  fileName.split(" ");
	return parseName;	
}
}
