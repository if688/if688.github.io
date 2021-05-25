package br.ufpe.cin.if688.concepts;

public class DoubleDispatch {

    public static void main(String[] args) {
        NaveEspacial naveGenerica = new NaveEspacial();
        //Discovery discovery = new Discovery();
        //Enterprise enterprise = new Enterprise();
        NaveEspacial discovery = new Discovery();
        NaveEspacial enterprise = new Enterprise();
        Asteroide asteroide = new Asteroide();
        Asteroide asteroideMaluco = new Palas();

        naveGenerica.getType();
        discovery.getType();
        enterprise.getType();

//        asteroide.colidirCom(naveGenerica);
//        asteroide.colidirCom(enterprise);
//        asteroide.colidirCom(discovery);

        asteroideMaluco.colidirCom(naveGenerica);
        asteroideMaluco.colidirCom(enterprise);
        asteroideMaluco.colidirCom(discovery);
    }
}

class NaveEspacial {
    public void getType() {
        System.out.println("Sou uma nave genérica");
    }
}
class Enterprise extends NaveEspacial {
    @Override
    public void getType() {
        System.out.println("Sou a Enterprise");
    }
}
class Discovery extends NaveEspacial {
    @Override
    public void getType() {
        System.out.println("Sou a Discovery");
    }
}
class Asteroide {
    public void colidirCom(NaveEspacial nave) {
        System.out.println("Colidiu com nave especial genérica");
    }
    public void colidirCom(Enterprise nave) {
        System.out.println("Colidiu com Enterprise");
    }
    public void colidirCom(Discovery nave) {
        System.out.println("Colidiu com Discovery");
    }
}
class Palas extends Asteroide {
    public void colidirCom(NaveEspacial nave) {
        System.out.println("Asteróide maluco colidiu com nave especial genérica");
    }
    public void colidirCom(Enterprise nave) {
        System.out.println("Asteróide maluco colidiu com Enterprise");
    }
    public void colidirCom(Discovery nave) {
        System.out.println("Asteróide maluco colidiu com Discovery");
    }
}
