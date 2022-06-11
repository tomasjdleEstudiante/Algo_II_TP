package competitor;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class demo {

	public static void main(String[] args) {
//Alignment alignment, String realName, String fictionalName, int speed, int strength, int stamina, int dexterity
		Competitor batman = new Player(Alignment.HERO, "Bruce Wayne", "Batman", 		200, 	300,	250, 450);
		Competitor flash = new Player(Alignment.HERO, "Wally West", "Flash Kid", 		1200, 	190, 	600, 380);
		Competitor robin = new Player(Alignment.HERO, "Demian Wayne", "Robin", 			230, 	200, 	230, 500);
		Competitor nightwing = new Player(Alignment.HERO, "Dick Grayson", "NightWing", 	200, 	330, 	255, 410);
		Competitor barry = new Player(Alignment.HERO, "Barry Allen", "The Flash", 	1200, 	190, 	660, 410);
		
		Competitor joker = new Player(Alignment.VILLAIN, "Unknown", "Joker", 			180, 	276, 	253, 400);
		Competitor riddler = new Player(Alignment.VILLAIN, "Eduard Nigma", "Riddler", 	120, 	276,	1200, 200);
		Competitor bane = new Player(Alignment.VILLAIN, "Antonio Diego", "Bane", 		170, 	276, 	330, 210);
		Competitor magneto = new Player(Alignment.VILLAIN, "Max Eisenhardt", "Magneto", 500, 	276, 	200, 500);
		
		League batfamily = new League("Bat-Family");
		League gotham = new League("GothamBads");
		League speedsters = new League("Speedsters");
		
		batfamily.addCompetitor(batman);
		batfamily.addCompetitor(flash);
		batfamily.addCompetitor(robin);
		
		gotham.addCompetitor(nightwing);
		batfamily.addCompetitor(gotham);
		
		batfamily.addCompetitor(barry);
		
		System.out.println(batfamily.getTrait(Trait.SPEED));
		
//		Collections.sort(batfamily.getLeagueList(),new TraitComparator(false));
//		
//		System.out.println(batfamily);

//		List<Competitor> batlist = batfamily.getLeagueList();
//		
//		System.out.println(batlist);
//		
//		Collections.sort(batlist, new TraitComparator());
		

	}

}
