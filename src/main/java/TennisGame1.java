
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private boolean isEqualScore() {
        return m_score1==m_score2;
    }

    private String getWinner(int minusResult) {
        return minusResult >= 2 ? "Win for "+ player1Name : "Win for "+ player2Name;
    }

    private String getAdvantage(int minusResult) {
        return minusResult == 1 ? "Advantage "+ player1Name : "Advantage "+ player2Name;
    }

    private boolean isMaxScore() {
        return m_score1>=4 || m_score2>=4;
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
            m_score1 += 1;
            return;
        }
        m_score2 += 1;
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
        int minusResult = m_score1-m_score2;
        return getResult(minusResult);
    }

    private String addScore() {
        switch (m_score1) {
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
                tempScore = m_score1;
            } else {
                score +="-";
                tempScore = m_score2;
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
