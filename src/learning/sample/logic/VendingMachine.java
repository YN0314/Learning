package learning.sample.logic;

import java.util.*;
import learning.sample.dto.Juice;

/**
 * 自動販売機クラス
 */
public class VendingMachine {
    /** ジュースリスト */
    private List<Juice> juices;
    /** キャッシャー */
    private List<Integer> casher;

    /** コンストラクタ */
    public VendingMachine() {
        // 初期化
        this.juices = new ArrayList<>();
        this.casher = new ArrayList<>();
    }

    /**
     * ジュースリストにジュースを追加します
     * 
     * @param juice ジュース
     */
    public void addJuice(Juice juice) {
        this.juices.add(juice);
    }

    /**
     * ジュースを購入します
     * 
     * <p>
     * リストに味と金額が合うジュースがなければnullを返却します
     * </p>
     * 
     * @param taste 味
     * @param price 金額
     * @return ジュース
     */
    public Juice buy(String taste, int price) {
        if (this.juices.isEmpty()) {
            return null;
        }
        Juice target = null;
        for (Juice juice : this.juices) {
            if (juice.getPrice() == price && juice.getTaste().equals(taste)) {
                target = juice;
                // 金額をキャッシャーに追加
                this.casher.add(price);
                break;
            }
        }
        return target;
    }

    /**
     * 現在の売り上げ金額を返却する。
     * 
     * @return トータル売り上げ
     */
    public int totalCash() {
        int total = 0;
        for (Integer cash : this.casher) {
            total = total + cash;
        }
        return total;
    }
}
