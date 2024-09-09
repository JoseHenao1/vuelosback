package co.edu.udea.vuelosback.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@NamedQuery(
  name = "User.findByEmail",
  query = "SELECT u FROM User u WHERE u.mail = :email"
)

@Entity
@Table(name = "Users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "userName", nullable = false, length = 100)
  private String userName;

  @Column(name = "ccid", nullable = false, length = 25)
  private String ccid;

  @Column(name = "displayName", nullable = false, length = 200)
  private String displayName;

  @Column(name = "mail", nullable = false, length = 100)
  private String mail;

  @Column(name = "pnombre", nullable = false, length = 50)
  private String pnombre;

  @Column(name = "snombre", length = 50)
  private String snombre;

  @Column(name = "papellido", nullable = false, length = 50)
  private String papellido;

  @Column(name = "sapellido", length = 50)
  private String sapellido;

  @Column(name = "password", length = 255, nullable = false)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "rolesAplicacion", length = 30)
  private RolesAplicacion rolesAplicacion;

  public User() {}

  public User(String mail, String password, RolesAplicacion rolesAplicacion) {
    this.mail = mail;
    this.password = password;
    this.rolesAplicacion = rolesAplicacion;
  }

  public User(
    Long id,
    String userName,
    String ccid,
    String displayName,
    String mail,
    String pnombre,
    String snombre,
    String papellido,
    String sapellido,
    String password,
    RolesAplicacion rolesAplicacion
  ) {
    this.id = id;
    this.userName = userName;
    this.ccid = ccid;
    this.displayName = displayName;
    this.mail = mail;
    this.pnombre = pnombre;
    this.snombre = snombre;
    this.papellido = papellido;
    this.sapellido = sapellido;
    this.password = password;
    this.rolesAplicacion = rolesAplicacion;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getCcid() {
    return this.ccid;
  }

  public void setCcid(String ccid) {
    this.ccid = ccid;
  }

  public String getDisplayName() {
    return this.displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getMail() {
    return this.mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getPnombre() {
    return this.pnombre;
  }

  public void setPnombre(String pnombre) {
    this.pnombre = pnombre;
  }

  public String getSnombre() {
    return this.snombre;
  }

  public void setSnombre(String snombre) {
    this.snombre = snombre;
  }

  public String getPapellido() {
    return this.papellido;
  }

  public void setPapellido(String papellido) {
    this.papellido = papellido;
  }

  public String getSapellido() {
    return this.sapellido;
  }

  public void setSapellido(String sapellido) {
    this.sapellido = sapellido;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public RolesAplicacion getRolesAplicacion() {
    return this.rolesAplicacion;
  }

  public void setRolesAplicacion(RolesAplicacion rolesAplicacion) {
    this.rolesAplicacion = rolesAplicacion;
  }
}
