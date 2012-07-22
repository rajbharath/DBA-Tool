import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class Undo implements Commentable{
	private static BufferedReader dataBuffer;
	public boolean hasUndo(File f) throws IOException
	{
	String line="";
	FileReader fr = new FileReader(f);
	dataBuffer = fr.getBuffer();
	while((line=dataBuffer.readLine())!=null)
	{
		if(line.contains(UNDO_PART))
			if(hasContent()){
				return true;
			}
				
	}
		return false;
	}
	
	
	private boolean hasContent() throws IOException
	{
		String line="";
		while((line=dataBuffer.readLine())!=null)
		{
			String trimmedLine = line.trim();
			if((trimmedLine.length() > 0 && !trimmedLine.contains(COMMENT_START) && !trimmedLine.contains(COMMENT_END) && !trimmedLine.contains(SINGLE_COMMENT) && !trimmedLine.contains(UNDO_PART)))
			{
				return true;
			}
			if(line.contains(COMMENT_START))
				if(checkContent(line)){
					return true;
				}
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
