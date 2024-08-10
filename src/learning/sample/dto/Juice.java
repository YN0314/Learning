package learning.sample.dto;

/**
 * ジュースクラス
 */
public class Juice {
    /** 価格 */
    private int price;
    /** 味 */
    private String taste;

    /** コンストラクタ */
    public Juice() {}

    /** 価格をセットします */
    public void setPrice(int price) {
        this.price = price;
    }

    /** 価格を取得します */
    public int getPrice() {
        return this.price;
    }

    /** 味をセットします */
    public void setTaste(String taste) {
        this.taste = taste;
    }

    /** 味を取得します */
    public String getTaste() {
        return this.taste;
    }

    /**
     * ジュースインスタンス生成
     * 
     * @param taste 味
     * @param price 価格
     * @return ジュースインスタンス
     */
    public static Juice of(String taste, int price) {
        Juice instance = new Juice();
        instance.setPrice(price);
        instance.setTaste(taste);
        return instance;
    }
}
