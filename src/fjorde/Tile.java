package fjorde;

public class Tile {
	private TileItem[] items;

	public Tile(TileItem[] items) {
		this.items = items;
	}

	public Tile() {
		this(TileItems.samples(6));
	}
}
