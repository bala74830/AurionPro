package structural.adapter.example.model;

public class UploadFile implements CloudStorage {

	@Override
	public void uploadfile(String fileName, String function) {
		System.out.println("uploaded File: " +fileName);
		
	}


	@Override
	public void downloadfile(String fileName, String function) {
		// not supported
		
	}

	@Override
	public void deletefile(String fileName, String function) {
		// not supported
		
	}

}
