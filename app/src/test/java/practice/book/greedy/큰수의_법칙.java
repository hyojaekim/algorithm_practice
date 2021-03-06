package practice.book.greedy;

import java.util.Arrays;

public class 큰수의_법칙 {

    public int solution(int N, int M, int K, int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int first = numbers[numbers.length - 1];
        int second = numbers[numbers.length - 2];

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (cnt == K) {
                cnt = 0;
                answer += second;
            } else {
                answer += first;
                cnt++;
            }
        }
        return answer;
    }

    public int solution2(int N, int M, int K, int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int first = numbers[numbers.length - 1];
        int second = numbers[numbers.length - 2];

        int firstCnt = ((M / (K + 1)) * K) + (M % (K + 1));
        int secondCnt = M / (K + 1);

        answer += (first * firstCnt);
        answer += (second * secondCnt);
        return answer;
    }
}
