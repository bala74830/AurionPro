package structural.adapter.example.model;

public class DeleteFile implements CloudStorage{

	@Override
	public void uploadfile(String fileName, String function) {
		//not supported
		
	}

	@Override
	public void downloadfile(String fileName, String function) {
		// not supported
		
	}

	@Override
	public void deletefile(String fileName, String function) {
		System.out.println("deleted file: " +fileName);
		
	}

}
