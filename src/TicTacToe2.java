import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class TicTacToe2 {
    public static void main(String[] args) {
        // firstly we must 3 columns and 3 rows game bord
        boolean close = false;

        List<Integer> playerPositions = new ArrayList<>();
        List<Integer> cpuPositions = new ArrayList<>();
        List<Integer> selectedPosition = new ArrayList<>();
        List numbers = Arrays.asList("1","2","3","4","5","6","7","8","9");

        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        // for print we are making one metod because we are goint to use it

        printGameBoard(gameBoard);

        int userChanger = 2; // for play change user

        Scanner scan = new Scanner(System.in);

        while (true) {


            if (user(userChanger).equals("player")) {

                while (true) {
                    System.out.println("Enter your placemenet (1-9): ");

                    //nt pos = Integer.valueOf(scan.nextLine());
                    String position = scan.nextLine();

                    if ((numbers.contains(position)) && !selectedPosition.contains(position)) {
                        int pos = Integer.valueOf(position);
                        playerPositions.add(pos);
                        selectedPosition.add(pos);
                        System.out.println("Selected player positions " + playerPositions);
                        //Switch(gameBoard, pos, user(userChanger));
                        izolated(gameBoard,position, user(userChanger));
                        if (winnerCheck(playerPositions, "player").equals("2")) {
                            //printGameBoard(gameBoard);
                            System.out.println("Player wins!");
                            close = true;
                            break;
                        }
                        winnerCheck(playerPositions, "player");

                        break;
                    } else {
                        System.out.println("please try again!");
                        //printGameBoard(gameBoard);
                        continue;
                    }
                }

            } else if (user(userChanger).equals("cpu")) {

                while (true) {
                    int cpuNumber = userCPU();

                    if (!selectedPosition.contains(cpuNumber)) {

                        cpuPositions.add(cpuNumber);
                        selectedPosition.add(cpuNumber);

                        Switch(gameBoard, cpuNumber, user(userChanger));
                        System.out.println("Selected cpu positions " + cpuPositions);
                        if (winnerCheck(cpuPositions, "cpu").equals("2")) {

                            System.out.println("CPU wins!");
                            close = true;
                            break;
                        }
                        winnerCheck(cpuPositions, "cpu");

                        break;

                    } else {
                        continue;
                    }
                }
            }

            userChanger++;

            if (selectedPosition.size() == 9 || close == true) {
                break;
            }


        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void Switch(char[][] gameBoard, int number, String user) {

        if (number > 0 && number < 10) {
            char symbol = ' ';
            if (user.equals("player")) {
                symbol = 'X';
            } else if (user.equals("cpu")) {
                symbol = 'O';
            }


            switch (number) {
                case 1:
                    gameBoard[0][0] = symbol;
                    break;
                case 2:
                    gameBoard[0][2] = symbol;
                    break;
                case 3:
                    gameBoard[0][4] = symbol;
                    break;
                case 4:
                    gameBoard[2][0] = symbol;
                    break;
                case 5:
                    gameBoard[2][2] = symbol;
                    break;
                case 6:
                    gameBoard[2][4] = symbol;
                    break;
                case 7:
                    gameBoard[4][0] = symbol;
                    break;
                case 8:
                    gameBoard[4][2] = symbol;
                    break;
                case 9:
                    gameBoard[4][4] = symbol;
                    break;
                default:
                    break;
            }
            System.out.println(user + ": " + symbol);
            printGameBoard(gameBoard);

        } else {
            System.out.println("Please input 1-9 !");
        }
    }

    public static String user(int number) {
        if (number % 2 == 0) return "player";
        else {
            userCPU();
        }
        return "cpu";
    }

    public static int userCPU() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    public static String winnerCheck(List l, String user) {
        String winners = "1";
        List list1 = Arrays.asList(1, 2, 3);
        List list2 = Arrays.asList(4, 5, 6);
        List list3 = Arrays.asList(7, 8, 9);
        List list4 = Arrays.asList(1, 4, 7);
        List list5 = Arrays.asList(2, 5, 8);
        List list6 = Arrays.asList(3, 6, 9);
        List list7 = Arrays.asList(1, 5, 9);
        List list8 = Arrays.asList(3, 5, 7);
        List list9 = Arrays.asList(3, 2, 1);
        List list10 = Arrays.asList(6, 5, 4);
        List list11 = Arrays.asList(9, 8, 7);
        List list12 = Arrays.asList(7, 4, 1);
        List list13 = Arrays.asList(8, 5, 2);
        List list14 = Arrays.asList(9, 6, 3);
        List list15 = Arrays.asList(9, 5, 1);
        List list16 = Arrays.asList(7, 5, 3);


        List<List> winner = new ArrayList<List>();
        winner.add(list1);
        winner.add(list2);
        winner.add(list3);
        winner.add(list4);
        winner.add(list5);
        winner.add(list6);
        winner.add(list7);
        winner.add(list8);
        winner.add(list9);
        winner.add(list10);
        winner.add(list11);
        winner.add(list12);
        winner.add(list13);
        winner.add(list14);
        winner.add(list15);
        winner.add(list16);

        for (List k : winner) {
            if (l.containsAll(k)) {
                winners = "2";
                break;
            }
        }
        return winners;
    }

    public static void izolated(char[][] gameBoard, String text, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
        } else if (user.equals("cpu")) {
            symbol = 'O';
        }
        text = text.toLowerCase();
        text = text.trim();

        if (text.equals("1")) {
            gameBoard[0][0] = symbol;
        } else if (text.equals("2")) {
            gameBoard[0][2] = symbol;
        } else if (text.equals("3")) {
            gameBoard[0][4] = symbol;
        } else if (text.equals("4")) {
            gameBoard[2][0] = symbol;
        } else if (text.equals("5")) {
            gameBoard[2][2] = symbol;
        } else if (text.equals("6")) {
            gameBoard[2][4] = symbol;
        } else if (text.equals("7")) {
            gameBoard[4][0] = symbol;
        } else if (text.equals("8")) {
            gameBoard[4][2] = symbol;
        } else if (text.equals("9")) {
            gameBoard[4][4] = symbol;
        }
        printGameBoard(gameBoard);
    }
}
