package codecheck;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {

//		int cards = Integer.parseInt(args[0]); // カード枚数
//		int cost = Integer.parseInt(args[1]); // コスト
		String cards = args[0];
		String req_cost = args[1];
		List<String> attack = new ArrayList<String>();
		List<String> requiredCost = new ArrayList<String>();

		for (int i = 0, l = args.length; i < l; i++) {
			String output = String.format("argv[%s]: %s", i, args[i]);
			System.out.println(output);
		}
		for (int i = 2, l = args.length; i < l; i++) {

			attack.add(args[i]);
			System.out.println(" 攻撃力" +args[i]);
			requiredCost.add(args[i+1]);
			System.out.println(" コスト" +args[i+1]);
			i++;
		}

		// コスト以下のものを配列に格納
		// コスト以下で最大の攻撃力のものを先頭に並べ替える
		// 先頭からコストを満たす分だけ取得する


	}
}
