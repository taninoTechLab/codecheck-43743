package codecheck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
	public static void main(String[] args) {
		String[] argv = args[0].split(" ");
		int cards = Integer.parseInt(argv[0]); // カード枚数
		int cost = Integer.parseInt(argv[1]); // コスト

		List<String> attack = new ArrayList<>();
		List<String> requiredCost = new ArrayList<>();

		List<Integer[]> add = new ArrayList<>();

		//		for (int i = 0, l = argv.length; i < l; i++) {
		//			String output = String.format("argv[%s]: %s", i, argv[i]);
		//			System.out.println(output);
		//		}

		int i = 2;
		while (i < argv.length) {
			int now_cost = Integer.parseInt(argv[i + 1]);
			if (now_cost <= cost) { // コスト以下のものを配列に格納
				attack.add(argv[i]);
				requiredCost.add(argv[i + 1]);
				add.add(new Integer[] { Integer.parseInt(argv[i]), Integer.parseInt(argv[i + 1]) });
				i += 2;
			}
		}

		Stream<Integer[]> sort2 = add.stream()
				.sorted((a, b) -> b[0].compareTo(a[0]));

		sort2.forEach(j -> System.out.println("攻撃力:" + j[0] + " コスト:" + j[1]));
		List<Integer[]> add_s = sort2.collect(Collectors.toList());

		int result = 0;
		i = 0;
		while(cards > 0) {
			if (cost >= add_s.get(i)[1].intValue()) {
				result += add_s.get(i)[0].intValue();
				cost -= add_s.get(i)[1].intValue();
				cards--;
			}
			i++;
		}
		System.out.println(result);

	}
}
