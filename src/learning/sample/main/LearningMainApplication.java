package learning.sample.main;

import java.util.*;
import learning.sample.dto.Juice;
import learning.sample.logic.VendingMachine;

/**
 * 学習用 Javaロジック実行メインクラス
 */
public class LearningMainApplication {
    /**
     * メイン処理
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 課題1
        sample01();
        sample02();
        sample03();
        sample04();
        sample05();
    }

    /**
     * ジュースクラスの作成
     * 
     * <p>
     * 1. Juiceクラスをdtoパッケージに作成してください。Juiceクラスには、金額と味を設定できるようにしてください。<br>
     * 2.作ったクラスで、下記のインスタンスを作成し、味と金額をコンソールに出力してください。<br>
     * <li>インスタンス１】味：コーラ、金額：110円
     * <li>インスタンス２】味：レッドブル、金額：220円
     * </p>
     */
    public static void sample01() {
        System.out.println("-----[sample01]-----");
        Juice cola = Juice.of("コーラ", 110);
        Juice redbull = Juice.of("レッドブル", 220);

        System.out.println(String.format("味：%s、金額：%d円", cola.getTaste(), cola.getPrice()));
        System.out.println(String.format("味：%s、金額：%d円", redbull.getTaste(), redbull.getPrice()));
    }

    /**
     * 自動販売機の作成
     * 
     * <p>
     * 1. Juiceクラスを出力するVendingMachineクラスをloginパッケージに作成してください。<br>
     * VendingMachineクラスは、Jucieクラスのインスタンスを複数保持できるようにしてください。<br>
     * VendingMachineクラスには、金額と味を指定することで、条件に合致するJucieクラスのインスタンスを一つ返却する機能を用意してください。<br>
     * 2. 作ったクラスで、下記のインスタンスを作成し、処理を実行してください。<br>
     * VendingMachineクラスに下記のJucieインスタンスを保持させてください。<br>
     * <p>
     * Jucieインスタンス
     * </p>
     * <li>1: 味：コーラ、金額：110円
     * <li>2: 味：ファンタグレープ、金額：110円
     * <li>3: 味：ミネラルウォータ、金額：100円
     * <li>4: 味：レッドブル、金額：220円
     * <li>5: 味：モンスター、金額：220円 <br>
     * 3. 実行する処理 各Jucieインスタンスを取得して、味と金額を各々コンソールに出力してください。<br>
     * 取得したJucieインスタンスは、VendingMachineから削除してください。
     * </p>
     */
    public static void sample02() {
        System.out.println("-----[sample02]-----");
        VendingMachine juiceVender = new VendingMachine();
        refillVendingMachien(juiceVender, new ArrayList<>());

        buy("ファンタグレープ", 110, juiceVender);
        buy("コーラ", 110, juiceVender);
        buy("モンスター", 220, juiceVender);
        buy("ミネラルウォータ", 100, juiceVender);
        buy("レッドブル", 220, juiceVender);
    }

    /**
     * 自動販売機から指定のジュースを購入して、どのジュースを購入できたのかを出力する。
     * 
     * @param taste 味
     * @param price 金額
     * @param juiceVender 自動販売機
     */
    private static void buy(String taste, int price, VendingMachine juiceVender) {
        Juice juice = juiceVender.buy(taste, price);
        if (juice != null) {
            System.out.println(juiceMessage(juice));
        } else {
            System.out.println(String.format("%sは、売り切れ。", taste));
        }
    }

    /**
     * ジュースの味と金額を出力します。
     * 
     * @param juice ジュース
     * @return
     */
    private static String juiceMessage(Juice juice) {
        final String FORMAT = "味：%s、金額：%d円";
        return String.format(FORMAT, juice.getTaste(), juice.getPrice());
    }

    /**
     * ジュースを補充します。
     * 
     * @param juiceVender 自動販売機
     */
    private static void refillVendingMachien(VendingMachine juiceVender, List<Juice> stocks) {
        if (stocks.isEmpty()) {
            stocks.addAll(Arrays.asList(Juice.of("コーラ", 110), Juice.of("ファンタグレープ", 110),
                    Juice.of("ミネラルウォータ", 100), Juice.of("レッドブル", 220), Juice.of("モンスター", 220)));
        }
        for (Juice juice : stocks) {
            juiceVender.addJuice(juice);
        }
    }

    /**
     * 売り上げ管理機能追加
     * 
     * <p>
     * 1. VendingMachineクラスに以下の機能を追加してください。<br>
     * 投入した金額を加算して保持するようにしてください。<br>
     * 金額を出力処理を作成してください。<br>
     * 金額を出力したら保持している金額は削除してください。<br>
     * 2. 作った機能で処理を実行してください。<br>
     * sample02と同じ処理を行い、最終的な加算金額を出力、コンソールに出力してください。
     * </p>
     */
    public static void sample03() {
        System.out.println("-----[sample03]-----");
        VendingMachine juiceVender = new VendingMachine();
        refillVendingMachien(juiceVender, new ArrayList<>());

        buy("ファンタグレープ", 110, juiceVender);
        buy("コーラ", 110, juiceVender);
        buy("モンスター", 220, juiceVender);
        buy("ミネラルウォータ", 100, juiceVender);
        buy("レッドブル", 220, juiceVender);

        System.out.println(String.format("今回の売り上げ金額は、%d円", juiceVender.totalCash()));
    }

    /**
     * ジュース在庫管理機能
     * 
     * <p>
     * 1. VendingMachineクラスに以下の機能を追加してください。<br>
     * 同じ味のJuiceインスタンスを複数保持できるようにしてください。<br>
     * 保持した味のJucieインスタンスの味ごとの数を確認できるようにしてください。<br>
     * 2. 作った機能で処理を実行してください。<br>
     * 下記のJucieインスタンスを保持してください。<br>
     * <li>コーラ：３
     * <li>ファンタグレープ：２
     * <li>ミネラルウォータ：１１
     * <li>レッドブル：５
     * <li>モンスター：１ <br >
     * 保持したジュースの数を出力、コンソールに出力してください。
     * </p>
     */
    public static void sample04() {
        System.out.println("-----[sample04]-----");
        VendingMachine juiceVender = new VendingMachine();
        refillVendingMachien(juiceVender, generateJuices());
        juiceVender.printStocks();
    }

    /**
     * ジュースの補充データを用意する
     * 
     * @return ジュースリスト
     */
    private static List<Juice> generateJuices() {
        List<Juice> stocks = new ArrayList<>();
        List<Juice> colas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            colas.add(Juice.of("コーラ", 110));
        }
        List<Juice> fantas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            fantas.add(Juice.of("ファンタグレープ", 110));
        }
        List<Juice> waters = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            waters.add(Juice.of("ミネラルウォータ", 110));
        }
        List<Juice> redbulls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            redbulls.add(Juice.of("レッドブル", 220));
        }
        List<Juice> monsters = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            monsters.add(Juice.of("モンスター", 220));
        }
        stocks.addAll(colas);
        stocks.addAll(fantas);
        stocks.addAll(waters);
        stocks.addAll(redbulls);
        stocks.addAll(monsters);
        return stocks;
    }

    /**
     * 不足機能検討と実装
     * 
     * <p>
     * sample04 までに作った機能を駆使して、自動販売機として足りないものを想像して、実装してください。<br>
     * 完成した自動販売機機能で好きなようにロジックを組んでください。
     * </p>
     */
    public static void sample05() {
        System.out.println("-----[sample05]-----");
        // TODO
    }
}
