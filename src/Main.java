import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<GirlFriend> girlFriendsList = new ArrayList<>();

    public Main() {
        girlFriendsList.add(new GirlFriend("미숙", 38, "교사", "ISFP", 0));
        girlFriendsList.add(new GirlFriend("옥자", 40, "카페사장", "ESFJ", 0));
        girlFriendsList.add(new GirlFriend("숙자", 41, "학원강사", "ENFP", 0));
    }

    public void printGirlFriendList() {
        System.out.println("\n상대 목록:");
        System.out.println("\n아래 상대 중 한 명을 골라주세요\n");
        String format = "%-3s%-12s%-15s%-12s%s"; // 각 정보를 가로로 정렬하기 위한 포맷
        System.out.printf(format, "번호", "이름", "직업", "MBTI", "호감도");
        System.out.println();
        for (int i = 0; i < girlFriendsList.size(); i++) {
            GirlFriend gf = girlFriendsList.get(i);
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

    public GirlFriend selectGirlFriend(Scanner scanner) {
        GirlFriend selectedGirlFriend = null;
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

    public void handleChoice(Scanner scanner, GirlFriend selectedGF) {
        String[] choices = {
                "언제까지 그렇게 재실 건가요",
                "사랑은 머리로 하는 게 아니라 가슴으로 하는 거거든요",
                "얘기를 하지 말라!"
        };
        int choice = getChoice(scanner, choices);

        switch (choice) {
            case 1:
                selectedGF.increaseLike(20);
                break;
            case 2:
                selectedGF.increaseLike(30);
                break;
            case 3:
                selectedGF.increaseLike(-5);
                break;
        }
    }

    public void startInteractions(Scanner scanner) {
        while (true) {
            GirlFriend selectedGF = selectGirlFriend(scanner);
            handleChoice(scanner, selectedGF);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Jinuk jinuk = new Jinuk("진욱", 40, "개발자", "ENTP");
        System.out.println("\n나는 SOLO에 오신 걸 환영합니다!!");
        System.out.println("당신은 결혼을 하기 위해 이 프로그램에 출연 했습니다");
        System.out.println("매번 이벤트가 있기 전에 여성 한 명을 고를 수 있고 선택지에 따라서 여성의 호감도가 오릅니다");
        System.out.println("게임이 종료될 때까지 호감도를 100까지 올리지 못하면 실패합니다");
        System.out.println("호감도가 100이 된 여성이 있으면 결혼을 하고 게임이 끝나며 다음은 당신의 현재 상태입니다.\n");
        jinuk.introduce();

        main.printGirlFriendList();

        Scanner scanner = new Scanner(System.in);
        GirlFriend selectedGirlFriend = main.selectGirlFriend(scanner);
        main.handleChoice(scanner, selectedGirlFriend);

        main.printGirlFriendList();

        main.startInteractions(scanner);

        boolean marriageSuccess = false;
        for (GirlFriend gf : main.girlFriendsList) {
            if (gf.like >= 100) {
                marriageSuccess = true;
                System.out.println("\n축하합니다!\n나 김진욱은! 40 넘어서 미친 사랑을 하게 해준 "+gf.name + "을(를) 최종 선택하겠습니다!!");
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
