package Util;

public class ShopCarInfo {
    private String shopname;                //名称
    private double shopprice;               //价格
    private int shopnumber;              //数量
    private String shoparea;               //产地
    private String owner;                   //拥有者

    public ShopCarInfo() {
    }

    public ShopCarInfo(String shopname, double shopprice, int shopnumber, String shoparea,String owner) {
        this.shopname = shopname;
        this.shopprice = shopprice;
        this.shopnumber = shopnumber;
        this.shoparea = shoparea;
        this.owner=owner;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public double getShopprice() {
        return shopprice;
    }

    public void setShopprice(double shopprice) {
        this.shopprice = shopprice;
    }

    public int getShopnumber() {
        return shopnumber;
    }

    public void setShopnumber(int shopnumber) {
        this.shopnumber = shopnumber;
    }

    public String getShoparea() {
        return shoparea;
    }

    public void setShoparea(String shoparea) {
        this.shoparea = shoparea;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
