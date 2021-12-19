
public class TennisGame1 implements TennisGame {
    
    private int playerScore1 = 0;
    private int playerScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private boolean isEqualScore() {
        return playerScore1==playerScore2;
    }

    private String getWinner(int minusResult) {
        String winner = minusResult >= 2 ? player1Name : player2Name;
        return "Win for "+ winner;
    }

    private String getAdvantage(int minusResult) {
        String namePlayer = minusResult == 1 ? player1Name : player2Name;
        return "Advantage "+ namePlayer ;
    }

    private boolean isMaxScore() {
        return playerScore1>=4 || playerScore2>=4;
    }

    private boolean isAdvantage(int minusResult) {
        return minusResult == 1 || minusResult == -1;
    }


    private String getResult(int minusResult) {
        if (isAdvantage(minusResult)){
            return getAdvantage(minusResult);
        }
        return getWinner(minusResult);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)){
            playerScore1 += 1;
            return;
        }
        playerScore2 += 1;
    }

    public String getScore() {
        if (isEqualScore()) {
            return addScore();
        } else if (isMaxScore()) {
            return getScoreWinner();
        }
        return calculateScore();
    }

    private String getScoreWinner() {
        int minusResult = playerScore1-playerScore2;
        return getResult(minusResult);
    }

    private String addScore() {
        switch (playerScore1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String calculateScore() {
        int tempScore;
        String score = "";
        for (int i = 1; i<3; i++) {
            if (i == 1) {
                tempScore = playerScore1;
            } else {
                score +="-";
                tempScore = playerScore2;
            }
            score += addTemporalScore(tempScore);
        }
        return score;
    }

    private String addTemporalScore(int tempScore) {
        switch(tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}
