package fjorde;

public class Tile
{
	private TileItem[] items;
	private boolean jail;
	private boolean pawn;

	public Tile(TileItem[] items) {
		this.items = items;
	}

	public Tile() {
		this(TileItems.samples(6));
	}

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