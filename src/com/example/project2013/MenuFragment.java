package com.example.project2013;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuFragment extends Fragment {
	
	private ListView list;
	
	private CharacterListener listener;
	
	Character peter = new Character("Peter","Peter Griffin is a working class Irish American, " +
			"who is an overweight blue collar worker with a prominent Rhode Island and Eastern " +
			"Massachusetts accent. He is the husband of Lois and the father of Meg, Chris and Stewie. " +
			"He is the son of Thelma Griffin and Mickey McFinnigan and is the step-son of Francis Griffin. " +
			"Peter and his family live in the fictional town of Quahog, Rhode Island, " +
			"which is modeled after Providence, Rhode Island. Peter primarily worked as a " +
			"safety inspector at the Happy-Go-Lucky Toy Factory, until his boss Jonathan Weed " +
			"choked to death on a dinner roll; he then became a fisherman on his own boat, known as " +
			"the S.S. More Powerful than Superman, Batman, Spider-Man, and The Incredible Hulk Put Together, " +
			"with the help of two Portuguese immigrants, Santos and Pasqual, until his boat was destroyed. " +
			"He now works in the shipping department of the Pawtucket Patriot brewery. " +
			"Peter is also shown in various jobs for single episodes and cutaway gags. " +
			"In one episode Peter played for the New England Patriots until his behavior " +
			"resulted in him being kicked off the team. In a running gag, storylines are " +
			"randomly interrupted by extremely long, unexpected fights between Peter and " +
			"Ernie the Giant Chicken, an anthropomorphic chicken who serves as a rival to Peter. " +
			"These battles parody the action film genre, with explosions, high-speed chases, " +
			"and immense devastation to the town of Quahog","father");
	Character lois = new Character("Lois","Lois Griffin was born to affluent WASP parents, " +
			"Carter and Barbara Pewterschmidt. It is revealed in the episode Family Goy that her " +
			"mother is actually a Holocaust survivor who concealed her Judaism, retconning her " +
			"apparently Jewish Long Island and New York accent, even though she was raised a Protestant. " +
			"Lois is the wife of Peter Griffin and the mother of Meg, Chris and Stewie Griffin. " +
			"Lois and the rest of the Griffins live in the fictional town of Quahog, " +
			"Rhode Island which is modeled after Cranston, Rhode Island. Lois primarily works " +
			"as a housewife throughout the series, though she did give piano lessons in early episodes " +
			"of the series. Lois has also had various jobs in single episodes such as in FOX-y Lady, " +
			"were she becomes the new reporter for Fox News Channel and in It Takes a Village Idiot, " +
			"and I Married One, Lois is elected the mayor of Quahog." +
			"Family Guy uses a floating timeline in which the characters do not age much, " +
			"so the show is always assumed to be set in the current year. However, " +
			"several of the characters, such as Meg Griffin, have aged two to three years since " +
			"the show's pilot episode, while others, such as Stewie, have remained the same age. " +
			"In several episodes, events have been linked to specific times, although this timeline " +
			"has been contradicted in subsequent episodes.","mother");
	Character chris = new Character("Chris","Chris deals with the problems that most pubescent boys face: " +
			"acne, girls, and school. Chris has been known to feel self-conscious about himself, " +
			"especially his weight. In fact, on the Volume 1 DVD Boxset TV guides special Family Guy edition, " +
			"it stated that Chris wouldn't hurt a fly, unless it landed on his hot dog. " +
			"Due to Chris' weight, he was referred to as an Elephant Child when he was born. " +
			"Chris is also willing to do something as drastic as to convert to Judaism in order " +
			"to do better in school, specifically math. He once believed his low grades in " +
			"mathematics were caused when he tickled his brain by sticking an army man's rifle " +
			"into his nose and (presumably) accidentally puncturing a lobe. " +
			"Chris enjoys drawing and once almost became a famous artist in New York.", "son");
	Character meg = new Character("Meg","Meg is a self-conscious teenage girl. " +
			"Her insecurities cause her desperately to try to be part of the cool crowd, " +
			"but this only results in her getting coldly rebuffed by Connie D'Amico, a popular, " +
			"attractive, and egotistical cheerleader. However, another student named Neil Goldman " +
			"is attracted to her.[2] She is also usually at the bottom of the family's pecking " +
			"order and the butt of Peter's jokes due to her perceived homeliness, " +
			"tendency toward social awkwardness, and unpopularity. Everyone in her family makes " +
			"fun of her: Peter and Chris resort to outrageous stunts and names; Stewie and Brian " +
			"employ subtle but effective jokes; and Lois constantly puts Meg down while boosting " +
			"her own egotistical image. However, on some occasions the family's true love for her " +
			"has been proven. She has been so self-conscious and insecure about herself that she " +
			"has engaged in dangerous sexual behavior just for attention. " +
			"She is also prone to violent releases of her repressed rage, as shown in Road to Rupert, " +
			"when she assaults a man who insulted her after a fender-bender.","daughter");
	Character stewie = new Character("Stewie","Stewie is a one-year-old prodigy who has a very " +
			"sophisticated psyche, is able to speak fluently, and is intended to have a slightly camp " +
			"upper class English accent. He reaches his first birthday in the season 1 episode " +
			"Chitty Chitty Death Bang, and has not been referred to as being more than a year " +
			"old since, despite being seen in several episodes attending Pre-school. " +
			"Highly literate and able to cite pop culture references that long predate his birth, " +
			"Stewie is also entranced by Raffi and the Teletubbies. Stewie succumbs to other " +
			"weaknesses of children his age – he believes Peter has truly disappeared in a game " +
			"of Peekaboo, talks to his teddy bear Rupert as if he were alive, " +
			"is overcome with laughter when Lois blows on his stomach, " +
			"and has no idea how to use a toilet. MacFarlane has stated that Stewie is " +
			"meant to represent the general helplessness of an infant through the eyes of an adult. " +
			"Per cartoon physics, his ability to move objects of greater weight than himself is not " +
			"surprising to other characters, nor is his ability to retrieve firearms from hammerspace, " +
			"neither is his ability to talk. " +
			"Stewie's mastery of physics and mechanical engineering are at a level of science fiction. " +
			"He has constructed advanced fighter-jets, mind control devices, a weather control device, " +
			"a teleportation device, robots, clones, a working Transporter device from Star Trek, " +
			"time machines, a Multiverse Transporter, a shrinking pod, " +
			"as well as an assortment of guns including lasers, rocket launchers, and crossbows. " +
			"Stewie employs these to cope with the stresses of infant life (such as teething pain, " +
			"and eating broccoli)[8] and to murder his mother, Lois, with mixed success at best " +
			"depending on the objective. As made clear in the pilot episode, Stewie's matricidal " +
			"tendencies are a result of Lois constantly (and unwittingly) thwarting his schemes, " +
			"and so he desires to kill her to carry out his plans without her interference. In other, " +
			"recent episodes, Stewie engages in other violent or criminal acts, including robbery, " +
			"aggravated assault, carjacking, loan sharking, forgery, and killing off many minor characters " +
			"(with a tank, guns, and other assorted weaponry). " +
			"Stewie eventually realizes his dreams of matricide and world domination in the sixth " +
			"season two-part episode Stewie Kills Lois and Lois Kills Stewie." +
			" The events are reverted in a deus ex machina ending, " +
			"where most of the story turns out to be a computer simulation. " +
			"Because of the rather disastrous ending for himself in the simulation, " +
			"being shot and killed by Peter, he decides to put aside his plans of matricide " +
			"and world domination for the time being. However, at the end of the season nine premiere, " +
			"And Then There Were Fewer, when Diane Simmons is about to murder Lois for uncovering her " +
			"murderous revenge scheme Stewie kills Diane with a sniper rifle stating: " +
			"If anyone's going to take that bitch [Lois] down, it's going to be me. " +
			"Other instances of family kindness include his support for Meg " +
			"(whom he traditionally calls Megan) as when he chided Brian's coke-induced hostility to her " +
			"(The Thin White Line), retracted his joke, I hate you too when Meg said I hate you all " +
			"to the family (Untitled Griffin Family History), and wiped her tears during a weepy moment. " +
			"While, Stewie generally regards Chris as a stooge, he has encouraged him, " +
			"and even helped Chris to dress when he felt too shy to date (Extra Large Medium). " +
			"In the episode Stewie Loves Lois, it shows Stewie can love his mom, after she recovers Rupert, " +
			"fixes him, and serves a meal he likes. When he becomes too dependent on her, " +
			"she deliberately takes no notice of him; when he hurts himself she tries to show notice " +
			"of him again, but he then goes back to his old ways. " +
			"In the more recent seasons, Stewie has a larger amount of freedom from his parents, " +
			"which extends to the point of him being able to keep pigs from parallel universes or " +
			"take part in the television series Jolly Farm, as compared to the first season, " +
			"in which his plans were constantly hindered by Lois. In The Hand That Rocks the Wheelchair, " +
			"Stewie inadvertently clones an evil twin of himself after trying to increase his evil nature. " +
			"By the end of the episode, it is suggested that the original Stewie may have been " +
			"unknowingly killed by Brian when he cannot tell them apart and Stewie turns to the " +
			"camera with glowing yellow eyes (reminiscent of Michael Jackson's Thriller). " +
			"But so far, the Stewie recently seen in Trading Places, the follow-up episode, " +
			"he still seems to have his mostly harmless eccentricity, shown when he asks Brian " +
			"if he wants to trade places with him for fun. " +
			"Although the instances are very rare, Stewie has had a few interactions with his neighbor Herbert. " +
			"It should be known that Stewie strongly does not like him and even calls him a pervert. " +
			"This leads Herbert to hit on Stewie and it also leads him into thinking that he's feisty.", "son");
	Character brian = new Character("Brian","Brian was a member of the Griffin family. " +
			"He primarily worked in the series as a struggling writer attempting essays, books, novels, " +
			"screenplays and newspaper articles. His appearance was a redesign of the protagonist Steve " +
			"from MacFarlane's previous animated short films, The Life of Larry & Steve. " +
			"He has been featured in much of the Family Guy merchandise, including toys, t-shirts, " +
			"and video games, and has made crossover appearances in the other MacFarlane-produced shows, " +
			"American Dad! and The Cleveland Show.", "pet");
	
	Character characters[] = {peter, lois, chris, meg, stewie, brian};
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_menu, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		list = (ListView)getView().findViewById(R.id.list);
		list.setAdapter(new AdapterCharacters(this));
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
				if (listener!=null) {
					listener.onCharacterSelected((Character)list.getAdapter().getItem(pos));
				}
			}
		});
	}
	
	class AdapterCharacters extends ArrayAdapter<Character> {
    	
    	Activity context;
    	
    	AdapterCharacters(Fragment context) {
    		super(context.getActivity(), R.layout.activity_main_twopane, characters);
    		this.context = context.getActivity();
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.activity_main_twopane, null);
			
			TextView name = (TextView)item.findViewById(R.id.Name);
			name.setText(characters[position].getName());
			
			TextView kindship = (TextView)item.findViewById(R.id.Kindship);
			kindship.setText(characters[position].getKindship());
			
			return(item);
		}
    }
	
	public interface CharacterListener {
		void onCharacterSelected(Character character);
	}
	
	public void setCharacterListener(CharacterListener listener) {
		this.listener=listener;
	}
}
