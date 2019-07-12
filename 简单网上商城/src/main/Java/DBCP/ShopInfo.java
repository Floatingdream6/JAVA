package DBCP;
public class ShopInfo {
    private String name;                //名称
    private double price;               //价格
    private int number;              //数量
    private String area;               //产地
    private String belong;

    public ShopInfo() {
    }

    public ShopInfo(String name, double price, int number, String area,String belong) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.area = area;
        this.belong = belong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", area='" + area + '\'' +
                ", belong='" + belong + '\'' +
                '}';
    }
}
