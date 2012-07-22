import java.io.*;
public class FileReader {
	private File f;
	public FileReader(File f) {
		// TODO Auto-generated constructor stub
		this.f=f;
	}
	
	public BufferedReader getBuffer() throws IOException
	{
		FileInputStream inputFile = new FileInputStream(f);
		inputFile.getChannel().position(0);
		DataInputStream fileData =  new DataInputStream(inputFile);
		return new BufferedReader(new InputStreamReader(fileData));
		
	}
	
}
