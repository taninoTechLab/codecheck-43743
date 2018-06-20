package codecheck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		String[] argv = args[0].split(" ");
		int cards = Integer.parseInt(argv[0]); // カード枚数
		int cost = Integer.parseInt(argv[1]); // コスト
		List<Integer[]> add = new ArrayList<>();

		int i = 2;
		while (i < argv.length) {
			add.add(new Integer[] { Integer.parseInt(argv[i]), Integer.parseInt(argv[i + 1]) });
			i += 2;
		}

		List<Integer[]> add_s = add.stream()
				.sorted((a, b) -> b[0].compareTo(a[0])).collect(Collectors.toList());

		//		add_s.forEach(j -> System.out.println("攻撃力:" + j[0] + " コスト:" + j[1]));

		int result = 0;
		i = 0;
		while (cards > 0) {
			if (add_s.size() == i) {
				break;
			}
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
