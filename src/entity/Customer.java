package entity;

public class Customer {
	private int cid;
	private String cname;
	private long cphone;
	private String cemail;
	private String cpan;
	private double camt;
	private Address caddress;

	public Customer(int cid, String cname, long cphone, String cemail, String cpan, Address caddress) {
		this.cid = cid;
		this.cname = cname;
		this.cphone = cphone;
		this.cemail = cemail;
		this.cpan = cpan;
		this.caddress = caddress;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public long getCphone() {
		return cphone;
	}

	public void setCphone(long cphone) {
		this.cphone = cphone;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCpan() {
		return cpan;
	}

	public void setCpan(String cpan) {
		this.cpan = cpan;
	}

	public Address getCaddress() {
		return caddress;
	}

	public void setCaddress(Address caddress) {
		this.caddress = caddress;
	}

	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", cid=" + cid + ", cphone=" + cphone + ", cemail=" + cemail + ", cpan="
				+ cpan + ", caddress=" + caddress + "]";
	}

	public double getCamt() {
		return camt;
	}

	public void setCamt(double camt) {
		this.camt = camt;
	}

//	public void setCaddress(String doorno, String street, String dist, String state, String country, int pincode) {
//		this.caddress = new Address(doorno, street, dist, state, country, pincode);
//	}
}
