import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // 기본 사람 클래스
    class Person {
        String name;
        int age;
    }

    // 주인공
    class Jinuk extends Person {
        String job;
        String MBTI;

        Jinuk(String name, int age, String job, String MBTI) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.MBTI = MBTI;
        }

        void introduce() {
            System.out.println("이름: " + name);
            System.out.println("나이: " + age);
            System.out.println("직업: " + job);
            System.out.println("MBTI: " + MBTI);
        }
    }

    // 여자친구 클래스
    class girlFriend extends Jinuk {
        int like;

        girlFriend(String name, int age, String job, String MBTI, int like) {
            super(name, age, job, MBTI); // Jinuk의 생성자 호출
            this.like = like;
        }

        void increaseLike(int amount) {
            like += amount;
        }
    }

    // 여자친구 인스턴스들을 저장할 ArrayList 선언
    ArrayList<girlFriend> girlFriendsList = new ArrayList<>();

    public Main() {
        // 여자친구 인스턴스들 추가
        girlFriendsList.add(new girlFriend("미숙", 38, "교사", "ISFP", 0));
        girlFriendsList.add(new girlFriend("옥자", 40, "카페사장", "ESFJ", 0));
        girlFriendsList.add(new girlFriend("숙자", 41, "학원강사", "ENFP", 0));
    }

    public void printGirlFriendList() {
        System.out.println("\n상대 목록:");
        System.out.println("\n아래 상대 중 한 명을 골라주세요\n");
        String format = "%-3s%-12s%-15s%-12s%s"; // 각 정보를 가로로 정렬하기 위한 포맷
        System.out.printf(format, "번호", "이름", "직업", "MBTI", "호감도");
        System.out.println();
        for (int i = 0; i < girlFriendsList.size(); i++) {
            girlFriend gf = girlFriendsList.get(i);
            System.out.printf(format, (i + 1) + ".", gf.name, gf.job, gf.MBTI, gf.like);
            System.out.println();
        }
    }

    public int getChoice(Scanner scanner, String[] choices) {
        System.out.println("\n선택지를 입력하세요:");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
        System.out.print("선택: ");
        int choice = scanner.nextInt();

        while (choice < 1 || choice > choices.length) {
            System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            System.out.print("선택: ");
            choice = scanner.nextInt();
        }
        return choice;
    }

    public girlFriend selectGirlFriend(Scanner scanner) {
        girlFriend selectedGirlFriend = null;
        boolean validGirlFriend = false;

        while (!validGirlFriend) {
            System.out.print("\n선택할 상대의 번호를 입력해주세요: ");
            int selectedGirlFriendIndex = scanner.nextInt();

            if (selectedGirlFriendIndex >= 1 && selectedGirlFriendIndex <= girlFriendsList.size()) {
                selectedGirlFriend = girlFriendsList.get(selectedGirlFriendIndex - 1);
                validGirlFriend = true;
            } else {
                System.out.println("잘못된 번호를 선택하였습니다. 다시 선택해주세요.");
            }
        }

        return selectedGirlFriend;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Jinuk jinuk = main.new Jinuk("진욱", 40, "개발자", "ENTP");
        System.out.println("\n나는 SOLO에 오신 걸 환영합니다!!");
        System.out.println("당신은 결혼을 하기 위해 이 프로그램에 출연 했습니다");
        System.out.println("매번 이벤트가 있기 전에 여성 한 명을 고를 수 있고 선택지에 따라서 여성의 호감도가 오릅니다");
        System.out.println("게임이 종료될 때까지 호감도를 100까지 올리지 못하면 실패합니다");
        System.out.println("호감도가 100이 된 여성이 있으면 결혼을 하고 게임이 끝나며 다음은 당신의 현재 상태입니다.\n");
        jinuk.introduce();

        main.printGirlFriendList();

        // 선택지를 입력받아 호감도를 증가시키는 부분
        Scanner scanner = new Scanner(System.in);
        girlFriend selectedGirlFriend = main.selectGirlFriend(scanner);

        String[] choices = {
                "언제까지 그렇게 재실 건가요",
                "사랑은 머리로 하는 게 아니라 가슴으로 하는 거거든요",
                "얘기를 하지 말라!"
        };
        int choice = main.getChoice(scanner, choices);

        switch (choice) {
            case 1:
                selectedGirlFriend.increaseLike(20);
                break;
            case 2:
                selectedGirlFriend.increaseLike(30);
                break;
            case 3:
                selectedGirlFriend.increaseLike(-5);
                break;
        }

        main.printGirlFriendList();

        // 두 번째 선택을 하기
        girlFriend secondSelectedGirlFriend = main.selectGirlFriend(scanner);

        String[] secondChoices = {
                "쿵할게요",
                "내가 푼 문제의 정답은 너야",
                "어이구 아가야!"
        };
        int secondChoice = main.getChoice(scanner, secondChoices);

        switch (secondChoice) {
            case 1:
                secondSelectedGirlFriend.increaseLike(10);
                break;
            case 2:
                secondSelectedGirlFriend.increaseLike(40);
                break;
            case 3:
                secondSelectedGirlFriend.increaseLike(20);
                break;
        }

        main.printGirlFriendList();

        // 세 번째 선택을 하기
        girlFriend thirdSelectedGirlFriend = main.selectGirlFriend(scanner);

        String[] thirdChoices = {
                "파스타나 만들어 먹자",
                "조곤조곤, 섹시한, 츤데레",
                "내 드라마의 주인공은 너였어"
        };
        int thirdChoice = main.getChoice(scanner, thirdChoices);

        switch (thirdChoice) {
            case 1:
                thirdSelectedGirlFriend.increaseLike(10);
                break;
            case 2:
                thirdSelectedGirlFriend.increaseLike(20);
                break;
            case 3:
                thirdSelectedGirlFriend.increaseLike(30);
                break;
        }

        main.printGirlFriendList();

        // 호감도가 100이 된 상대가 있는지 확인하고, 게임 종료 또는 최종 선택 진행
        boolean marriageSuccess = false;
        for (girlFriend gf : main.girlFriendsList) {
            if (gf.like >= 100) {
                marriageSuccess = true;
                System.out.println("\n축하합니다!\n나 김진욱은! 40 넘어서 미친 사랑을 하게 해준 "+gf.name+"을(를) 최종 선택하겠습니다!!");
                System.out.println("나! 너 때문에 미칠것 같다!!! 나랑 살자!!!");
                break;
            }
        }

        if (!marriageSuccess) {
            System.out.println("\n100이 넘는 호감도를 얻지 못해 결혼에 실패했습니다.");
            System.out.println("더 많은 노력으로 다른 여성들과도 만나보세요!");
        }

        scanner.close();
    }
}
