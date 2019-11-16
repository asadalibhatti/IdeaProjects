public class Artist {
    private String name;
    private int id;
    private String companyAddress;

    public Artist(String name) {
        this.name = name;
        id = 0;
        companyAddress = null;
    }
    public Artist(String name, int id) {
        this.name = name;
        this.id = id;
        companyAddress = null;
    }
    public Artist(String name, int mobileNo, String companyAddress) {
        this.name = name;
        this.id = mobileNo;
        this.companyAddress = companyAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMobileNo() {
        return id;
    }

    public void setMobileNo(int mobileNo) {
        this.id = mobileNo;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
