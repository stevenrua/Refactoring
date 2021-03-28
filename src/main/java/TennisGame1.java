
public class TennisGame1 implements TennisGame {
    
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            playerOnePoints += 1;
        else
            playerTwoPoints += 1;
    }

    public String getScore() {
        String score = "";

        if (compareScoreEquals())
            return scoreEquals(score);

        if (compareScoreGreaterThan4())
           return scoreGreaterThan4(score);

        return otherScore(score);
    }

    public String scoreEquals(String score){
        switch (playerTwoPoints)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    public String scoreGreaterThan4(String score){
        int advantageplayer = playerOnePoints - playerTwoPoints;
        if (advantageplayer == 1) return "Advantage player1";
        if (advantageplayer == -1) return "Advantage player2";
        if (advantageplayer >= 2) return  "Win for player1";
        return "Win for player2";
    }

    public String otherScore(String score){
        int currentPlayerScore =0;
        StringBuilder scoreBuilder = new StringBuilder(score);
        for (int i = 1; i<3; i++)
        {
            if (i==1) currentPlayerScore = playerOnePoints;
            else {
                scoreBuilder.append("-");
                currentPlayerScore = playerTwoPoints;
            }
            switch(currentPlayerScore)
            {
                case 0:
                    scoreBuilder.append("Love");
                    break;
                case 1:
                    scoreBuilder.append("Fifteen");
                    break;
                case 2:
                    scoreBuilder.append("Thirty");
                    break;
                case 3:
                    scoreBuilder.append("Forty");
                    break;
            }
        }
        score = scoreBuilder.toString();
        return score;
    }

    public boolean compareScoreEquals(){
        return (playerOnePoints == playerTwoPoints);
    }

    public boolean compareScoreGreaterThan4(){
        return (playerOnePoints >=4 || playerTwoPoints >=4);
    }


}
