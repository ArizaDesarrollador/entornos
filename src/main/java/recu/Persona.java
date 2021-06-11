package recu;

/**
 *
 * @author Jesús Ariza.
 */
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {

    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected Date fechaNacimiento;
    protected String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    /**
     * He cambiado el patrón para introducir opcionalmente el prefijo
     * telefónico. El patrón controla que el prefijo solo lleve un simbolo +
     * acompañado de los tres posibles longitudes de prefijos telefónicos, y
     * todo esto es opcional
     *
     * @param telefono es el String que le entra para validar el teléfono con el
     * patrón
     */
    public void setTelefono(String telefono) {
        Pattern pattern = Pattern.compile("^((\\+{1})([0-9]{1,3}))?([0-9]{9})$");
        Matcher matcher = pattern.matcher(telefono);
        if (matcher.matches()) {
            this.telefono = telefono;
        }
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    /**
     * He cambiado el patrón para que sea más acertado el correo electrónico.
     * Primeramente se aplica el inicio y el final con los simbolos ^ y $, luego
     * comienza con caracteres,números,puntos,guiones o barra baja, luego
     * continua con un arroba, seguido de caracteres, un punto y caracteres de
     * nuevo, esto evita que haya mas de un punto en el dominio.
     *
     * @param email es el String que le entra para validar el correo con el
     * patrón
     */
    public void setEmail(String email) {
        //Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
        Pattern pattern = Pattern.compile("^\\S+([a-z0-9\\._-]+)@([a-z]+)(\\.{1})([a-z]+)$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + '}';
    }

    public Integer calcularEdad() {
        Date hoy = new Date();
        long diffInMillies = Math.abs(hoy.getTime() - fechaNacimiento.getTime());
        long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS) / (365 * 24 + 6);
        return Math.round(diff);
    }

}
