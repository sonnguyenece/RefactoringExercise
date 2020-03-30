public class TennisGame {
    public static final int ZEROPOINT = LOVE;
    public static final int FIFTEEN = 1;
    public static final int THIRTY=2;
    public static final int FOURTY = 3;
    public static final int PLAYER1ADVANTAGEPOINT = 1;
    public static final int PLAYER2ADVANTAGEPOINT = -1;
    public static final int SETWINPOINT = 2;
    public static int tempScore = 0;
    public static String score = "";

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {

        if (player1Score == player2Score) {
            displayEqualPoint(player1Score);
        } else if (player1Score >= FOURTY || player2Score >= FOURTY) {
            displayWhenOver40Point(player1Score, player2Score);
        } else {
            displayPoint(player1Score, player2Score);
        }
        return score;
    }

    public static void displayPoint(int player1Score, int player2Score) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case ZEROPOINT:
                    score += "Love";
                    break;
                case FIFTEEN:
                    score += "Fifteen";
                    break;
                case THIRTY:
                    score += "Thirty";
                    break;
                case FOURTY:
                    score += "Forty";
                    break;
            }
        }
    }

    public static void displayWhenOver40Point(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == PLAYER1ADVANTAGEPOINT) score = "Advantage player1";
        else if (minusResult == PLAYER2ADVANTAGEPOINT) score = "Advantage player2";
        else if (minusResult >= SETWINPOINT) score = "Win for player1";
        else score = "Win for player2";
    }

    public static void displayEqualPoint(int player1Score) {
        switch (player1Score) {
            case ZEROPOINT:
                score = "Love-All";
                break;
            case FIFTEEN:
                score = "Fifteen-All";
                break;
            case THIRTY:
                score = "Thirty-All";
                break;
            case FOURTY:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
    }
}
