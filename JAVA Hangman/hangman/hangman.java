import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class hangman {
    // '-'변환
    public static String Masking(String word, char[] characters) {
        int length = word.length();
        int n_keep = (int) Math.ceil(length * 0.7);
        int n_mask = length - n_keep;

        List<Integer> rnd = new ArrayList<>();
        for (int i = 0; i < length; i += 1) {
            rnd.add(i);
        }
        Collections.shuffle(rnd);

        for (int i = 0; i < n_mask; i += 1) {
            characters[rnd.get(i)] = '-';
        }
        return new String(characters);
    }

    // 행맨 그림
    public static void man(int count) throws IOException {
        switch (count) {
            case 1:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 2:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 3:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 4:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 5:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 6:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
        }
    }
    public static void main (String[]args) throws IOException {
        int win = 0;
        int lose = 0;

        Scanner s = new Scanner(System.in);
        String user = null;

        String fpath = "words.txt"; // file 위치 (경로에 맞게 수정바람)
        List<String> wordlist = Files.readAllLines(Paths.get(fpath));
            // 10회 기회 부여
        for (int i = 0; i < 10; i += 1) {
            int count = 1;

            // 랜덤 단어 찾기
            String[] words = wordlist.toArray(new String[0]);
            String _word = null;
            double random = Math.random();
            int num = (int) Math.round(random * (words.length - 1));
            _word = words[num];
            // 확인용
//            System.out.println(_word);


            char[] goal = _word.toCharArray();
            String question = Masking(_word, goal);

            // 5회 기회 부여
            System.out.println("-------------------------");
            System.out.printf("%d번째 시도 ", i + 1);
            System.out.printf("(%d승 %d패)\n", win, lose);
            for (int j = 1; j < 6; j += 1) {
                man(count);
                // 단어 30%만 남기고 '-'로 치환
                System.out.println(question);
                System.out.printf("정답 (남은 기회 %d) : ", 6 - j);
                user = s.next();
                System.out.println("-------------------------");
                count += 1;

                if (user.equals(_word)) {
                    win += 1;
                    break;

                } else if (count == 6) {
                    lose += 1;
                    man(count);
                    break;
                }
            }


            // 패배
            if (lose == 3) {
                System.out.println("패배! ㅠㅠ");
                break;
            }
            // 승리
            if (win == 10) {
                System.out.printf("승리! (%d승 %d패)", win, lose);
                break;
            }
        }
    }
}