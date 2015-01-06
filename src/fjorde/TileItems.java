package fjorde;

import fjorde.items.Mountain;
import fjorde.items.Plain;
import fjorde.items.Sea;

import java.util.Random;

public final class TileItems {
    private TileItems() {}

    public static Sea createSea() {
        return new Sea();
    }

    public static Plain createPlain() {
        return new Plain();
    }

    public static Mountain createMountain() {
        return new Mountain();
    }

    public static TileItem create(int n) {
        switch (n) {
            case 1: return createSea();
            case 2: return createPlain();
            case 3: return createMountain();

            default:
                throw new IllegalArgumentException(String.format(
                    "%d is an invalid TileItem identifier",
                        n));
        }
    }

    public static TileItem sample(Random random) {
        return create(random.nextInt(3));
    }
}
