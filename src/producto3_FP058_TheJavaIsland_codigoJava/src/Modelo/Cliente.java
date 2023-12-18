package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "Id_cliente")
    //Atributos
    private int id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Domicilio")
    private String Domicilio;
    @Column(name = "NIF")
    private String Nif;
    @Column(name = "Email")
    private String Email;

    //Contructor
    public Cliente(String n, String d, String nif, String m) {
        this.Nombre = n;
        this.Domicilio = d;
        this.Nif = nif;
        this.Email = m;
    }
    public Cliente(){}
    //Setters y getters
    public String getNombre() {return Nombre;}

    public String getDomicilio() {return Domicilio;}

    public String getNif() {return Nif;}

    public String getEmail() {return Email;}

    public void setNombre(String c) {this.Nombre = c;}

    public void setDomicilio(String c) {this.Domicilio = c;}

    public void setNif(String c) {this.Nif = c;}

    public void setEmail(String c) {this.Email = c;}

}
