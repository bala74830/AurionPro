package structural.adapter.example.model;

public interface CloudStorage {
	void uploadfile(String fileName, String function);
	void downloadfile(String fileName, String function);
	void deletefile(String fileName, String function);

}
