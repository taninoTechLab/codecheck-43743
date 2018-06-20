package codecheck;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		String[] argv = args[0].split(" ");
		//		String cards = args[0];
		//		String req_cost = args[1];
		//		int cards = Integer.parseInt(args[0]); // カード枚数
		//		int cost = Integer.parseInt(args[1]); // コスト

		List<String> attack = new ArrayList<String>();
		List<String> requiredCost = new ArrayList<String>();
		System.out.println(argv.length);

		for (int i = 0, l = argv.length; i < l; i++) {
			String output = String.format("argv[%s]: %s", i, argv[i]);
			System.out.println(output);
		}

		int i = 2;
		while (i < argv.length) {
			attack.add(argv[i]);
			System.out.println(" 攻撃力" + argv[i]);
			requiredCost.add(argv[i + 1]);
			System.out.println(" コスト" + argv[i + 1]);
			i += 2;
		}

		// コスト以下のものを配列に格納
		// コスト以下で最大の攻撃力のものを先頭に並べ替える
		// 先頭からコストを満たす分だけ取得する

	}
}
