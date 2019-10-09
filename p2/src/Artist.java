public class Artist {
    private String name;
    private int mobileNo;
    private String companyAddress;

    public Artist(String name) {
        this.name = name;
        mobileNo = 0;
        companyAddress = null;
    }
    public Artist(String name, int mobileNo, String companyAddress) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.companyAddress = companyAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
