class Fixture
{
    private String teamOne;
    private String teamTwo;

    public String getTeamOne()
    {
        return this.teamOne;
    }

    public void setTeamOne(String teamOne)
    {
        this.teamOne = teamOne;
    }

    public String getTeamTwo()
    {
        return this.teamTwo;
    }

    public void setTeamTwo(String teamTwo)
    {
        this.teamTwo = teamTwo;
    }

    public Fixture(String teamOne, String teamTwo)
    {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public void printTeams()
    {
        System.out.println("Team 1: " + this.teamOne);
        System.out.println("Team 2: " + this.teamTwo);
    }
}
