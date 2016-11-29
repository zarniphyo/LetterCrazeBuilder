package model;

public class PuzzleBuilder extends LevelBuilder{

	public PuzzleBuilder(BoardBuilder bb, ScoreBoardBuilder sbb) {
		super(bb, sbb);
	}

	@Override
	public Puzzle build() {
		Puzzle level = new Puzzle(bb.build(), sbb.build());
		return level;
	}

}
