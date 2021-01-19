package com.kunstNovi.model;


public class kunstResponse {
  
    private int id;
  
    private String titel;
   
    private String beschrijving;
  
    private long prijs;
   
    private int periode;

    private String fileName;

    private String fileType;

    
    private byte[] data;

 


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public long getPrijs() {
		return prijs;
	}

	public void setPrijs(long prijs) {
		this.prijs = prijs;
	}

	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	
    

}