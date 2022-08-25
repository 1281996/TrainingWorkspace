import java.util.List;
import java.util.Optional;

public class StreamsPratice {

	public static void main(String[] args) {

		Optional<Integer> sum = List.of(1, 2, 34, 5).stream().reduce((a, b) -> a + b);
		Optional<Integer> product = List.of(1, 2, 34, 5).stream().reduce((a, b) -> a * b);
		Optional<Integer> minus = List.of(1, 2, 34, 5).stream().reduce((a, b) -> a - b);
		Optional<Integer> divide = List.of(1, 2, 34, 5).stream().reduce((a, b) -> a / b);
		System.out.println(sum.get() + "-" + product.get() + "-" + minus.get() + "-" + divide.get());

		Long count = List.of(1, 2, 34, 5, 6).stream().peek(data -> System.out.println(data)).count();
		System.out.println(count);
	}

}
