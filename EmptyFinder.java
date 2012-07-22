import java.io.BufferedReader;
import java.io.IOException;


public class EmptyFinder {
	private BufferedReader dataBuffer;
	public EmptyFinder(BufferedReader dataBuffer) {
		// TODO Auto-generated constructor stub
		this.dataBuffer = dataBuffer;
	}
	public Boolean IsEmpty() throws IOException
	{
		
		String line;
		while((line=dataBuffer.readLine())!=null)
			if(!(line.trim()).isEmpty()) return false;
		return true;
	}
}
