package fjorde;

public class Tile {
	private TileItem[] items;

	public Tile(TileItem[] items) {
		this.items = items;
	}

	public Tile() {
		this(TileItems.samples(6));
	}

	public TileItem getItem(int i) {
		return items[i];
	}

	public TileItem getItem(Cardinal c) {
		int i = c.ordinal();

		// ignore EAST and WEST
		if (i < 2) {
			return getItem(i);
		} else if (i < 6) {
			return getItem(i - 1);
		} else {
			return getItem(i - 2);
		}
	}
}
