public class Result
{
    private String winnerTeam;
    private String loserTeam;
    private int winnerGoals;
    private int loserGoals;
    private boolean isDraw;

    public boolean isIsDraw()
    {
        return this.isDraw;
    }

    public void setIsDraw(boolean isDraw)
    {
        this.isDraw = isDraw;
    }

    public Result(String winnerTeam, String loserTeam, int winnerGoals, int loserGoals, boolean isDraw)
    {
        this.winnerTeam = winnerTeam;
        this.loserTeam = loserTeam;
        this.winnerGoals = winnerGoals;
        this.loserGoals = loserGoals;
        this.isDraw = isDraw;
    }

    public String getWinnerTeam()
    {
        return this.winnerTeam;
    }

    public void setWinnerTeam(String winnerTeam)
    {
        this.winnerTeam = winnerTeam;
    }

    public String getLoserTeam()
    {
        return this.loserTeam;
    }

    public void setLoserTeam(String loserTeam)
    {
        this.loserTeam = loserTeam;
    }

    public int getWinnerGoals()
    {
        return this.winnerGoals;
    }

    public void setWinnerGoals(int winnerGoals)
    {
        this.winnerGoals = winnerGoals;
    }

    public int getLoserGoals()
    {
        return this.loserGoals;
    }

    public void setLoserGoals(int loserGoals)
    {
        this.loserGoals = loserGoals;
    }

}
