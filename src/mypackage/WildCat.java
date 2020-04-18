package mypackage;

public class WildCat extends Cat implements Playable {
    private String food;

    public WildCat(String name, String breed, String food) {
        super(name, breed);
        this.food = food;
    }

    public void HatePeople(String nameCat) {
        System.out.println(nameCat + " hates people because they mock cats");
        System.out.println(nameCat + " said : \"It's great to hate people :)\"");
    }

    public void SaveWorld(String nameCat) {
        System.out.println(nameCat + " is a superman that saves the world from unnecessary " + this.food);
    }

    @Override
    public void play(String nameCat) {
        System.out.println("He also like playing with his tail");
    }

    @Override
    public void CatsInformation() {
        System.out.println("Information about Wildcat : ");
        super.CatsInformation();
        System.out.println("Cat's food : " + this.food);
    }
}
