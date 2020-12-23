package com.bilgilerveritabani;



public class Urunler {
	private int UrunNo;
	private String  UrunIsim;
	private String  UrunMarka;
	private int UrunFiyat;
	private String  UrunKategori;
	
	public Urunler(int UrunNo,String UrunIsim,String UrunMarka,int UrunFiyat,String UrunKategori) {
		this.UrunNo=UrunNo;
		this.UrunIsim=UrunIsim;
		this.UrunMarka=UrunMarka;
		this.UrunFiyat=UrunFiyat;
		this.UrunKategori=UrunKategori;
		
	}

	public int getUrunNo() {
		return UrunNo;
	}

	public String getUrunIsim() {
		return UrunIsim;
	}

	public String getUrunMarka() {
		return UrunMarka;
	}

	public int getUrunFiyat() {
		return UrunFiyat;
	}

	public String getUrunKategori() {
		return UrunKategori;
	}
	
	

}
