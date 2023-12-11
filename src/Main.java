import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Main programa = new Main();
programa.IniciarPartida();
    }


    public  void IniciarPartida(){
        Singletone juego = Singletone.getInstance();

        juego.setRondaPartida(10); // Número de rondas
        juego.setIntentosMax(2); // Número de intentos por ronda
        juego.setRondaActual(0); // Reiniciar ronda actual
        juego.setPuntuacion(0); // Reiniciar puntuación

        JOptionPane.showMessageDialog(null, "Comezamos a partida");
        juego.setNombre(JOptionPane.showInputDialog("Coloca o teu nome"));

        for (int ronda = 1; ronda <= juego.getRondaPartida(); ronda++) {
            juego.setRondaActual(ronda);
            JOptionPane.showMessageDialog(null, "Ronda " + ronda + ": " + juego.getNombre() + ", intento 1");
            juego.setNumeroAleatorio((int) (Math.random() * 10) + 1);

            if (realizarIntento()) {
                juego.setPuntuacion(juego.getPuntuacion() + 1);
            } else {
                JOptionPane.showMessageDialog(null, "El número era: " + juego.getNumeroAleatorio());
            }
        }

        mostrarResultado();
    }


        private boolean realizarIntento() {
            Singletone juego = Singletone.getInstance();
            for (int intento = 1; intento <= juego.getIntentosMax(); intento++) {
                juego.setIntentos(intento);
                juego.setRespuesta(Integer.parseInt(JOptionPane.showInputDialog("Intento " + intento + ": Ingrese un número (1-10)")));
                if (juego.getRespuesta() == juego.getNumeroAleatorio()) {
                    JOptionPane.showMessageDialog(null, "¡Adivinaste!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Intento fallido. El número es " + (juego.getRespuesta() > juego.getNumeroAleatorio() ? "menor" : "mayor"));
                }
            }
            return false;
        }

        private void mostrarResultado() {
            Singletone juego = Singletone.getInstance();
            JOptionPane.showMessageDialog(null, "Fin del juego\nNombre: " + juego.getNombre() + "\nPuntuación: " + juego.getPuntuacion());
        }
    }
