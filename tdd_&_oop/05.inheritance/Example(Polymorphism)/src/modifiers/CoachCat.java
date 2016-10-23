package modifiers;

class CoachCat extends Cat {
	private String independance = "low";

	public CoachCat() {
		super();
	}

	@Override
	public String toString() {
		return "While car have independance=" + super.getIndependance() + "coachCat has independance " + independance
				+ "]";
	}
}