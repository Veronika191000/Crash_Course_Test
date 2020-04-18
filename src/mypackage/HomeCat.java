package mypackage;

public class HomeCat extends Cat implements Playable {

    private int money = 2000;
    private String ownerName;
    private int ownerMood = 100;

    public HomeCat(String name, String breed, String ownerName) {
        super(name, breed);
        this.ownerName = ownerName;
    }

    public void LayOnSofa(String nameCat) {
        ownerMood -= 50;
        if (ownerMood < 50) {
            System.out.println(nameCat + " continues to lie on the sofa" + "\n" +
                    "Bad " + nameCat + ", go catch a mouse");
        } else {
            System.out.println(nameCat + " lies on the sofa for an hour" + "\n" +
                    "Nice " + nameCat + ", let's lie together");
        }
    }

    public void SpoilsShoes(String nameCat) {
        money -= 1000;
        if (money < 1000) {
            System.out.println("The cat decided to ruin my shoes again in the morning" +"\n" +
                    "Bad " + nameCat + " , you are without dinner today!");
        } else {
            System.out.println("The cat decided to ruin my shoes in the evening" +"\n" +
                    nameCat + ", I forgive you for the first time");
        }
    }

    @Override
    public void play(String nameCat) {
        System.out.println(nameCat + " is tired of lying and decided to play with his favorite toy");
        ownerMood += 50;
    }

    @Override
    public void CatsInformation() {
        System.out.println("Information about Housecat : ");
        super.CatsInformation();
        System.out.println(
                "Owner name : " + ownerName);
    }
}
