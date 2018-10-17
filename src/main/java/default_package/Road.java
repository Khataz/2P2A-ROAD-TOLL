package default_package;

import java.util.TreeMap;

public class Road {

    private TreeMap<Position, Sign> treeSigns;

    public Road() {
        treeSigns = new TreeMap<Position, Sign>();
    }

    public TreeMap<Position, Sign> getTreeSigns() {
        return treeSigns;
    }

    public void fillTreeSigns() {
        Sign s1 = new Sign(new Position(200),25);
        treeSigns.put(s1.getPosition(), s1);

    }

    public Sign getSignAt(Position pos) {
        return getTreeSigns().get(pos);
    }

}
