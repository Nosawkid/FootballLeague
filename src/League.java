
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

    private void rotateArray(String[] arr)
    {
        String lastElement = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 1; i--)
        {
            arr[i] = arr[i - 1];
        }
        arr[1] = lastElement;
    }

    public void generateFixture(Team[] teams)
    {
        int totalMatches = (teams.length * (teams.length - 1)) / 2;
        Fixture[] fixtures = new Fixture[totalMatches];
        String[] allTeamNames = getAllTeamNames(teams);

        int fixtureCount = 0;
        int n = teams.length;
        int numRounds = n - 1;

        for (int round = 0; round < numRounds; round++)
        {
            for (int i = 0; i < n / 2; i++)
            {
                int j = n - 1 - i;
                fixtures[fixtureCount++] = new Fixture(allTeamNames[i], allTeamNames[j]);
            }
            rotateArray(allTeamNames);
        }
        this.fixtureList = fixtures;

    }

    public void printAllFixtures()
    {
        int gameWeek = 1;
        for (int i = 0; i < fixtureList.length; i++)
        {
            if (i % 19 == 0)
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