package mypackage;

public abstract class Cat {
    private String name;
    private String breed;

    public String getName() {
        return name;
    }

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public void CatsInformation() {
        System.out.println(
                        "Cat name : " + this.name + "\n" +
                        "Cat breed : " + this.breed
        );
    }

}