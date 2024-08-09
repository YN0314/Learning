package learning.sample.main;

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
        // TODO
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
        // TODO
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
        // TODO
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
        // TODO
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
