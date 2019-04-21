package Util;

public class ShopInfo {
    private String shopname;                //名称
    private double shopprice;               //价格
    private String shopnumber;              //数量
    private String shoparea;               //产地

    public ShopInfo() {
    }

    public ShopInfo(String shopname, double shopprice, String shopnumber, String shoparea) {
        this.shopname = shopname;
        this.shopprice = shopprice;
        this.shopnumber = shopnumber;
        this.shoparea = shoparea;
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

    public String getShopnumber() {
        return shopnumber;
    }

    public void setShopnumber(String shopnumber) {
        this.shopnumber = shopnumber;
    }

    public String getShoparea() {
        return shoparea;
    }

    public void setShoparea(String shoparea) {
        this.shoparea = shoparea;
    }
}
