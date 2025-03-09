package structural.adapter.example.model;

public class Adapter implements GoogleDriveAPI{
	
	private CloudStorage cloudstorage;
	
	public Adapter(String function) {
		
		if(function.equalsIgnoreCase("upload")) {
			
			cloudstorage = new UploadFile();
		}
		else if (function.equalsIgnoreCase("delete")) {
			cloudstorage = new DeleteFile();
		}
		else if(function.equalsIgnoreCase("download")) {
			cloudstorage = new DownloadFile();
		}
	}

	@Override
	public void newfunction(String fileName, String function) {
		if(function.equalsIgnoreCase("upload")) {
			cloudstorage.uploadfile(fileName, function);
			
		}
		else if(function.equalsIgnoreCase("delete")) {
			cloudstorage.deletefile(fileName, function);
		}
		else if(function.equalsIgnoreCase("download")) {
			cloudstorage.downloadfile(fileName, function);
		}
		
	}

}
