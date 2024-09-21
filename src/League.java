
public class League
{

    private Fixture[] fixtureList;

    public Fixture[] getFixtureList()
    {
        return this.fixtureList;
    }

    public void setFixtureList(Fixture[] fixtureList)
    {
        this.fixtureList = fixtureList;
    }

    public String[] getAllTeamNames(Team[] teams)
    {
        String[] teamNames = new String[teams.length];
        for (int i = 0; i < teams.length; i++)
        {
            teamNames[i] = teams[i].getTeamName();
        }
        return teamNames;
    }

    public String[] getRestTeams(Team[] teams)
    {
        String[] resArray = new String[teams.length - 1];
        int ogIndex = 1;
        for (int i = 0; i < resArray.length; i++)
        {
            resArray[i] = teams[ogIndex].getTeamName();
            ogIndex++;
        }
        return resArray;
    }

    public String[] rotateArray(String[] resTeams)
    {
        String[] resArray = new String[resTeams.length];
        resArray[0] = resTeams[resTeams.length - 1]; // Move last element to first
        for (int i = 1; i < resTeams.length; i++)
        {
            resArray[i] = resTeams[i - 1]; // Shift the rest to the right
        }
        return resArray;
    }

    public void generateFixture(Team[] teams)
    {
        int totalMatches = (teams.length * (teams.length - 1)) / 2;
        Fixture[] fixtures = new Fixture[totalMatches];
        String[] allTeamNames = getAllTeamNames(teams);
        String anchorTeam = allTeamNames[0];
        String[] restTeams = getRestTeams(teams);

        int counter = 0;
        for (int i = 0; i < teams.length - 1; i++)
        {
            fixtures[counter++] = new Fixture(anchorTeam, restTeams[0]);

            for (int j = 1; j < restTeams.length; j += 2)
            {
                if (j + 1 < restTeams.length)
                {
                    fixtures[counter++] = new Fixture(restTeams[j], restTeams[j + 1]);
                }
            }
            restTeams = rotateArray(restTeams);
        }
        this.fixtureList = fixtures;
    }

    public void printAllFixtures()
    {
        int gameWeek = 1;
        for (int i = 0; i < fixtureList.length; i++)
        {
            if (i % 10 == 0)
            {
                System.out.println(" ");
                System.out.println("ROund: " + gameWeek);
                System.out.println(" ");
                gameWeek++;
            }
            System.out.println((i + 1) + " " + fixtureList[i].getTeamOne() + " V/S " + fixtureList[i].getTeamTwo());
            System.out.println("");
        }
    }
}