package codecheck;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		String[] argv = args[0].split(" ");
		int cards = Integer.parseInt(argv[0]); // カード枚数
		int cost = Integer.parseInt(argv[1]); // コスト

		List<String> attack = new ArrayList<String>();
		List<String> requiredCost = new ArrayList<String>();
		System.out.println(argv.length);

		for (int i = 0, l = argv.length; i < l; i++) {
			String output = String.format("argv[%s]: %s", i, argv[i]);
			System.out.println(output);
		}

		int i = 2;
		while (i < argv.length) {
			int now_cost = Integer.parseInt(argv[i + 1]);
			if (now_cost <= cost) { // コスト以下のものを配列に格納
				attack.add(argv[i]);
				System.out.println(" 攻撃力" + argv[i]);
				requiredCost.add(argv[i + 1]);
				System.out.println(" コスト" + argv[i + 1]);
				i += 2;
			}
		}

		// コスト以下で最大の攻撃力のものを先頭に並べ替える
		boolean change = true;
		i = 0;
		while(change) {
			if(Integer.parseInt(attack.get(0)) < Integer.parseInt(attack.get(i+1))) {
				String now_attack = attack.get(i+1);
				attack.remove(i+1);
				attack.set(0, now_attack);

				String now_cost = requiredCost.get(i+1);
				requiredCost.remove(i+1);
				requiredCost.set(0, now_cost);
				i++;
			} else {
				change = false;
			}
		}


		// 先頭からコストを満たす分だけ取得する
		for (i = 0 ; i < attack.size(); i++) {
			System.out.println("攻撃力" + attack.get(i));
			System.out.println("コスト" + requiredCost.get(i));

		}
	}
}
