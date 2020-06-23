package hasa.hafia.entites;

import org.springframework.web.multipart.MultipartFile;

public class MyUploadForm {
	private String description;
	private  MultipartFile[] fileDatas;
	
	
	public MyUploadForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MyUploadForm(String description, MultipartFile[] fileDatas) {
		super();
		this.description = description;
		this.fileDatas = fileDatas;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile[] getFileDatas() {
		return fileDatas;
	}
	public void setFileDatas(MultipartFile[] fileDatas) {
		this.fileDatas = fileDatas;
	}
	
	
}
