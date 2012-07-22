import java.io.BufferedReader;
import java.io.IOException;


public class Comment implements Commentable{
	private BufferedReader dataBuffer;
	Comment(BufferedReader dataBuffer)
	{
		this.dataBuffer = dataBuffer;
	}
public boolean hasComment() throws IOException
{
	if(!new Content(dataBuffer).hasContent())
		return true;
return false;	
}
}
