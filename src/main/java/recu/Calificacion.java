package recu;

import java.util.regex.*;

public class Calificacion {

    private Double teorico;
    private Double practico;

    public Calificacion(Double teórico, Double práctico) {
        this.teorico = teórico;
        this.practico = práctico;
    }

    public Calificacion() {
    }

    public Double getTeorico() {
        return teorico;
    }

    /**
     * Aplica las condiciones para introducir una nota para el teórico. Las
     * condiciones de las notas es que sean entre 0 y 10, luego el pratrón
     * asegura que la calificación del teórico sea adecuada para el tipo de dato
     * double
     *
     * @param teorico el valor de la nota para el teórico
     */
    public void setTeorico(Double teorico) {
        if (teorico <= 10.00 && teorico >= 0.00) {
            String teoricoString = String.valueOf(teorico);
            Pattern p = Pattern.compile("^([0-9]{1,2})\\.([0-9]{1,2})$");
            Matcher m = p.matcher(teoricoString);
            teorico = Double.valueOf(teoricoString);
            if (m.matches()) {
                this.teorico = teorico;
            }
        } else {
            this.teorico = null;
        }

    }

    public Double getPractico() {
        return practico;
    }

    /**
     * Aplica las condiciones para introducir una nota para el practico. Las
     * condiciones de las notas es que sean entre 0 y 10 , luego el pratron
     * asegura que la calificación del práctico sea adecuada para el tipo de
     * dato double
     *
     * @param practico el valor de la nota para el práctico
     */
    public void setPractico(Double practico) {
        if (practico <= 10.00 && practico >= 0.00) {
            String practicoString = String.valueOf(practico);
            Pattern p = Pattern.compile("^([0-9]{1,2})\\.+([0-9]{1,2})$");
            Matcher m = p.matcher(practicoString);
            practico = Double.valueOf(practicoString);
            if (m.matches()) {
                this.practico = practico;
            }
        } else {
            this.practico = null;
        }

    }

    /**
     * Método para imprimir resultados
     *
     * @return nota del teórico, práctico y la nota media.
     */
    @Override
    public String toString() {
        return "Calificacion{" + "teórico= " + teorico + ", práctico= " + practico
                + ", nota media= " + calcularMedia() + '}';
    }

    /**
     * Para calcular la media simplemente se suma las dos notas y se dividen
     * entren dos.
     *
     * @return el valor de la media de las dos notas
     */
    public Double calcularMedia() {
        return (teorico + practico) / 2;
    }

}
