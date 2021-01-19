package com.kunstNovi.model;


import javax.persistence.*;

@Entity
@Table(name = "files")
public class kunst {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titel;
    @Column
    private String beschrijving;
    @Column
    private long prijs;
    @Column
    private int periode;
    @Column
    private String fileName;
    @Lob
    private byte[] data;

    public kunst() {

    }

	public kunst(int id, String titel, String beschrijving, long prijs, int periode, String fileName, 
			byte[] data) {
		super();
		this.id = id;
		this.titel = titel;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
		this.periode = periode;
		this.fileName = fileName;
		this.data = data;
	}


	
	

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



	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
    

}