package com.bilgilerveritabani;

public class Kullanici {
	private int  KullaniciNo;
	private String  KullaniciIsim;
	private String  KullaniciSoyisim;
	private  String KullaniciAdi;
	private  String  KullaniciSifre;
	public Kullanici(int KullaniciNo,String KullaniciIsim,String KullaniciSoyisim,String KullaniciAdi,String KullaniciSifre) {
		this.KullaniciNo=KullaniciNo;
		this.KullaniciIsim=KullaniciIsim;
		this.KullaniciSoyisim=KullaniciSoyisim;
		this.KullaniciAdi=KullaniciAdi;
		this.KullaniciSifre=KullaniciSifre;
	}
	public int getKullaniciNo() {
		return KullaniciNo;
	}
	public String getKullaniciIsim() {
		return KullaniciIsim;
	}
	public String getKullaniciSoyisim() {
		return KullaniciSoyisim;
	}
	public String getKullaniciAdi() {
		return KullaniciAdi;
	}
	public String getKullaniciSifre() {
		return KullaniciSifre;
	}
	
	
	
	

}
