import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DBATool
{
	
	
	private File Report;
	/*
	private String FileName = "FileName" ;
	private String Is_Empty = "Is_Empty";
	private String Is_Fully_Commented = "Is_Fully_Commented";
	private String Has_Undo = "Has_Undo";
	private String HasDev_Only = "HasDev_Only";
	*/
	public void CreateReport() throws IOException
	{
		
		
		System.out.println("Enter the Path");
		Scanner input = new Scanner(System.in);
		String Path = input.nextLine();
		//String Path = "D:\\c";
		Report = new File(Path+"\\Report.csv");
		
		FileList list = new FileList();
		ArrayList<File> FullList = list.listAllFiles(Path);
		
		if(FullList==null)
			return;
		Report = new File(Path+"\\Report.csv");
		BufferedWriter writer = new BufferedWriter(new FileWriter(Report));
		writer.write("FileName,Change-number,Is_Empty,Is_Fully_Commented,Has_Undo,HasDev_Only");
		for(File f:FullList)
		{
			if(f.getName().lastIndexOf(".sql") > 0)
			{
				writer.newLine();	
				FileReader fr = new FileReader(f);
				//writer.write(f.getName()+","+ new EmptyFinder(data1).IsEmpty()+","+(new EmptyFinder(data2).IsEmpty() && !new Content(data3).hasContent() )+","+(new Undo().hasUndo(f) && new Content(data4).hasContent()));
				//writer.write(f.getName()+","+(new EmptyFinder(data2).IsEmpty() && !new Content(data3).hasContent() ));
				//System.out.println(f.getName()+","+ new EmptyFinder(fr.getBuffer()).IsEmpty()+","+(!new EmptyFinder(fr.getBuffer()).IsEmpty() && new Comment(fr.getBuffer()).hasComment() )+","+(new Undo().hasUndo(f) )+","+new DevOnly(f).isDevOnly());
				//System.out.println(f.getName()+","+ new EmptyFinder(fr.getBuffer()).IsEmpty()+","+(!new EmptyFinder(fr.getBuffer()).IsEmpty() && !new Content(fr.getBuffer()).hasContent() )+","+(new Undo().hasUndo(f) && !new Content(fr.getBuffer()).hasContent())+","+new DevOnly(f).isDevOnly());
				String[] ParsedName = new FileNameParser(f).getParsed();
				//System.out.print(ParsedName);
				writer.write(ParsedName[1]+","+ParsedName[0]+","+ new EmptyFinder(fr.getBuffer()).IsEmpty()+","+(!new EmptyFinder(fr.getBuffer()).IsEmpty() && new Comment(fr.getBuffer()).hasComment() )+","+(new Undo().hasUndo(f) )+","+new DevOnly(f).isDevOnly());
			}
								
		}
		writer.close();
		System.out.println("Report generated successfully.");
	}

	
}
