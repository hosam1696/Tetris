package shape;

import java.util.ArrayList;
import field.Position;

public abstract class ReversedShape extends AbstractShape {
	public ReversedShape(Position pos) {
		super(pos);
	}

	public ArrayList<Position> preRotate() {
		ArrayList<Position> res = new ArrayList<Position>();
		for (int i = 0; i < 4; i++) {
			res.add(new Position(offSets[i].getY() - 2, -offSets[i].getX() + 2).add(pos));
		}
		return res;
	}

	public void Rotate() {
		blocks.forEach(block -> {
			offSets[blocks.indexOf(block)] = block.getPosition().sub(pos);
		});
		for (int i = 0; i < 4; i++) {
			offSets[i] = new Position(offSets[i].getY() - 2, -offSets[i].getX() + 2);
		}
		blocks.forEach(b -> {
			b.setPosition(offSets[blocks.indexOf(b)].add(pos));
		});
	}
}
