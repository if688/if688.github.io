package br.ufpe.cin.if688.doubledispatch;

public class Teste {

	public static void main(String[] args) {
		Spaceship ship = new Spaceship();
		//Spaceship falcon = new MilleniumFalcon();
		MilleniumFalcon falcon = new MilleniumFalcon();
		ship.getType();
		falcon.getType();
		Asteroid asteroid = new Asteroid();
		//Asteroid explodingAsteroid = new ExplodingAsteroid();
		ExplodingAsteroid explodingAsteroid = new ExplodingAsteroid();
		asteroid.collideWith(ship);
		asteroid.collideWith(falcon);
		explodingAsteroid.collideWith(ship);
		explodingAsteroid.collideWith(falcon);
	}
	public void maisUmMetodo(Spaceship ship) {
		if (ship instanceof MilleniumFalcon) {
			MilleniumFalcon mf = (MilleniumFalcon) ship;
			mf.outroMetodo();
		}
	}
}
class Spaceship {
	public void getType() {
		System.out.println("Sou uma nave genérica"); 
	}
}
class MilleniumFalcon extends Spaceship {
	public void getType() {
		System.out.println("Sou A Millenium Falcon"); 
	}
	public void outroMetodo() {
		System.out.println("nada de interessante");
	}
}
class Asteroid {
	public void collideWith(Spaceship ship) {
		System.out.println("Asteroid bateu em Nave Genérica");
	}
	public void collideWith(MilleniumFalcon ship) {
		System.out.println("Asteroid bateu na Millenium Falcon");
	}
}
class ExplodingAsteroid extends Asteroid {
	public void collideWith(Spaceship ship) {
		System.out.println("ExplodingAsteroid bateu em Nave Genérica");
	}
	public void collideWith(MilleniumFalcon ship) {
		System.out.println("ExplodingAsteroid bateu na Millenium Falcon");
	}
}






