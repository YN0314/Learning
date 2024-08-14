package learning.sample.logic;

import java.util.*;
import learning.sample.dto.Juice;

/**
 * 自動販売機クラス
 */
public class VendingMachine {
    /** ジュースマップ */
    private Map<String, Deque<Juice>> stockMap;
    /** キャッシャー */
    private List<Integer> casher;

    /** コンストラクタ */
    public VendingMachine() {
        // 初期化
        this.stockMap = new LinkedHashMap<>();
        this.casher = new ArrayList<>();
    }

    /**
     * ジュースリストにジュースを追加します
     * 
     * @param juice ジュース
     */
    public void addJuice(Juice juice) {
        if (this.stockMap.containsKey(juice.getTaste())) {
            this.stockMap.get(juice.getTaste()).add(juice);
        } else {
            this.stockMap.put(juice.getTaste(), new LinkedList<>(Arrays.asList(juice)));
        }
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
        Deque<Juice> juiceQueue = this.stockMap.get(taste);
        if (juiceQueue == null) {
            return null;
        }
        if (juiceQueue.isEmpty()) {
            return null;
        }
        Juice target = juiceQueue.getFirst();
        if (target.getPrice() != price) {
            return null;
        }
        return juiceQueue.pop();
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

    /**
     * 現在のジュース在庫を表示する。
     */
    public void printStocks() {
        if (this.stockMap.isEmpty()) {
            return;
        }
        this.stockMap.keySet().stream().forEach(key -> {
            long count = this.stockMap.get(key).stream().count();
            System.out.println(String.format("【在庫】%s: %d個", key, count));
        });
    }
}
