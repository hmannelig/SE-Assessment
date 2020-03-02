

public class Course {

	private String name;
	private Teacher assignedTeacher;
	private ListOfRequirements requirements;
	private boolean approved;

	public Course(String name) {
		this.name = name;
		assignedTeacher = null;
		requirements = null;
	}

	public String getCourseInfo() {

		String info = "- Course: " + name + "\n";

		if (assignedTeacher == null) {
			info = info + "- Teacher: Not assigned" + "\n";
		} else {
			info = info + "- Teacher: " + assignedTeacher.getName() + "\n";
		}

		if (approved == true) { //corrected from = to ==
			info = info + "- Approved for teaching: Yes" + "\n";
		} else {
			info = info + "- Approved for teaching: No" + "\n";
		}
		return info;
	}

	public String getCourseName() {
		return name;
	}

	public void update(String name, Integer timeExp, String availability) { // updates name, experience, and
																			// availability
		if (name == null) {
			// no update of the name
		} else {
			this.name = name;
		}

		if ((timeExp == null) && (availability == null)) {
			// only Course-Name gets updated, no changes to the ListOfRequirements
		} else {
			if (this.requirements == null) {
				this.requirements = new ListOfRequirements(this, timeExp, availability);
			} else {
				if (timeExp == null) {
					this.requirements.update(availability);
				} else if (availability == null) {
					this.requirements.update(timeExp);
				} else {
					this.requirements.update(timeExp, availability);
				}
			}
		}
	}

	public void assingTeacher(Teacher t) {
		assignedTeacher = t;
	}

	public void approve() {
		this.approved = true;
	}

	public void reject() {
		this.approved = false;
	}

	public Teacher getTeacher() { // enables method to return null value
//		if (this.assignedTeacher == null) {
//			Teacher t = null;
//			return t;
//		} else {
//			return assignedTeacher;
//		}
		// shortened code to following line> runs condition: if yes=null if no=this.assignedTeacher  // Ternary operation
		return this.assignedTeacher == null ? null : this.assignedTeacher;
	}

	public String readList() { // gives back String
		String info = "";
		if (this.requirements == null) {
			info = "- No Course-Requirements are currently associated with this course" + "\n";
		} else {
			info = "- The Course-Requirements are: " + this.requirements.getTimeExp()
					+ " years of experience and it will be available in the " + this.requirements.getAvailability()
					+ "\n";
		}
		return info;
	}

	public void assignRequirementsList(ListOfRequirements LoR) {
		this.requirements = LoR;
		LoR.setCorrespondingCourse(this);

	}

}

