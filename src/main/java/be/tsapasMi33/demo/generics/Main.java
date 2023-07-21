package be.tsapasMi33.demo.generics;

public class Main {
    public static void main(String[] args) {
        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(phillies1,3,astros1,5);

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoreResult(phillies2,3,astros2,5);

        Team<BaseballPlayer> phillies = new Team<>("Philadelphia Phillies");
        Team<BaseballPlayer> astros = new Team<>("Houston Astros");
        scoreResult(phillies,3,astros,5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        var guthrie = new BaseballPlayer("D Guthrie", "Center fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.addTeamMember(guthrie);
        phillies.listTeamMembers();

        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
        Team<FootballPlayer> afc = new Team<>("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

//        Team<String> adelaide = new Team<>("Adelaide Storm");
//        adelaide.addTeamMember("N Roberts");
//        adelaide.listTeamMembers();
//
//        var canberra = new Team<String>("Canberra Heat");
//        canberra.addTeamMember("B Black");
//        canberra.listTeamMembers();
//        scoreResult(canberra,0 , adelaide, 1);
    }

    public static void scoreResult(BaseballTeam team1, int t1Score, BaseballTeam team2, int t2Score){
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score,t1Score);
        System.out.printf("%s %s %s %n",team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1Score, SportsTeam team2, int t2Score){
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score,t1Score);
        System.out.printf("%s %s %s %n",team1, message, team2);
    }

    public static void scoreResult(Team team1, int t1Score, Team team2, int t2Score){
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score,t1Score);
        System.out.printf("%s %s %s %n",team1, message, team2);
    }
}
