package city;

public class City {
	private int Id;
	private String country ; 
	private String region;   
	private String city;
	private String postalCode;
	private float lattitude;
	private float longitude;
	private int metroCode;
	private int areaCode;
	
	public City() {}
	   public City(String cntry, String rgn, String Ccity , String postal, float latt , float longi, int metro, int area ) {
	      //this.Id = id;
	      this.country = cntry;
	      this.region = rgn;
	      this.city = Ccity;
	      this.postalCode = postal;
	      this.lattitude = latt;
	      this.longitude = longi;
	      this.metroCode = metro;
	      this.areaCode = area;
	   }
	   public int getId() {
	      return Id;
	   }
	   public void setId( int id ) {
	      this.Id = id;
	   }
	   public String getCountry() {
	      return country;
	   }
	   public void setCountry( String c ) {
	      this.country = c;
	   }
	   public String getRegion() {
	      return region;
	   }
	   public void setRegion( String R ) {
	      this.region = R;
	   }
	   public String getCity() {
	      return city;
	   }
	   public void setCity( String CC ) {
	      this.city = CC;
	   }
	   public String getpostalCode() {
		      return postalCode;
	   }
	   public void setpostalCode( String P ) {
		      this.postalCode = P;
	   }
	   public int getmetroCode() {
		      return metroCode;
	   }
	   public void setmetroCode( int M ) {
		      this.metroCode = M;
	   }
	   public int getareaCode() {
		      return areaCode;
	   }
	   public void setareaCode( int A ) {
		      this.areaCode = A;
	   }
	   public float getlattitude()
	   {
		   return lattitude;
	   }
	   public void setlattitude( float L)
	   {
		   this.lattitude = L;
	   }
	   public float getlongitude()
	   {
		   return longitude;
	   }
	   public void setlongitude( float Ll)
	   {
		   this.longitude = Ll;
	   }
	   
}
