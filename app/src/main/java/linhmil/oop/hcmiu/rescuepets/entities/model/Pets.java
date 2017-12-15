package linhmil.oop.hcmiu.rescuepets.entities.model;

public class Pets implements Pet {

    private int id;
    private int pic;
    private static int score = 0;

    public Pets(int id) {
        super();
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public void assign(Pets p) {
        id = p.getId();
        pic = p.getPic();
    }


    @Override

    public int checkMatch(int id2) {

        if (this.id == id2)
            return 1;
        else return -1;
    }

    @Override
    public int explode(int id2, int id3) {
        if (this.checkMatch(id2) == 1 && this.checkMatch(id3) == 1) {
            score += 1;
            return 1;
        }
        return -1;
    }

    public int crush(int id) {
        this.id = 100;
        return this.id;
    }


}

/*
package linhmil.oop.hcmiu.rescuepets.entities.model;

public class Pets {
	private int id;
	private String name;


	public Pets(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Pets() {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPic() {
		return pic;
	}

	public void setPic(int pic) {
		this.pic = pic;
	}

	public void assign(Pets p) {
		id=p.getId();
		pic=p.getPic();
		name=p.getName();
	}
}
*/

