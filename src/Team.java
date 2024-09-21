public class Team
{
    private String teamName;
    private int matchesPlayed;
    private int wins;
    private int losses;
    private int draws;
    private int goalsScored;
    private int goalsConceded;
    private int goalDifference;
    private int points;

    public Team(String teamName)
    {
        this.teamName = teamName;
        this.matchesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.goalsScored = 0;
        this.goalsConceded = 0;
        this.goalDifference = 0;
        this.points = 0;
    }

    public String getTeamName()
    {
        return this.teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public int getMatchesPlayed()
    {
        return this.matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed)
    {
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins()
    {
        return this.wins;
    }

    public void setWins(int wins)
    {
        this.wins = wins;
    }

    public int getLosses()
    {
        return this.losses;
    }

    public void setLosses(int losses)
    {
        this.losses = losses;
    }

    public int getDraws()
    {
        return this.draws;
    }

    public void setDraws(int draws)
    {
        this.draws = draws;
    }

    public int getGoalsScored()
    {
        return this.goalsScored;
    }

    public void setGoalsScored(int goalsScored)
    {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded()
    {
        return this.goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded)
    {
        this.goalsConceded = goalsConceded;
    }

    public int getGoalDifference()
    {
        return this.goalDifference;
    }

    public void setGoalDifference(int goalDifference)
    {
        this.goalDifference = goalDifference;
    }

    public int getPoints()
    {
        return this.points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public Fixture[] getTeamFixtures(Fixture[] fixtureList)
    {
        Fixture[] fixtures = new Fixture[19];
        for (int i = 0; i < fixtures.length; i++)
        {
            if (fixtureList[i].getTeamOne().equals(teamName) || fixtureList[i].getTeamTwo().equals(teamName))
            {
                fixtures[i] = fixtureList[i];
            }
        }
        return fixtures;
    }

}
