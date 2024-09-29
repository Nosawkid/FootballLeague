class Fixture
{
    private Team teamOne;
    private Team teamTwo;

    public Fixture(Team teamOne, Team teamTwo)
    {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public Team getTeamOne()
    {
        return this.teamOne;
    }

    public void setTeamOne(Team teamOne)
    {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo()
    {
        return this.teamTwo;
    }

    public void setTeamTwo(Team teamTwo)
    {
        this.teamTwo = teamTwo;
    }

    public void printFixture()
    {
        System.out.println(teamOne.getTeamName() + " V/S " + teamTwo.getTeamName());
    }

}
