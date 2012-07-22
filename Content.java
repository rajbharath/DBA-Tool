import java.io.BufferedReader;
import java.io.IOException;


public class Content implements Commentable{
	private BufferedReader dataBuffer;
public Content(BufferedReader dataBuffer) {
		// TODO Auto-generated constructor stub
	this.dataBuffer = dataBuffer;
	}

public boolean hasContent() throws IOException
{
	
	String line="";	
	while((line=dataBuffer.readLine())!=null)
	{
		String trimmedLine = line.trim();
		if((trimmedLine.length() > 0 && !trimmedLine.contains(COMMENT_START) && !trimmedLine.contains(COMMENT_END) && !trimmedLine.contains(SINGLE_COMMENT) && !trimmedLine.contains(UNDO_PART)))
			return true;
		if(line.contains(COMMENT_START))
			if(checkContent(line)) return true;
	}
return false;	
}

private boolean checkContent(String line) throws IOException
{
			if(line.trim().indexOf(COMMENT_START)!=0) return true;
			else 
				do
				{
					if(line.contains(COMMENT_END))
					{
						if(line.trim().indexOf(COMMENT_END)!= (line.trim().length()-2))
							return true;
						return false;
					}
				}while((line=dataBuffer.readLine())!=null);
			
			
		
		return false;
	}
}
