package fjorde;

public class Tile
{
	private TileItem tileItem[];
	private boolean jail;
	private boolean pawn; 


	public Tile (){
		tileItem = new TileItem[6];
		int nbItem;
		for(int cpt=0;cpt<6;cpt++){
			nbItem= (int)(Math.random()*3);

			switch (nbItem)
			{
				case 0: tileItem[cpt]= "sea"; break;
				case 1: tileItem[cpt]= "plain"; break;
				case 2: tileItem[cpt]= "montain"; break;
			}
		}
		jail=false;
		pawn=false;
	}

	/*public Tile[] neighbours(){
		
	}*/

	/*public void addTile(Tile tile, int c1,int c2,int c3){

	}*/

	public void setJail(){
		if (pawn==false){
			jail = true;
		}
		else {
			System.out.println("Deja un item !");
		}
	}

	public void setPawn(){
		if(jail == false){
			pawn = true;
		}
		else {
			System.out.println("Deja un item !");
		}
	}

	public boolean getJail(){
		return jail;
	}

	public boolean getPawn(){
		return pawn;
	}	
}