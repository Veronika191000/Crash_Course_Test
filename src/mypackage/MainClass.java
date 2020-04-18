package mypackage;


public class MainClass {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------------------");
        HomeCat firstHomeCat = new HomeCat("Barsik","Beerman", "Natali");
        firstHomeCat.CatsInformation();
        firstHomeCat.LayOnSofa(firstHomeCat.getName());
        firstHomeCat.LayOnSofa(firstHomeCat.getName());
        firstHomeCat.play(firstHomeCat.getName());
        firstHomeCat.SpoilsShoes(firstHomeCat.getName());
        firstHomeCat.SpoilsShoes(firstHomeCat.getName());
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("--------------------------------------------------------------------------------");
        HomeCat secondHomeCat = new HomeCat("Masyanya","Burmese", "Vera");
        secondHomeCat.CatsInformation();
        secondHomeCat.LayOnSofa(secondHomeCat.getName());
        secondHomeCat.play(secondHomeCat.getName());
        secondHomeCat.SpoilsShoes(secondHomeCat.getName());
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("--------------------------------------------------------------------------------");
        WildCat firstWildCat = new WildCat("Tiger", "Prionailurus Bengalensis", "sandwich");
        firstWildCat.CatsInformation();
        firstWildCat.HatePeople(firstWildCat.getName());
        firstWildCat.SaveWorld(firstWildCat.getName());
        firstWildCat.play(firstWildCat.getName());
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("--------------------------------------------------------------------------------");
        WildCat secondWildCat = new WildCat("Naphanya", "Felis Nigripes", "cucumbers");
        secondWildCat.CatsInformation();
        secondWildCat.HatePeople(secondWildCat.getName());
        secondWildCat.SaveWorld(secondWildCat.getName());
        secondWildCat.play(secondWildCat.getName());
        System.out.println("--------------------------------------------------------------------------------");

    }


}
