public class Teste {

    public static void main(String[] args) {
        Spaceship generic = new Spaceship();
        generic.getType();
        Spaceship hyperion = new Hyperion();
        hyperion.getType();
        Spaceship milleniumFalcon = new MilleniumFalcon();
        milleniumFalcon.getType();
        if (generic instanceof MilleniumFalcon) {
            MilleniumFalcon mf = (MilleniumFalcon) generic;
            mf.algumOutroMetodo();
        }

        Asteroid asteroid = new ExplodingAsteroid();
        asteroid.collideWith(generic);
        asteroid.collideWith(hyperion);
        asteroid.collideWith(milleniumFalcon);

    }
}

class Spaceship {
    public void getType() {
        System.out.println("Sou uma nave genérica");
    }
}

class Hyperion extends Spaceship {
    public void getType() {
        System.out.println("Sou Hyperion");
    }
    public void outroMetodo() {
        System.out.println("Outra Coisa");
    }
}
class MilleniumFalcon extends Spaceship {
    public void getType() {
        System.out.println("Sou MilleniumFalcon");
    }
    public void algumOutroMetodo() {
        System.out.println("Alguma outra Coisa");
    }
}

class Asteroid {
    public void collideWith(Spaceship ship) {
        System.out.println("Asteroid bateu em uma nave genérica");
    }
    public void collideWith(Hyperion ship) {
        System.out.println("Asteroid bateu em Hyperion");
    }
    public void collideWith(MilleniumFalcon ship) {
        System.out.println("Asteroid bateu em MilleniumFalcon");
    }
}

class ExplodingAsteroid extends Asteroid {
    public void collideWith(Spaceship ship) {
        System.out.println("ExplodingAsteroid bateu em uma nave genérica");
    }
    public void collideWith(Hyperion ship) {
        System.out.println("ExplodingAsteroid bateu em Hyperion");
    }
    public void collideWith(MilleniumFalcon ship) {
        System.out.println("ExplodingAsteroid bateu em MilleniumFalcon");
    }
}