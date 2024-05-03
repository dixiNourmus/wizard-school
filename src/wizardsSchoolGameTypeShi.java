import java.util.*;



public class wizardsSchoolGameTypeShi {
    public static void main(String[] args) {
//making the list
        ArrayList<String> myList = new ArrayList<>();



        //add teams
        myList.add("Dwarves");
        myList.add("Wizards");
        myList.add("Dinosaurs");
        myList.add("etc");
        myList.add("falmouth falcon");
        myList.add("wimbourne wasps");
        myList.add("celtics");
        myList.add("ballycastle bats");
        myList.add("lebron");
        //shuffle
        Collections.shuffle(myList);

//displaying the list of teams
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + 1 + ". ");
            System.out.println(myList.get(i));
        }
        //display first round
        safeinput.prettyHeader("First round");
        System.out.println();
        playgame(0,7,myList);
        playgame(1,6,myList);
        playgame(2,5,myList);
        playgame(3,4,myList);
        //display second round
        safeinput.prettyHeader("SECOND ROUND");
        System.out.println();
        playgame(0,3,myList);
        playgame(1,2,myList);
        //display championship
        safeinput.prettyHeader("Championship");
        System.out.println();
        playgame(0,1,myList);

//declaring who wins
        System.out.println("the "+myList.get(0)+ " are the champions");




    }
    //start of game code
    public static  void playgame(int teamA, int teamB, ArrayList<String> teams){



        Random rnd = new Random();



        int teamAScore = 0;
        int teamBScore = 0;
        int teamBtotal = 0;
        int teamAtotal = 0;
        int snitch ;

// quarters and snitch
        safeinput.prettyHeader(teams.get(teamA) + " vs " +teams.get(teamB));
        for (int i = 1; i < 5; i++) {
            System.out.println();
            snitch = rnd.nextInt(100);
            if(snitch <6){
                System.out.println("game is over team "+teams.get(teamA) + " wins by golden snitch");
                teams.remove(teamB);
                return;
            }else if (snitch > 94){

                System.out.println("game is over team "+teams.get(teamB) + " wins by golden snitch");
                teams.remove(teamA);
                return;

            }
//scoring
            teamAScore = rnd.nextInt(5)*10;
            teamBScore = rnd.nextInt(5)*10;
            System.out.printf("\t QTR" + i +": "+teamAScore +" "+teamBScore);

            System.out.println();
            teamAtotal = teamAtotal+teamAScore;
            teamBtotal = teamBtotal+teamBScore;



        }

//who's winning
        if (teamAtotal > teamBtotal){
            teams.remove(teamB);
            System.out.println("the "+teams.get(teamA)+ " defeats the "+teams.get(teamB));
            System.out.println("Final score "+teamAtotal +"-"+ teamBtotal);
        }
        else if (teamBtotal > teamAtotal){
            teams.remove(teamA);
            System.out.println("the "+teams.get(teamB)+ " defeats the "+teams.get(teamA));
            System.out.println("Final score "+teamBtotal +"-"+ teamAtotal);
        }
        //overtime
        else{
            System.out.println("GOING INTO OT !!!!");
            do{
                int OTscorea = rnd.nextInt(10);
                int OTscoreb = rnd.nextInt(10);
                teamAtotal = teamAScore + OTscorea;
                teamBtotal = teamBScore + OTscoreb;
//overtime win
                if (teamAtotal > teamBtotal){
                    teams.remove(teamB);
                    System.out.println("Final score "+teamAtotal +"-"+ teamBtotal);
                    break;
                }
                else if (teamBtotal > teamAtotal){
                    teams.remove(teamA);
                    System.out.println("Final score "+teamBtotal +"-"+ teamAtotal);
                    break;
                }
            }while(true);


        }



    }

}
