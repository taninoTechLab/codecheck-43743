package codecheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
	public static void main(String[] args) {
		String[] argv = args[0].split(" ");
		int cards = Integer.parseInt(argv[0]); // カード枚数
		int cost = Integer.parseInt(argv[1]); // コスト

		List<String[]> status = new ArrayList<String[]>(); //[0]:attack [1]:cost
		System.out.println(argv.length);

//		for (int i = 0, l = argv.length; i < l; i++) {
//			String output = String.format("argv[%s]: %s", i, argv[i]);
//			System.out.println(output);
//		}

		int i = 2;
		while (i < argv.length) {
			int now_cost = Integer.parseInt(argv[i + 1]);
			if (now_cost <= cost) { // コスト以下のものを配列に格納
				String[] add = new String[2];
				add[0] = argv[i];
				add[1] = argv[i+1];
				status.add(add);
				i += 2;
			}
		}

		// コスト以下で最大の攻撃力のものを先頭に並べ替える
		Collections.sort(status, Collections.reverseOrder());

		// 先頭からコストを満たす分だけ取得する
		for (i = 0 ; i < status.size(); i++) {
			System.out.println("攻撃力" + status.get(i)[0]);
			System.out.println("コスト" + status.get(i)[1]);

		}
	}
}
