import java.io.File;


public class DevOnly 
{
	private static final CharSequence DEV_ONLY = "devonly";
	private File f;
	DevOnly(File f)
	{
		this.f = f;
	}
	public boolean isDevOnly()
	{
		if(f.getName().toLowerCase().contains(DEV_ONLY)) return true;
		return false;
	}
}
