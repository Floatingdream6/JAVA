package Util;

public class Address {
    private String name;
    private int telephone;
    private String address;
    private int ziocode;         //邮编
    private String acquiesce;       //是否为默认地址
    private String owner;

    public Address() {
    }

    public Address(String name, int telephone, String address, int ziocode, String acquiesce, String owner) {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.ziocode = ziocode;
        this.acquiesce = acquiesce;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZiocode() {
        return ziocode;
    }

    public void setZiocode(int ziocode) {
        this.ziocode = ziocode;
    }

    public String getAcquiesce() {
        return acquiesce;
    }

    public void setAcquiesce(String acquiesce) {
        this.acquiesce = acquiesce;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
